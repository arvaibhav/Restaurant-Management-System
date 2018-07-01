package rest_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class fpp {
	Conn con=new  Conn();
public JFrame frame;
private JTextField textField;
private JTextField textField_1;
private JPasswordField passwordField;
private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */


	
	public fpp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		});
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 255, 127));
		frame.setBounds(100, 100, 448, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(191, 69, 192, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(52, 69, 83, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("secure key");
		lblPassword.setBounds(52, 100, 83, 14);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				
				try {
				Statement s=con.connect.createStatement();
				
				ResultSet rs=s.executeQuery("select * from profile");
				boolean flag=false;
				while(rs.next())
				{
					if(textField_1.getText().equals(rs.getString(4))&&textField.getText().equals(rs.getString(2)))
						flag=true;
						
				}
					if(flag==true)
					{
						passwordField.setEnabled(true);
						passwordField_1.setEnabled(true);
					}
					
					
					}
				catch(Exception em)
				{
					JOptionPane.showMessageDialog(null,em);
				}
					}
			
		});




		textField_1.setColumns(10);
		textField_1.setBounds(191, 100, 192, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblPassword_1 = new JLabel("password");
		lblPassword_1.setBounds(52, 128, 83, 14);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblConfirm = new JLabel("confirm");
		lblConfirm.setBounds(52, 156, 83, 14);
		frame.getContentPane().add(lblConfirm);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		passwordField.setEnabled(false);
		passwordField.setBounds(191, 131, 192, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				
				try{
					
					Statement c=con.connect.createStatement();
					String pass=new String(passwordField.getPassword());
					String q=String.format("update profile  set password = '%s' where username='%s'",pass,textField.getText());
					JOptionPane.showMessageDialog(frame,
                            "Password is " + pass);
					c.executeUpdate(q);
				}
				catch(Exception e)
				{
					
				}
				
			}
		});
		
		passwordField_1.setEnabled(false);
		passwordField_1.setBounds(191, 156, 192, 20);
		frame.getContentPane().add(passwordField_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 44, 448, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn = new JButton("reset");
		btn.setEnabled(false);
		btn.setBounds(252, 166, 89, 23);
		panel.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_1.getText()))
				
					{btn.setText("Login");btn.setEnabled(true);
					}
				else
					{btn.setForeground(Color.RED);btn.setText("Check");}
				 
			}
		});
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
Point p=frame.getLocationOnScreen();
				
		
				
				frame.dispose();
				login_1 l=new login_1();
		
				l.frame.setLocation(p.x+70,p.y+85);
				l.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 0, 29, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Reset Password");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 19));
		lblNewLabel_1.setBounds(147, 11, 164, 22);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
