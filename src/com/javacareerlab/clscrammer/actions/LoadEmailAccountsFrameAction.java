package com.javacareerlab.clscrammer.actions;

import com.javacareerlab.clscrammer.gui.EmailAccountsFrame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class LoadEmailAccountsFrameAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Loading EmailAccountsFrame");
		
		// EmailAccountsFrame.c
		
		EmailAccountsFrame.createAndShowFrame();
		
	}
	
}
