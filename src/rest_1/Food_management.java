package rest_1;

 

import javax.swing.JFrame;
import java.awt.Color;
 

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


 
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import java.sql.SQLException;
import java.sql.Statement;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Food_management extends DefaultTableModel {
	Conn con=new Conn();
	public JFrame frame;
	private final JPanel panel = new JPanel();
	JButton btnview ;
	private JTable table;
	JLabel lblUser;
	String[][] datas()
	{int r=4;
		PreparedStatement s;
		PreparedStatement g;
		try {g = con.connect.prepareStatement("  select * from Foodd");
			int k=0;  ResultSet rd=g.executeQuery();
			  while(rd.next())
				  k=k+1;
			 r=k;
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"problem");
			
		}
		try {
			
			
			s = con.connect.prepareStatement("select * from foodd");
			
		ResultSet rs=s.executeQuery();
		
	
		
		String[][] arr=new String[r][5];

			int i=0;
				while(rs.next())
				{
					arr[i][0]=Integer.toString(i+1);
					arr[i][1]=rs.getString(1);//food
					arr[i][2]=rs.getString(2);//raw
					arr[i][3]=rs.getString(3);//price
					arr[i][4]=Integer.toString(Integer.parseInt(arr[i][3])-Integer.parseInt(arr[i][2]));
					i++;
					
				}
			 
				rs.close();
				
			
		return arr;} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return null;
		}
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Food_management() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */

	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(108,122,137));
		panel.setBounds(0, 0, 1200, 25);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectFirst = new JLabel("Select First");
		lblSelectFirst.setVisible(false);
		lblSelectFirst.setBounds(214, 52, 88, 194);
		frame.getContentPane().add(lblSelectFirst);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(194, 119, 119, 85);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Food_management.class.getResource("/images/images/speech-bubble-th.png")));
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel user = new JLabel(" Welcome:");
		user.setFont(new Font("SimSun", Font.BOLD, 17));
		user.setForeground(new Color(255, 255, 255));
		user.setBounds(0, 0, 132, 24);
		panel.add(user);
		
		lblUser = new JLabel("User");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("SimSun", Font.BOLD, 17));
		lblUser.setBounds(95, 1, 180, 24);
		panel.add(lblUser);
	
		
		
		JLabel label = new JLabel("Sign Out");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p=label.getLocationOnScreen();
				surem s=new surem();
	
				s.jd.setLocation(p.x-300,p.y+15);
				s.jd.setVisible(true);
			
			}
		});
		label.setBounds(1098, 0, 92, 24);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 23, 210, 677);
		panel_1.setBackground(new Color(244, 179, 80,80));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		 btnview = new JButton("View");
		
		
		btnview.setBackground(new Color(245, 222, 179));
		btnview.setBounds(10, 11, 190, 115);
		panel_1.add(btnview);
		
		JButton btnupdate = new JButton("Update");
		
		btnupdate.setBackground(new Color(245, 222, 179));
		btnupdate.setBounds(10, 137, 190, 115);
		panel_1.add(btnupdate);
		
		JButton btnDelete = new JButton("Delete");
		 
		
		
		btnDelete.setBounds(10, 263, 190, 115);
		panel_1.add(btnDelete);
		
		JButton btninsert = new JButton("Insert");
		
	
		
		btninsert.setBounds(10, 389, 190, 115);
		panel_1.add(btninsert);
		
		JButton btnNewButton_2 = new JButton("Print");
	
		btnNewButton_2.setBounds(58, 598, 89, 23);
		panel_1.add(btnNewButton_2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		Object[][] data=datas();
		
		
		
//////////////////////////////////////////////////////////////////////////////////
		
		
		
		
	 
	
		
		
		
		
		
		
		JLabel lblFoodManagementDetail = new JLabel("FOOD MANAGEMENT DETAIL");
		lblFoodManagementDetail.setBounds(613, 30, 247, 25);
		lblFoodManagementDetail.setForeground(new Color(244,179,80));
		lblFoodManagementDetail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(lblFoodManagementDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 66, 970, 604);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				btnupdate.doClick();
			}
		});
		scrollPane.setViewportView(table);
	
	 	DefaultTableModel model=new DefaultTableModel(
				data,
				new String[] {
					"S.no", "Food", "Raw Material Cost", "Selling Price", "Profit"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
				table.setModel(model);
				
				JLabel lblNewLabel_1 = new JLabel("Credit:Vaibhav Jain");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(1074, 681, 116, 14);
				frame.getContentPane().add(lblNewLabel_1);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(35);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(251);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(122);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setResizable(false);table.getColumnModel().setColumnSelectionAllowed(true);
		frame.setUndecorated(true);
		frame.setBounds(100, 25, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		add ev=new add();
		 
		 
			 
				btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
					  
			          table.print();
			        } catch (PrinterException pe) {
			          System.err.println("Error printing: " + pe.getMessage());
			        }
			      }
			
		});
				btnDelete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					
							 add z=new add();
						int k=table.getSelectedColumn();
						int l=table.getSelectedRow();
						
						
						if(k==-1)
							{
							
							lblNewLabel.setVisible(true);
							lblSelectFirst.setVisible(true);
							java.awt.Toolkit.getDefaultToolkit().beep();
							}
						else
							
						{	lblNewLabel.setVisible(false);
						lblSelectFirst.setVisible(false);
							
							z.sno.setEditable(false);
						z.btnYes.setText("Delete"); 
						
												
						
						Point p=table.getLocationOnScreen();
							if(k==0)
						{	p.setLocation(p.getX()-20, p.getY()-77+(l)*15);
						z.sno.setText(table.getValueAt(l, 0).toString());
						z.food.setText(table.getValueAt(l, 1).toString());
						z.raw.setText(table.getValueAt(l, 2).toString());
						z.sell.setText(table.getValueAt(l, 3).toString());
						
						z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
						}
							if(k==1)
								{p.setLocation(p.getX()+55, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
								if(k==2)
								{	p.setLocation(p.getX()+100, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
								if(k==3)
								{		p.setLocation(p.getX()+290, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));}
								if(k==4)
								{
									p.setLocation(p.getX()+450, p.getY()-77+(l)*15);
									z.sno.setText(table.getValueAt(l, 0).toString());
									z.food.setText(table.getValueAt(l, 1).toString());
									z.raw.setText(table.getValueAt(l, 2).toString());
									z.sell.setText(table.getValueAt(l, 3).toString());
									
									z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
					
						 
						z.jd.setLocation(p.x+70,p.y+85);
						 
						z.jd.setVisible(true);
						
						if(z.jd.isVisible()==false)
						{ try {
						
						Statement s=con.connect.createStatement();
						
					String q=String.format("update Foodd set ID=ID-1 where ID>%d",Integer.parseInt(z.sno.getText()));
		 				
		 				s.executeUpdate(q);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							btnview.doClick();
						}
							
						}		 
					}
				});
				 
				 			add z=new add();
				btnupdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						int k=table.getSelectedColumn();
						int l=table.getSelectedRow();
						
						if(k==-1)
							{
							lblNewLabel.setVisible(true);
							lblSelectFirst.setVisible(true);
							java.awt.Toolkit.getDefaultToolkit().beep();
							}
						else
							
						{	lblNewLabel.setVisible(false);
						lblSelectFirst.setVisible(false);
							z.sno.setEditable(false);
						z.btnYes.setText("Update"); 
						
												
						
						Point p=table.getLocationOnScreen();
							if(k==0)
						{	p.setLocation(p.getX()-20, p.getY()-77+(l)*15);
						z.sno.setText(table.getValueAt(l, 0).toString());
						z.food.setText(table.getValueAt(l, 1).toString());
						z.raw.setText(table.getValueAt(l, 2).toString());
						z.sell.setText(table.getValueAt(l, 3).toString());
						
						z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
						}
							if(k==1)
								{p.setLocation(p.getX()+55, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
								if(k==2)
								{	p.setLocation(p.getX()+100, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
								if(k==3)
								{		p.setLocation(p.getX()+290, p.getY()-77+(l)*15);
								z.sno.setText(table.getValueAt(l, 0).toString());
								z.food.setText(table.getValueAt(l, 1).toString());
								z.raw.setText(table.getValueAt(l, 2).toString());
								z.sell.setText(table.getValueAt(l, 3).toString());
								
								z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));}
								if(k==4)
								{
									p.setLocation(p.getX()+450, p.getY()-77+(l)*15);
									z.sno.setText(table.getValueAt(l, 0).toString());
									z.food.setText(table.getValueAt(l, 1).toString());
									z.raw.setText(table.getValueAt(l, 2).toString());
									z.sell.setText(table.getValueAt(l, 3).toString());
									
									z.profit.setText(Integer.toString((Integer.parseInt(z.sell.getText())-Integer.parseInt(z.raw.getText()))));
								}
					
						 
						z.jd.setLocation(p.x+70,p.y+85);
						 
						z.jd.setVisible(true);
						if(z.jd.isVisible()==false)
							 btnview.doClick();
						}	
					}
				});
				btninsert.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ev.sno.setText(Integer.toString(table.getRowCount()+1));
						ev.sno.setEditable(false);
						ev.btnYes.setText("Insert");Point p=btninsert.getLocationOnScreen();
						
						ev.jd.setLocation(p.x+70,p.y+25);						ev.jd.setVisible(true);
						if(ev.jd.isVisible()==false)
						 btnview.doClick();
						
					}
				});	
btnview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						Object[][] data=datas();
						
						
						
						DefaultTableModel model=new DefaultTableModel(
								data,
								new String[] {
									"S.no", "Food", "Raw Material Cost", "Selling Price", "Profit"
								}
							) {
								boolean[] columnEditables = new boolean[] {
									false, false, false, false, false
								};
								public boolean isCellEditable(int row, int column) {
									return columnEditables[column];
								}
							};
								table.setModel(model);
								table.getColumnModel().getColumn(0).setResizable(false);
								table.getColumnModel().getColumn(0).setPreferredWidth(35);
								table.getColumnModel().getColumn(1).setResizable(false);
								table.getColumnModel().getColumn(1).setPreferredWidth(251);
								table.getColumnModel().getColumn(2).setResizable(false);
								table.getColumnModel().getColumn(2).setPreferredWidth(122);
								table.getColumnModel().getColumn(3).setResizable(false);
								table.getColumnModel().getColumn(4).setResizable(false);table.getColumnModel().setColumnSelectionAllowed(true);
						
					}
				});
	}
}
