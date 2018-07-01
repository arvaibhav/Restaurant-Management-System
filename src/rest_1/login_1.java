package rest_1;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
 

import javax.swing.JLabel;
 
import java.sql.*;
import java.awt.Font;
 
import java.awt.Point;
 

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

  

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;

public class login_1 {
	Conn con=new Conn();
	public static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
 
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					
					login_1 window = new login_1();
					
				
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();frame.setUndecorated(true);
		 frame.setOpacity(0.95F);
	
		
		frame.setBounds(100, 100, 473, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		
	
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			
				frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		});
		panel.setPreferredSize(new Dimension(27, 27));
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(0, 0, 473, 275);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("USERNAME");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(189, 62, 66, 14);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(189, 97, 77, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(301, 59, 149, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		
		
		passwordField.setBounds(301, 94, 149, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Statement s;
				try {
					s = con.connect.createStatement();
				 
				ResultSet rs=s.executeQuery("select * from profile");
				boolean flag=false;
				while(rs.next())
				{
					if(rs.getString(2).equals(textField.getText())&&rs.getString(3).equals(passwordField.getText()))
						flag=true;
				}
				if(flag==true)
					{frame.dispose();
				Food_management f=new Food_management();
				f.frame.setVisible(true);}
				else
					btnNewButton.setText("Retry");
			}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
			}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(72, 209, 204));
		btnNewButton.setBounds(301, 132, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Sign_up c=new Sign_up();
				c.frame.setVisible(true);
				
			}
		});
		btnSignUp.setForeground(new Color(72, 209, 204));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignUp.setBounds(301, 166, 89, 23);
		panel.add(btnSignUp);
		
		JLabel ffp = new JLabel("FORGET PASSWORD");
		ffp.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		ffp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				fpp pp=new fpp();
				pp.frame.setVisible(true);
				
			}
		});


		ffp.setForeground(new Color(255, 0, 0));
		ffp.setBounds(336, 250, 127, 14);
		panel.add(ffp);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				Point p=frame.getLocationOnScreen();
				surem s=new surem();
		
				s.jd.setLocation(p.x+70,p.y+85);
				s.jd.setVisible(true);
		
			
			}});
		
		
		
		
		
		
		
		
		lblX.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 19));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(433, 0, 52, 34);
		panel.add(lblX);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 255, 275);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setBackground(new Color(0, 204, 102));
		lblNewLabel.setIcon(new ImageIcon(login_1.class.getResource("/images/images/user-6.png")));
		lblNewLabel.setBounds(-131, 0, 386, 409);
		panel_1.add(lblNewLabel);
		
		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{	Statement s;
				try {
					s = con.connect.createStatement();
				 
				ResultSet rs=s.executeQuery("select * from profile");
				boolean flag=false;
				String key="k";
				String name="user";
				while(rs.next())
				{
					if(rs.getString(2).equals(textField.getText())&&rs.getString(3).equals(passwordField.getText()))
					{	flag=true;key=rs.getString(4);name=rs.getString(1);}
					
				}
				if(flag==true)
					{frame.dispose();
					
					if(key.charAt(0)=='m')
				{Manager f=new Manager();
				
				f.frame.setVisible(true);f.lblUser.setText(name);}
					else	if(key.charAt(0)=='d')
					{	DESK f=new DESK();
						f.frame.setVisible(true);
						f.lblUser.setText(name);
					}
					else
					{
						Food_management f=new Food_management();
						f.frame.setVisible(true);f.lblUser.setText(name);
					}
					}
				else
					btnNewButton.setText("Retry");
			}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				
				}}
		});
		
	 
	}
}
