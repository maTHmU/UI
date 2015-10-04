package shell.model.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AttributeSet {

	protected ArrayList<Attribute> attributeSet;

	protected HashMap<String, String> valueMap;

	public AttributeSet() {
		attributeSet = new ArrayList<Attribute>();
		valueMap = new HashMap<String, String>();
	}

	public AttributeSet(Attribute attribute) {
		this();
		addAttribute(attribute);
	}

	public AttributeSet(ArrayList<Attribute> set) {
		this();
		addAttributeSet(set);
	}

	public void addAttribute(Attribute attribute) {
		Iterator<Attribute> it = attributeSet.listIterator();
		while (it.hasNext()) {
			Attribute tempAttribute = it.next();
			if (tempAttribute.isSameAttribute(attribute)) {
				tempAttribute.setAttribute(attribute);
				valueMap.remove(attribute.getName());
				valueMap.put(attribute.getName(), attribute.getValue());
				return;
			}
		}
		attributeSet.add(attribute);
		valueMap.put(attribute.getName(), attribute.getValue());
	}

	public void addAttributeSet(ArrayList<Attribute> set) {
		Iterator<Attribute> it = set.listIterator();
		while (it.hasNext()) {
			Attribute attribute = it.next();
			addAttribute(attribute);
		}
	}

	public String getValueByName(String name) {
		return valueMap.get(name);
	}

	public int getAttributeCount() {
		return attributeSet.size();
	}

	public ArrayList<Attribute> getAttributes() {
		return attributeSet;
	}

	public Attribute getAttribute(int no) {
		return attributeSet.get(no);
	}

}
