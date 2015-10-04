package common;

import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class SystemOperations {

	public static final int MAX_OPERATOR_NUMBER = 10;

	public static String getClipboardString(Component comp) {
		Clipboard clipboard = comp.getToolkit().getSystemClipboard();
		Transferable content = clipboard.getContents(comp);
		DataFlavor flavor = DataFlavor.stringFlavor;   
		if (content.isDataFlavorSupported(flavor)) {
			try {
				String str = (String)content.getTransferData(flavor);
				return str;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void setClipboardString(Component comp, String str) {
		Clipboard clipboard = comp.getToolkit().getSystemClipboard();
		StringSelection text = new StringSelection(str);
		clipboard.setContents(text, null);
	}

	public static BufferedImage getIconImage(String fileName) {
		try {
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(
					fileName.substring(fileName.lastIndexOf('.') + 1));
			ImageReader reader = it.next();
			File f = new File(fileName);
			ImageInputStream imageIn = ImageIO.createImageInputStream(f);
			reader.setInput(imageIn);
			return reader.read(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ImageIcon getImageIcon(String fileName) {
		BufferedImage image = getIconImage(fileName);
		if (image == null) {
			return null;
		} else {
			return new ImageIcon(image);
		}
	}

}
