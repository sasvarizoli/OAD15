package oadgui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import oad.GUIController;
import oad.Program;
import oad.session;

import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class AdminWindow extends Window{
	//elements
	
	//labels
	private JLabel search_label; 
	private JLabel search_notification_label;
	
	//panels
	private JPanel master_container;
	
	private JPanel user_panel;
	private JPanel user_table_panel;
	private JPanel user_buttons_panel;
	private JPanel user_search_panel;
	
	private JPanel game_panel;
	private JPanel game_table_panel;
	private JPanel game_buttons_panel;
	
	private JPanel notification_panel;
	private JPanel notification_table_panel;
	private JPanel notification_buttons_panel;
	private JPanel notification_search_panel;
	
	
	//buttons
	private JButton delete_user;
	private JButton reset_user_passwort;
	private JButton send_user_message;
	private JButton search_user;
	
	private JButton delete_game;
	
	private JButton answer_notification;
	private JButton delete_notification;
	private JButton search_notification;
	
	
	//table
	public JTable user_table;
	public JTable game_table;
	public JTable notification_table;
	
	
	//textfields
	
	public JTabbedPane admin_pane;
	public JTextField search_user_field;
	public JTextField search_notification_field;
	
	//vars
	public UserTableModel user_table_content;
	public GameTableModel game_table_content;
	private JButton btnRefresh;
	private JButton btnResetRating;
	
	public AdminWindow(){
		
		//setup frame
		init();
		this.setName("Admin-Window");
		this.setSize(800, 600);
		this.initSize();
		
		//setup elements
		
		this.master_container = new JPanel(new CardLayout());
		
		this.user_panel = new JPanel();
		user_panel.setLayout(new BorderLayout(5, 5));
		
		this.user_buttons_panel = new JPanel();
		user_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		user_buttons_panel.setLayout(new BoxLayout(user_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.user_search_panel = new JPanel();
		user_search_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		user_search_panel.setLayout(new BoxLayout(user_search_panel, BoxLayout.LINE_AXIS));
		
		this.user_table_panel = new JPanel();
		user_table_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		user_table_panel.setLayout(new BorderLayout(0, 0));
		
		
		this.game_panel = new JPanel();
		game_panel.setLayout(new BorderLayout(5, 5));
		
		this.game_buttons_panel = new JPanel();
		game_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		game_buttons_panel.setLayout(new BoxLayout(game_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.game_table_panel = new JPanel();
		game_table_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		game_table_panel.setLayout(new BorderLayout(0, 0));
		
		this.notification_panel = new JPanel();
		notification_panel.setLayout(new BorderLayout(5, 5));
		
		this.notification_table_panel = new JPanel();
		notification_table_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		notification_table_panel.setLayout(new BorderLayout(0, 0));
		
		this.notification_buttons_panel = new JPanel();
		notification_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		notification_buttons_panel.setLayout(new BoxLayout(notification_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.notification_search_panel = new JPanel();
		notification_search_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		notification_search_panel.setLayout(new BoxLayout(notification_search_panel, BoxLayout.LINE_AXIS));
		
		
		this.delete_user = new JButton("Delete User");
		this.reset_user_passwort = new JButton("Reset User Password");
		this.send_user_message = new JButton("Send User Message");
		this.search_user = new JButton("Search");

		this.delete_game = new JButton("Delete Game");
		
		this.answer_notification = new JButton("Answer");
		this.delete_notification = new JButton("Delete");
		this.search_notification = new JButton("Search");
		
		
		this.search_label = new JLabel("Enter Nickname:");
		this.search_notification_label = new JLabel("Enter Message:");
		
		
		this.admin_pane = new JTabbedPane();
		
		this.search_user_field = new JTextField();
		this.search_notification_field = new JTextField();
		user_table_content = new UserTableModel(null);
		this.user_table = new JTable(user_table_content.getData(), user_table_content.columnNames);
		this.user_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.game_table = new JTable(new String[][] {{"","","","",""}}, GameTableModel.columnNames);
		game_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		this.game_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.notification_table = new JTable();
		notification_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		//add elements
		
		this.admin_pane.addTab("User", user_panel);
		
		this.user_buttons_panel.add(this.delete_user);
		this.user_buttons_panel.add(this.reset_user_passwort);
		this.user_buttons_panel.add(this.send_user_message);
		
		this.user_search_panel.add(this.search_label);
		this.user_search_panel.add(this.search_user_field);
		this.user_search_panel.add(this.search_user);
		
		this.user_table_panel.add(this.user_table, BorderLayout.CENTER);
		this.user_table_panel.add(user_table.getTableHeader(), BorderLayout.NORTH);
		
		this.user_panel.add(this.user_buttons_panel, BorderLayout.EAST);
		this.user_panel.add(this.user_search_panel, BorderLayout.NORTH);
		this.user_panel.add(this.user_table_panel, BorderLayout.CENTER);
		
		
		this.admin_pane.addTab("Game", game_panel);
		
		btnRefresh = new JButton("Refresh");
		game_buttons_panel.add(btnRefresh);
		
		this.game_buttons_panel.add(this.delete_game);
		
		this.game_table_panel.add(this.game_table, BorderLayout.CENTER);
		this.game_table_panel.add(game_table.getTableHeader(), BorderLayout.NORTH);
		
		this.game_panel.add(this.game_table_panel, BorderLayout.CENTER);
		this.game_panel.add(this.game_buttons_panel, BorderLayout.EAST);
		
		btnResetRating = new JButton("Reset Rating");
		game_buttons_panel.add(btnResetRating);
		
		
		
		this.admin_pane.addTab("Notification", notification_panel);
		
		this.notification_search_panel.add(this.search_notification_label);
		this.notification_search_panel.add(this.search_notification_field);
		this.notification_search_panel.add(this.search_notification);
		
		this.notification_buttons_panel.add(this.answer_notification);
		this.notification_buttons_panel.add(this.delete_notification);
		
		this.notification_table_panel.add(this.notification_table, BorderLayout.CENTER);
		this.notification_table_panel.add(this.notification_table.getTableHeader(), BorderLayout.NORTH);
		
		this.notification_panel.add(this.notification_search_panel, BorderLayout.NORTH);
		this.notification_panel.add(this.notification_buttons_panel, BorderLayout.EAST);
		this.notification_panel.add(this.notification_table_panel, BorderLayout.CENTER);
		
		this.master_container.add(this.admin_pane);
		
		this.window.getContentPane().add(this.master_container);
		
		
		this.initListeners();
	}

	
	
	private void initListeners(){
		this.search_user.addActionListener(GUIController.search_users);
		this.delete_user.addActionListener(GUIController.delete_user);
		this.reset_user_passwort.addActionListener(GUIController.resetPW);
		this.btnRefresh.addActionListener(GUIController.search_game);
		this.delete_game.addActionListener(GUIController.delete_game);
		this.btnResetRating.addActionListener(GUIController.reset_rating);
	}
	
}
