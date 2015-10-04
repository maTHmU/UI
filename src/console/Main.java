package console;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import common.Index;

import framework.MainFrame;

import version.Version;


public class Main {

	private static MainFrame mainFrame;

	public static void main(String[] args) {
		systemInfo();
		initFrame();
	}

	private static void systemInfo() {
		System.out.println("Project version : " + Version.getVersionName() + " .");
		System.out.println("Project created at : " + Version.getCreatedDate().toString() + " .");
		System.out.println();

		String workingDirectory = System.getProperty("user.dir");
		System.out.println("Current working directory is : " + workingDirectory + " .");
	}

	private static void initFrame() {
		new Index();
		Index.initBeforeFrameConstruction();
		mainFrame = new MainFrame();
		Index.initAfterFrameConstruction();
		changeLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel");
		mainFrame.setVisible(true);
	}

	public static void changeLookAndFeel(final String lookAndFeelName) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		   		try {
		   			UIManager.setLookAndFeel(lookAndFeelName);
		   			SwingUtilities.updateComponentTreeUI(mainFrame);
		   		} catch (Exception e) {
		   			e.printStackTrace();
		   		}
		    }
		});
	}

	public static MainFrame getMainFrame() {
		return mainFrame;
	}

}
