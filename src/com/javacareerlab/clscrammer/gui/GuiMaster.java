package com.javacareerlab.clscrammer.gui;

import javax.swing.SwingUtilities;

public class GuiMaster {
	
	public static void launchGui() {
		
		System.out.println("Gui is being launched.");
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// MainFrame.createAndShowFrame();
				Test001Frame.createAndShowFrame();
			}
		});
	}
}
