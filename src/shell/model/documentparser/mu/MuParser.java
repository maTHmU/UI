package shell.model.documentparser.mu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import shell.ShellFile;
import shell.model.document.Document;
import shell.model.documentparser.DocumentParser;
import shell.model.documentparser.ParserManager;

public class MuParser extends DocumentParser {

	private static final char ALIAS_CODE = '\\';

	private static final char QUOTE_CODE = '\"';

	private static final char BOX_START_CODE = '[';

	private static final char BOX_END_CODE = ']';

	private static final char LIST_START_CODE = '{';

	private static final char LIST_END_CODE = '}';

	private static final char EQUAL_CODE = '=';

	private static final char COMMA_CODE = ',';

	private static final boolean isSpace(char code) {
		return code == ' ';
	}

	public MuParser(ParserManager parserManager) {
		this.parserManager = parserManager;
		this.priority = 10;
	}

	@Override
	public Document parseFile(String filePath) {
		try {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			return parseFile(reader);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Document parseFile(Reader reader) {
		try {
			BufferedReader input = (BufferedReader)reader;
			StringBuffer text = new StringBuffer();
			while (true) {
				String temp = input.readLine();
				if (temp != null) {
					text.append(temp);
				} else {
					break;
				}
			}
			return parse(text.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected Document parse(String text) {
		ShellFile shellFile = parserManager.getShellFile();
		Document document = new Document(shellFile);
		Stack<Document> stack = new Stack<Document>();
		stack.add(document);
		boolean inQuote = false;
		boolean inAlias = false;
		String attributeName = "";
		StringBuffer token = new StringBuffer();
		for (int l = 0; l < text.length(); l++) {
			char next = text.charAt(l);
			if (inAlias) {
				if (next == '[') {
					int end = l + 1;
					while (text.charAt(end) != ']') {
						end ++;
					}
					
					l = end;
				} else if (next == '.') {
					l += 2;
				} else if (next == ':') {
					l += 4;
				}
				inAlias = false;
			} else {
				if (next == ALIAS_CODE) {
					if (inQuote) {
						inAlias = true;
					} else {
						// ignore
					}
				} else if (next == QUOTE_CODE) {
					if (inQuote) {
						if (!attributeName.isEmpty()) {
							stack.peek().addAttribute(attributeName, token.toString());
							attributeName = "";
						} else {
							Document newDocument = new Document(shellFile, "StringBox");
							newDocument.addAttribute("Text", token.toString());
							stack.peek().addChild(newDocument);
						}
						token.delete(0, token.length());
						inQuote = false;
					} else {
						inQuote = true;
					}
				} else if (next == BOX_START_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						Document newDocument = new Document(shellFile, token.toString());
						stack.peek().addChild(newDocument);
						token.delete(0, token.length());
						stack.push(newDocument);
					}
				} else if (next == BOX_END_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						stack.pop();
					}
				} else if (next == LIST_START_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						Document newDocument = new Document(shellFile, "List");
						stack.peek().addChild(newDocument);
						token.delete(0, token.length());
						stack.push(newDocument);
					}
				} else if (next == LIST_END_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						stack.pop();
					}
				} else if (next == EQUAL_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						attributeName = token.toString();
						token.delete(0, token.length());
					}
				} else if (next == COMMA_CODE) {
					if (inQuote) {
						token.append(next);
					} else {
						
					}
				} else if (isSpace(next)) {
					if (inQuote) {
						token.append(next);
					} else {
						// Ignore
					}
				} else {
					token.append(next);
					// TODO: Any other conditions?
				}
			}
		}
		return document.getChild(0);
	}

}
