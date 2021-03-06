package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class PrivateDescriptionGameWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel private_description_game_panel;
	
	
	//labels
	
	private JLabel description_game_label;
	

	
	
	//buttons
	
	private JButton description_game_ok_button;
	private JButton description_game_cancel_button;

	
	//TextArea
	
	private JTextArea description_game_field;
	
	
	
	
	

	
	public PrivateDescriptionGameWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("Titel des Spiels");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.private_description_game_panel = new JPanel();
		private_description_game_panel.setLayout(null);
		
		this.description_game_label = new JLabel("Description:");
		description_game_label.setHorizontalAlignment(SwingConstants.CENTER);
		description_game_label.setLocation(6, 30);
		description_game_label.setSize(438, 20);
		
		this.description_game_ok_button = new JButton("OK");
		description_game_ok_button.setLocation(50, 231);
		description_game_ok_button.setSize(100, 20);
		
		this.description_game_cancel_button = new JButton("Cancel");
		description_game_cancel_button.setLocation(300, 231);
		description_game_cancel_button.setSize(100, 20);
		
		this.description_game_field = new JTextArea();
		description_game_field.setEditable(false);
		description_game_field.setLocation(50, 70);
		description_game_field.setSize(350, 135);

		
		
		//add elements
		
		this.private_description_game_panel.add(this.description_game_label);
		this.private_description_game_panel.add(this.description_game_field);
		this.private_description_game_panel.add(this.description_game_ok_button);
		this.private_description_game_panel.add(this.description_game_cancel_button);
		
		this.window.getContentPane().add(this.private_description_game_panel);
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{	
		
		
	}



		
}
