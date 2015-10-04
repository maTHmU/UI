package framework.mycomponents;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {   

	protected String suffix;

	protected String description;

	public MyFileFilter(String suffix, String description) {
		this.suffix = suffix;
		this.description = description;
	}

	@Override
	public boolean accept(File file) {   
		return (file.isDirectory() || file.getPath().toLowerCase().endsWith("." + suffix));   
	}   

	@Override
	public String getDescription() {   
		return description;
	}   

}   

