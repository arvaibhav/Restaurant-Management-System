package rest_1;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;



import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class Sign_up {
	Conn con=new Conn();
	public JFrame frame;
	private JTextField namefield;
	private JTextField phonefield;
	private JTextField usernamefield;
	private JPasswordField passwordField;
	private JPasswordField conf;
	private JTextField keytextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Sign_up() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 515, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 0, 515, 357);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(46, 80, 46, 14);
		panel.add(lblName);
		
		namefield = new JTextField();
		namefield.setBounds(126, 77, 326, 20);
		panel.add(namefield);
		namefield.setColumns(10);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(46, 116, 46, 14);
		panel.add(lblPhone);
		
		phonefield = new JTextField();
		phonefield.setColumns(10);
		phonefield.setBounds(126, 113, 326, 20);
		panel.add(phonefield);
		
		JLabel lblKey = new JLabel("key");
		lblKey.setBounds(46, 147, 46, 14);
		panel.add(lblKey);
		
		JLabel lblConfirm = new JLabel("confirm");
		lblConfirm.setBounds(46, 253, 70, 14);
		panel.add(lblConfirm);
		
		usernamefield = new JTextField();
		usernamefield.setColumns(10);
		usernamefield.setBounds(126, 183, 326, 20);
		panel.add(usernamefield);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(46, 186, 70, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(46, 222, 70, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 219, 326, 20);
		panel.add(passwordField);
		
		conf = new JPasswordField();
	
		conf.setBounds(126, 250, 326, 20);
		panel.add(conf);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setEnabled(false);
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnSignUp.isEnabled())
				try {
					Statement s=con.connect.createStatement();
					String q=String.format("insert into profile (username,password,name,phone,key) values ('%s','%s','%s','%s','%d')",usernamefield.getText(),passwordField.getText(),namefield.getText(),phonefield.getText(),keytextField.getText());
					
					s.executeUpdate(q);
				} catch (SQLException e) {
					
				}
			}
		});
		
		conf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()!=KeyEvent.VK_ENTER)
				{if(passwordField.getText().equals(conf.getText()))
					btnSignUp.setEnabled(true);
				else
					btnSignUp.setEnabled(false);
				}
				else
					System.out.println("ff");
			}
		});
		
		
		btnSignUp.setBounds(205, 304, 89, 23);
		panel.add(btnSignUp);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			
			}
		});
		panel_1.setBounds(0, 0, 515, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign up Page");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 25));
		lblNewLabel.setBounds(161, 11, 164, 32);
		panel_1.add(lblNewLabel);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p=frame.getLocationOnScreen();
				
		
				
				frame.dispose();
				login_1 l=new login_1();
		
				l.frame.setLocation(p.x+70,p.y+85);
				l.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnBack.setBounds(0, 0, 51, 17);
		panel_1.add(btnBack);
		
		keytextField = new JTextField();
		keytextField.setBounds(126, 144, 326, 20);
		panel.add(keytextField);
		keytextField.setColumns(10);
		
		JLabel lblRequestForKey = new JLabel("Request for key");
		lblRequestForKey.setForeground(Color.RED);
		lblRequestForKey.setBounds(363, 308, 116, 14);
		panel.add(lblRequestForKey);
		
	}
}
