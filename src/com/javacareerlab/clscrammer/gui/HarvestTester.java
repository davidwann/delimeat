
package com.javacareerlab.clscrammer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
		
public class HarvestTester extends JFrame {

	private JPanel contentPane;

	public HarvestTester() {
	
	
	
		this.initFrame();
	
	
	}
	
	/* - - - - - - - - - - - - */
	
	private void initFrame() {
	
		this.setTitle("Harvest Tester");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = new JPanel();
		
		this.addWidgets();
		
		this.setContentPane(contentPane);
		this.pack();
	}
	
	/* - - - - - - - - - - - - */
	
	private void addWidgets() {
	
		// add a combo box
		
		JComboBox cities;
		DefaultComboBoxModel<String> model;
		
		// - - - - - - - - - - - - - - - - - -
		
		cities = new JComboBox();
		model = new DefaultComboBoxModel<String>();
		
		model.addElement("Memphis");
		model.addElement("Little Rock");
		model.addElement("Jonesboro");
		model.addElement("Nashville");
		model.addElement("Atlanta");
		model.addElement("Chicago");
		model.addElement("Phoenix");
		model.addElement("Paragould");
		
		cities.setModel(model);
		
		this.contentPane.add(cities);
	}
	
	/* - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - */
	



}
