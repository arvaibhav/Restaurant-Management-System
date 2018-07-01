package rest_1;

import java.awt.Color;
 
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
import javax.swing.JOptionPane;
 
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
 
import javax.swing.JTextField;
 



import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Manager {
	Conn con=new Conn();
	
	 JFrame frame;
	private final JPanel panel = new JPanel();
	private JTable table;
	private JTable table2;
	JLabel lblUser;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel snoo;
ArrayList<String> name=new ArrayList<>(); 

		String[][] datas()
	{int r=4;
		PreparedStatement s;
		PreparedStatement g;
		try {g = con.connect.prepareStatement(" select * from profile");
			int k=0;  ResultSet rd=g.executeQuery();
			  while(rd.next())
				  k=k+1;
			 r=k;
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"problem");
			
		}
		
		try {
			
			
			s = con.connect.prepareStatement("select * from profile");
			
		ResultSet rs=s.executeQuery();
		
		name.clear();
		
		String[][] arr=new String[r][6];

			int i=0;
				while(rs.next())
				{	name.add(rs.getString(2));
					arr[i][0]=Integer.toString(i+1);
					arr[i][1]=rs.getString(1);//food
					arr[i][2]=rs.getString(6);//raw
					arr[i][3]=rs.getString(7);//price
					arr[i][4]=rs.getString(4);
					arr[i][5]=rs.getString(5);
					i++;
					
				}
			  
				rs.close();
				
			
		return arr;} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("...........................");
			e.printStackTrace();return null;
		}
		
	}
	
	
	public Manager() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {Food_management fm=new Food_management();
	fm.frame.setVisible(false);;
		Object[][] data=fm.datas();
		frame = new JFrame();
	
		frame.getContentPane().setBackground(new Color(108,122,137));
		frame.getContentPane().setLayout(null);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		});
		JLabel selectl = new JLabel("Select first");
		selectl.setBounds(211, 517, 69, 25);
		frame.getContentPane().add(selectl);
		selectl.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(199, 403, 134, 275);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		lblNewLabel.setDoubleBuffered(true);
		lblNewLabel.setIcon(new ImageIcon(Manager.class.getResource("/images/images/speech-bubble-th.png")));
		panel.setBounds(0, 0, 1200, 25);
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Sign Out");
		label.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
Point p=frame.getLocationOnScreen();
				JOptionPane.showMessageDialog(null, "log out");
		
				
				frame.dispose();
				login_1 l=new login_1();
		
				l.frame.setLocation(p.x+70,p.y+85);
				l.frame.setVisible(true);
				
				
			}
		});
		label.setBounds(1098, 0, 92, 24);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 1, 210, 677);
		panel_1.setBackground(new Color(244, 179, 80,80));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
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
		
		JButton btnfood = new JButton("Food");
		
		btnfood.setBackground(new Color(245, 222, 179));
		btnfood.setBounds(10, 57, 190, 107);
		panel_1.add(btnfood);
		
		JButton btnemp = new JButton("Employee");
		
		btnemp.setBackground(new Color(245, 222, 179));
		btnemp.setBounds(10, 175, 190, 107);
		panel_1.add(btnemp);
		
		JButton btnDelete = new JButton("Delete");
	
		btnDelete.setBounds(10, 570, 190, 59);
		panel_1.add(btnDelete);
		
		JButton btnupdate = new JButton("Update");
		
		btnupdate.setBounds(10, 500, 190, 59);
		panel_1.add(btnupdate);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setBounds(10, 430, 190, 59);
		panel_1.add(btnAdd);
		
		
		JLabel Detailbtn = new JLabel("Detail");
		Detailbtn.setBounds(613, 30, 247, 25);
		Detailbtn.setForeground(new Color(244,179,80));
		Detailbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(Detailbtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Employee Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(220, 61, 956, 617);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane emppane = new JScrollPane();
		emppane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		emppane.setBounds(10, 45, 935, 572);
		panel_2.add(emppane);
		
			
			
			
			 
			table2 = new JTable();
			 
			table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table2.setModel(new DefaultTableModel(
				datas(),
				new String[] {
					"S.no", "Emp. Name", "Monthly Salary", "working from", "Key", "Phone number"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table2.getColumnModel().getColumn(0).setResizable(false);
			table2.getColumnModel().getColumn(0).setPreferredWidth(37);
			table2.getColumnModel().getColumn(1).setPreferredWidth(133);
			table2.getColumnModel().getColumn(2).setResizable(false);
			table2.getColumnModel().getColumn(2).setPreferredWidth(92);
			table2.getColumnModel().getColumn(3).setResizable(false);
			table2.getColumnModel().getColumn(3).setPreferredWidth(100);
			table2.getColumnModel().getColumn(4).setResizable(false);
			table2.getColumnModel().getColumn(4).setPreferredWidth(54);
			table2.getColumnModel().getColumn(5).setPreferredWidth(99);
			table2.setBorder(new LineBorder(new Color(0, 0, 0)));
			emppane.setViewportView(table2);
			
			textField = new JTextField();
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {

					textField.setSelectedTextColor(Color.blue);
					textField.setSelectionColor(Color.LIGHT_GRAY);
					textField.setSelectionStart(0);
				}
				@Override
				public void focusLost(FocusEvent e) {
					textField.setSelectedTextColor(Color.black);
					textField.setSelectionColor(Color.white);
					textField.setSelectionStart(0);
				}
			});
		
			textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField.setBounds(109, 14, 142, 20);
			panel_2.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {

					textField_1.setSelectedTextColor(Color.blue);
					textField_1.setSelectionColor(Color.LIGHT_GRAY);
					textField_1.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					textField_1.setSelectedTextColor(Color.black);
					textField_1.setSelectionColor(Color.white);
					textField_1.setSelectionStart(0);
				}
			});
			textField_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_1.setColumns(10);
			textField_1.setBounds(311, 14, 142, 20);
			panel_2.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {

					textField_2.setSelectedTextColor(Color.blue);
					textField_2.setSelectionColor(Color.LIGHT_GRAY);
					textField_2.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					textField_2.setSelectedTextColor(Color.black);
					textField_2.setSelectionColor(Color.white);
					textField_2.setSelectionStart(0);
				}
			});
			textField_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_2.setColumns(10);
			textField_2.setBounds(480, 14, 142, 20);
			panel_2.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {

					textField_3.setSelectedTextColor(Color.blue);
					textField_3.setSelectionColor(Color.LIGHT_GRAY);
					textField_3.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					textField_3.setSelectedTextColor(Color.black);
					textField_3.setSelectionColor(Color.white);
					textField_3.setSelectionStart(0);
				}
			});
			textField_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_3.setColumns(10);
			textField_3.setBounds(647, 14, 74, 20);
			panel_2.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {

					textField_4.setSelectedTextColor(Color.blue);
					textField_4.setSelectionColor(Color.LIGHT_GRAY);
					textField_4.setSelectionStart(0);
				}
				public void focusLost(FocusEvent e) {
					textField_4.setSelectedTextColor(Color.black);
					textField_4.setSelectionColor(Color.white);
					textField_4.setSelectionStart(0);
				}
			});
			textField_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textField_4.setColumns(10);
			textField_4.setBounds(771, 14, 142, 20);
			panel_2.add(textField_4);
			
			snoo = new JLabel("S.no.");
			snoo.setBounds(68, 17, 36, 14);
			panel_2.add(snoo);
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			
			btnNewButton.setVisible(false);
			btnNewButton.setBounds(0, 13, 58, 23);
			panel_2.add(btnNewButton);
			panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, textField_2, textField_3, textField_4}));
			@SuppressWarnings("unused")
			DefaultTableModel model2=(DefaultTableModel)table2.getModel();
		JScrollPane foodPane = new JScrollPane();
		foodPane.setBounds(226, 61, 950, 617);
		frame.getContentPane().add(foodPane);
		foodPane.setVisible(false);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(data,
			new String[] {
				"S.no", "Food", "Raw Material used", "Price", "Profit"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		foodPane.setViewportView(table);
		frame.setUndecorated(true);
		frame.setBounds(100, 25, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnfood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				selectl.setVisible(false);	
				panel_2.setVisible(false);
				foodPane.setVisible(true);
				Object[][] data=fm.datas();
				
				
				
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		btnupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add z=new add();
				

				if(foodPane.isVisible())////////////////foodpane
				{
				int k=table.getSelectedColumn();
				int l=table.getSelectedRow();
				
				if(k==-1)
					{
					lblNewLabel.setVisible(true);
					selectl.setVisible(true);
					java.awt.Toolkit.getDefaultToolkit().beep();
					}
				else
					
				{	lblNewLabel.setVisible(false);
				selectl.setVisible(false);
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
				{ try {
				
				Statement s=con.connect.createStatement();
				
			String q=String.format("update Foodd set ID=ID-1 where ID>%d",Integer.parseInt(z.sno.getText()));
 				
 				s.executeUpdate(q);
 				btnfood.doClick();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				
				
				}	
			}///////////////if food pane
				
			}if(panel_2.isVisible()||table2.isVisible())
				if(table2.getSelectedRow()==-1)
				{
				
				lblNewLabel.setVisible(true);
				selectl.setVisible(true);
				java.awt.Toolkit.getDefaultToolkit().beep();
				}
			else
			{	try {lblNewLabel.setVisible(false);
			selectl.setVisible(false);
			
			 
			@SuppressWarnings("unused")
			int k=table2.getSelectedColumn();
			int l=table2.getSelectedRow();//row             l            row
			 
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
						Statement s=con.connect.createStatement();
		 				String q=String.format("update profile set name='%s',salary='%s',word='%s',key='%s',phone='%s' where username='%s'",textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),name.get(l));
		 				
		 				s.executeUpdate(q);
					 
		 				JOptionPane.showMessageDialog(null,"updated");
		 				btnemp.doClick();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
			}});
		btnDelete.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(foodPane.isVisible())///////foodpane
				{ 
					 add z=new add();
						int k=table.getSelectedColumn();
						int l=table.getSelectedRow();
						
						if(k==-1)
							{
							
							lblNewLabel.setVisible(true);
							selectl.setVisible(true);
							java.awt.Toolkit.getDefaultToolkit().beep();
							}
						else
							
						{	lblNewLabel.setVisible(false);
						selectl.setVisible(false);
							
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
						{ 
							
							btnfood.doClick();}
						}		 
				}
				
			
			if(panel_2.isVisible()||table2.isVisible())
				if(table2.getSelectedRow()==-1)
				{
			
				lblNewLabel.setVisible(true);
				selectl.setVisible(true);
				java.awt.Toolkit.getDefaultToolkit().beep();
				}
			else
			{	try {lblNewLabel.setVisible(false);
			selectl.setVisible(false);
		
			
			int k=table2.getSelectedColumn();
			int l=table2.getSelectedRow();//row             l            row
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
						Statement s=con.connect.createStatement();
		 				String q=String.format("delete from profile where username='%s'",name.get(l));
		 				
		 				s.executeUpdate(q);
					 JOptionPane.showMessageDialog(null,"deleted :"+textField.getText());
					 btnemp.doClick();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
		}});
		
		btnemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				selectl.setVisible(false);
				foodPane.setVisible(false);
				panel_2.setVisible(true);
				table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table2.setModel(new DefaultTableModel(
					datas(),
					new String[] {
						"S.no", "Emp. Name", "Monthly Salary", "working from", "Key", "Phone number"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table2.getColumnModel().getColumn(0).setResizable(false);
				table2.getColumnModel().getColumn(0).setPreferredWidth(37);
				table2.getColumnModel().getColumn(1).setPreferredWidth(133);
				table2.getColumnModel().getColumn(2).setResizable(false);
				table2.getColumnModel().getColumn(2).setPreferredWidth(92);
				table2.getColumnModel().getColumn(3).setResizable(false);
				table2.getColumnModel().getColumn(3).setPreferredWidth(100);
				table2.getColumnModel().getColumn(4).setResizable(false);
				table2.getColumnModel().getColumn(4).setPreferredWidth(54);
				table2.getColumnModel().getColumn(5).setPreferredWidth(99);
				table2.setBorder(new LineBorder(new Color(0, 0, 0)));
				emppane.setViewportView(table2);
			}
		});
		
		
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				int k=table2.getSelectedColumn();
				int l=table2.getSelectedRow();//row             l            row
			
				snoo.setText(table2.getValueAt(l, 0).toString());
				textField.setText(table2.getValueAt(l, 1).toString());
				textField_1.setText(table2.getValueAt(l, 2).toString());
				textField_2.setText(table2.getValueAt(l, 3).toString());
				textField_3.setText(table2.getValueAt(l, 4).toString());
				textField_4.setText(table2.getValueAt(l, 5).toString());
				switch(k)
				{
				case 1:{ textField.setForeground(Color.blue);
				textField_2.setForeground(Color.black);
				textField_3.setForeground(Color.black);
				textField_4.setForeground(Color.BLACK);
				textField_1.setForeground(Color.black);
				break;}
				case 2: { textField_1.setForeground(Color.blue);
				textField_2.setForeground(Color.black);
				textField_3.setForeground(Color.black);
				textField_4.setForeground(Color.BLACK);
				textField.setForeground(Color.black);
				break;}
				case 3: { textField_2.setForeground(Color.blue);
				textField_1.setForeground(Color.black);
				textField_3.setForeground(Color.black);
				textField_4.setForeground(Color.BLACK);
				textField.setForeground(Color.black);
				
				break;}
				case 4: { textField_3.setForeground(Color.blue);
				
				textField_2.setForeground(Color.black);
				textField_1.setForeground(Color.black);
				textField_4.setForeground(Color.BLACK);
				textField.setForeground(Color.black);
				
				break;}
				case 5: { textField_4.setForeground(Color.blue);
				textField_2.setForeground(Color.black);
				textField_3.setForeground(Color.black);
				textField_1.setForeground(Color.BLACK);
				textField.setForeground(Color.black);
				
				break;}
				default: snoo.setForeground(Color.RED);
				}	
			}
		});
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(foodPane.isVisible())
				{	add ev=new add();
					ev.sno.setText(Integer.toString(table.getRowCount()+1));
					ev.sno.setEditable(false);
					ev.btnYes.setText("Insert");Point p=btnAdd.getLocationOnScreen();
					
					ev.jd.setLocation(p.x+70,p.y+25);						ev.jd.setVisible(true);
					if(ev.jd.isVisible()==false)
					 btnfood.doClick();
				 
				}
				else if(panel_2.isVisible()||table2.isVisible())
				{ 
					btnNewButton.setVisible(true);btnNewButton.setEnabled(true);
					snoo.setText(Integer.toString(table2.getRowCount()+1));
					textField.setText("name");
					textField_1.setText("salary");
					textField_2.setText("work");
					textField_3.setText("key");
					textField_4.setText("phone");
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement s=con.connect.createStatement();
					String q=String.format("insert into profile (name,salary,word,key,phone,username,password) values ('%s','%s','%s','%s','%s','username','password')",textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
					 
					s.executeUpdate(q);
					 
				
					JOptionPane.showMessageDialog(null, " inserted");
					btnNewButton.setEnabled(false);
					
					btnemp.doClick();
				
				} catch (Exception ds) {
					 
					JOptionPane.showMessageDialog(null, "Key Should Unique");
					
				}
			}
		});
		
		 
		
		
	}
}
