
package com.javacareerlab.clscrammer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.BoxLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import com.javacareerlab.clscrammer.WebPage;

		
public class HarvestTester extends JFrame {

	private JPanel contentPane;

	public HarvestTester() {
	
	
	
		this.initFrame();
	
	
	}
	
	/* - - - - - - - - - - - - */
	
	private void initFrame() {
	
		this.setTitle("Harvest Tester");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = new JPanel();  // BoxLayout     (new BoxLayout())
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
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
		
		/* - - - - - - - - - - */
		// add a go button
		/* - - - - - - - - - - */
		
		JButton goButton;
		// goButton = new JButton("Go!");
		goButton = new JButton(new GoAction());
		this.contentPane.add(goButton);
		
		
		/* - - - - - - - - - - */
		// add a grid
		/* - - - - - - - - - - */
		
		this.contentPane.add(this.getGrid());
		
		
		
		
		
		
		
		
	}
	
	/* - - - - - - - - - - - - */
	
	private JPanel getGrid() {
	
		JPanel myGrid;
		
		myGrid = new JPanel(new GridLayout(2, 2));
	
		myGrid.add(new JLabel("Foo:"));
		myGrid.add(new JLabel("foo value"));
		myGrid.add(new JLabel("Bar:"));
		myGrid.add(new JLabel("bar value"));
	
		return myGrid;
	}
	
	/* - - - - - - - - - - - - */
	
	
	
	/* - - - - - - - - - - - - */
	
	
	
	/* - - - - - - - - - - - - */
	
	
	
	/* - - - - - - - - - - - - */
	
	// define an inner class
	// - must extend AbstractAction ( an abstract class )
	
	private class GoAction extends AbstractAction {
	
		/* Constructor 1 */
		
		public GoAction() {
			super("Click Me Seymour!");
			this.putValue(SHORT_DESCRIPTION, "Click me Seymour and prepare to be amazed!");
			this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		}
	
		/* Constructor 2 */
		
		public GoAction(String text, String desc, Integer mnemonic) {
			super(text);
			this.putValue(SHORT_DESCRIPTION, desc);
			this.putValue(MNEMONIC_KEY, mnemonic);
		}
		
		/* Constructor 3 */
		
		public GoAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			this.putValue(SHORT_DESCRIPTION, desc);
			this.putValue(MNEMONIC_KEY, mnemonic);
		}
		
		/* - - - - - - - - - - - - */
		
		public void actionPerformed(ActionEvent ae) {
		
			// System.out.println("say wha?");
		
			System.out.println((String) this.getValue(SHORT_DESCRIPTION));
			
			// create a harvester object
			
			WebPage myWebPage;
			
			myWebPage = new WebPage();
			
			// http://memphis.craigslist.org/boa/4297616659.html
			// http://memphis.craigslist.org/boo/
			
			myWebPage.setUrl("http://memphis.craigslist.org/boa/4297616659.html");
			
			myWebPage.displayInfo();
			
			
			// run some of the harvester object's methods.
			
			
			
			
			
		
		}
	
	
	
	}
	
	/* - - - - - - - - - - - - */

}
