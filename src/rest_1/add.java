package rest_1;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import java.sql.Statement;

 
import javax.swing.JPanel;
 
import javax.swing.JButton;
 
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
 
import java.awt.Component;

public class add extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	  JDialog jd;
	  JButton btnCancel ;JButton btnYes;
 JTextField sno;
 JTextField food;
 JTextField raw;
 JTextField sell;Conn con=new Conn();
  JLabel profit;
 
	/**
	 * Launch the application.
	 */
  

	/**
	 * Create the frame.
	 */
	public add() {
		
		jd=new JDialog();
		jd.setModal(true);
			jd.setResizable(false);
			jd.setFocusTraversalPolicyProvider(true);
			jd.setAutoRequestFocus(false);
			jd.setAlwaysOnTop(true);
			jd.setType(Type.POPUP);
			jd.setAlwaysOnTop(true);

			jd.getContentPane().setBackground(new Color(184, 134, 11));
			jd.getContentPane().setLayout(null);
			
			profit = new JLabel("Profit is:");
			profit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
			profit.setBounds(94, 178, 220, 20);
			jd.getContentPane().add(profit);
			
			sno = new JTextField();
			sno.setBounds(158, 12, 46, 20);
			jd.getContentPane().add(sno);
			sno.setColumns(10);
			
			sell = new JTextField();
			sell.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					sell.setSelectedTextColor(Color.blue);
					sell.setSelectionColor(Color.LIGHT_GRAY);
					sell.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					 
					sell.setSelectedTextColor(Color.black);
					sell.setSelectionColor(Color.white);
					sell.setSelectionStart(0);
				
			}
			});
			
			sell.setColumns(10);
			sell.setBounds(84, 139, 220, 20);
			jd.getContentPane().add(sell);
			
			raw = new JTextField();
			raw.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					raw.setSelectedTextColor(Color.blue);
					raw.setSelectionColor(Color.LIGHT_GRAY);
					raw.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					 
					raw.setSelectedTextColor(Color.black);
					raw.setSelectionColor(Color.white);
					raw.setSelectionStart(0);
				
			}
			});
			raw.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					try {
						profit.setText(Integer.toString(((Integer.parseInt(sell.getText()))-(Integer.parseInt(raw.getText())))));	
						btnYes.setEnabled(true);
							}
							catch(Exception e)
							{
								profit.setText("enter number");
							}
						
				}
			});
			raw.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
			raw.setColumns(10);
			raw.setBounds(84, 95, 220, 20);
			jd.getContentPane().add(raw);
			
			food = new JTextField();
			food.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					food.setSelectedTextColor(Color.blue);
					food.setSelectionColor(Color.LIGHT_GRAY);
					food.setSelectionStart(0);
				}
				@Override
				public void focusLost(FocusEvent e) {
					 
						food.setSelectedTextColor(Color.black);
						food.setSelectionColor(Color.white);
						food.setSelectionStart(0);
					
				}
			});
			
			food.setColumns(10);
			food.setBounds(84, 53, 220, 20);
			jd.getContentPane().add(food);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 231, 328, 36);
			jd.getContentPane().add(panel);
			panel.setLayout(null);
			 btnYes = new JButton("Add");
			 btnYes.setEnabled(false);
			
		
			btnYes.setBounds(141, 0, 89, 23);
			panel.add(btnYes);	jd.getContentPane().add(panel);
			panel.setLayout(null);
			
			 btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.dispose();
					
				}
			});
			btnCancel.setBounds(239, 0, 89, 23);
			panel.add(btnCancel);
			
			JLabel lblSno = new JLabel("S.no");
			lblSno.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblSno.setBounds(127, 15, 46, 14);
			jd.getContentPane().add(lblSno);
			
			JLabel lblFood = new JLabel("Food");
			lblFood.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblFood.setBounds(26, 56, 46, 14);
			jd.getContentPane().add(lblFood);
			
			JLabel lblRaw = new JLabel("RAW");
			lblRaw.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblRaw.setBounds(26, 98, 46, 14);
			jd.getContentPane().add(lblRaw);
			
			JLabel lblSellPrice = new JLabel("Sell Price");
			lblSellPrice.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblSellPrice.setBounds(26, 142, 65, 14);
			jd.getContentPane().add(lblSellPrice);
			
			JLabel lblProfit = new JLabel("Profit");
			lblProfit.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblProfit.setBounds(26, 183, 46, 14);
			jd.getContentPane().add(lblProfit);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setIcon(new ImageIcon(add.class.getResource("/images/images/push-pin.png")));
			lblNewLabel.setBounds(-73, -15, 401, 298);
			jd.getContentPane().add(lblNewLabel);
			
			jd.setUndecorated(true);jd.setOpacity(0.8f);
			jd.setBounds(300, 500, 327, 266);
			jd.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{food, raw, sell}));
			
			
			
			
			
			jd.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
				
					jd.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
				
				}
			}); 
			
			sell.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					try {
				profit.setText(Integer.toString(((Integer.parseInt(sell.getText()))-(Integer.parseInt(raw.getText())))));	
				btnYes.setEnabled(true);
					}
					catch(Exception e)
					{
						profit.setText("enter number");
					}
				}
				@Override
				public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
					if(profit.getText().equals("enter number")!=true)
					btnYes.doClick();
				}
			});
			 btnYes.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent arg0) {
			 		if(btnYes.getText().equals("Delete"))
			 			try {
			 				
			 			
			 				
			 				Statement s=con.connect.createStatement();
			 				String q=String.format("delete from Foodd where ID=%d",Integer.parseInt(sno.getText()));
			 				
			 				s.executeUpdate(q);
			 				lblNewLabel.setText("updated");
			 				lblNewLabel.setForeground(Color.RED);
			 				lblNewLabel.setVisible(true);jd.setVisible(false);
			 				JOptionPane.showMessageDialog(null, " Row Deleted "+sno.getText());
			 				
			 				
			 				
			 				
			 			
			 			} catch (Exception e) {
			 				 
			 				JOptionPane.showMessageDialog(null, " problem");
			 				System.out.println("...........");
			 				e.printStackTrace();
			 				System.out.println("............");
			 			}
			 				 	
			 				 	
			 	
			 		if(btnYes.getText().equals("Update"))
			 			try {
			 				
			 				
			 				
			 				
			 				btnYes.setEnabled(true);
			 				Statement s=con.connect.createStatement();
			 				String q=String.format("update Foodd set food='%s',raw='%s',price='%s' where ID=%d",food.getText(),raw.getText(),sell.getText(),Integer.parseInt(sno.getText()));
			 				
			 				s.executeUpdate(q);
			 				lblNewLabel.setText("updated");
			 				lblNewLabel.setForeground(Color.RED);
			 				lblNewLabel.setVisible(true);jd.setVisible(false);
			 				JOptionPane.showMessageDialog(null, " data Updated "+sno.getText());
			 				
			 				
			 				
			 				
			 			
			 			} catch (Exception e) {
			 				 
			 				JOptionPane.showMessageDialog(null, " problem");
			 			 
			 				e.printStackTrace();
			 			 
			 			}
			 				 	
			 	
			
		if(btnYes.getText().equals("Insert"))
		try {
			Statement s=con.connect.createStatement();
			String q=String.format("insert into Foodd (food,raw,price,ID) values ('%s','%s','%s',%s)",food.getText(),raw.getText(),sell.getText(),sno.getText());
			
			s.executeUpdate(q);
			 
			lblNewLabel.setVisible(true);jd.setVisible(false);
			JOptionPane.showMessageDialog(null, " inserted");
			
			
		
		} catch (Exception e) {
			 
			JOptionPane.showMessageDialog(null, " problem");
			System.out.println("...........");
			e.printStackTrace();
			System.out.println("............");
		}
		
			 	}
		 });
			food.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
						{btnYes.setEnabled(true);btnYes.doClick();}
				}
			});
			
			
	}
}
