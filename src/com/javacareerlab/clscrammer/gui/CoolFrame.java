
package com.javacareerlab.clscrammer.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CoolFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoolFrame frame = new CoolFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoolFrame() {
		
		setTitle("Harvest City Cat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		
		contentPane.setLayout(gbl_contentPane);
		
		JLabel cityLabel = new JLabel("Select City:");
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_cityLabel = new GridBagConstraints();
		gbc_cityLabel.anchor = GridBagConstraints.WEST;
		gbc_cityLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cityLabel.gridx = 2;
		gbc_cityLabel.gridy = 0;
		contentPane.add(cityLabel, gbc_cityLabel);
		
		JComboBox cityComboBox = new JComboBox();
		cityLabel.setLabelFor(cityComboBox);
		cityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Memphis", "Jonesboro", "Little Rock", "Nashville"}));
		
		GridBagConstraints gbc_cityComboBox = new GridBagConstraints();
		
		gbc_cityComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cityComboBox.gridx = 2;
		gbc_cityComboBox.gridy = 1;
		
		contentPane.add(cityComboBox, gbc_cityComboBox);
	}

}
