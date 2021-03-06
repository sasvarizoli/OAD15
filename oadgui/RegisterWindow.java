package oadgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oad.GUIController;
import oad.User;
import oad.session;

import javax.swing.SwingConstants;

public class RegisterWindow extends Window{
	//elements
	
	//panel
	private JPanel register_panel;
	
	//labels
	private JLabel l_title;
	private JLabel l_username;
	private JLabel l_email;
	private JLabel l_pw;
	private JLabel l_pw_repeat;
	
	//buttons
	private JButton register;
	
	//textfields
	public JTextField f_username;
	public JTextField f_email;
	public JPasswordField f_pw;
	public JPasswordField f_pw_repeat;

	
	public RegisterWindow(){

		//setup frame
		init();
		this.window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setName("Register");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.register_panel = new JPanel();
		
		this.l_title = new JLabel("Register");
		l_title.setHorizontalAlignment(SwingConstants.CENTER);
		l_title.setBounds(6,6,438,20);
		
		this.l_username = new JLabel("Nickname:");
		l_username.setHorizontalAlignment(SwingConstants.RIGHT);
		l_username.setBounds(6,60,190,20);
				
		this.l_email = new JLabel("Email:");
		l_email.setHorizontalAlignment(SwingConstants.RIGHT);
		l_email.setBounds(6,92,190,20);
		
		this.l_pw = new JLabel("Password:");
		l_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		l_pw.setBounds(6,124,190,20);
		
		this.l_pw_repeat = new JLabel("Password - Repeat:");
		l_pw_repeat.setHorizontalAlignment(SwingConstants.RIGHT);
		l_pw_repeat.setBounds(6,156,190,20);
		
		this.f_username = new JTextField();
		f_username.setBounds(254,60,190,20);
		
		this.f_email = new JTextField();
		f_email.setBounds(254,92,190,20);
		
		this.f_pw = new JPasswordField();
		f_pw.setBounds(254,124,190,20);
		
		this.f_pw_repeat = new JPasswordField();
		f_pw_repeat.setBounds(254,156,190,20);
		
		this.register = new JButton("Register");
		register.setBounds(180,240,100,20);

		register_panel.setLayout(null);
		
		//add elements
		this.register_panel.add(this.l_title);
		this.register_panel.add(this.l_username);
		this.register_panel.add(this.l_email);
		this.register_panel.add(this.l_pw);
		this.register_panel.add(this.l_pw_repeat);
		this.register_panel.add(this.f_username);
		this.register_panel.add(this.f_email);
		this.register_panel.add(this.f_pw);
		this.register_panel.add(this.f_pw_repeat);
		
		this.register_panel.add(this.register);
		
		this.window.getContentPane().add(this.register_panel);

		this.initListeners();
	}
	
	private void initListeners(){
		this.register.addActionListener(GUIController.register);
	}
}
