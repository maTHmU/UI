package common;

import java.io.File;

public class FileOperations {

	public static final boolean isFileExisting(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	public static final String getPathFromFileName(String fileName) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(new File(".").getAbsolutePath());
		buffer.append(fileName);
		return buffer.toString();
	}

	public static final String getFileNameFromPath(String filePath) {
		return filePath;
	}

}
