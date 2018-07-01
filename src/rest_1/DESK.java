package rest_1;

import java.awt.Color;
 
import java.awt.Font;
import java.awt.Point;

 
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
 
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
 
import java.awt.event.MouseAdapter;
 



import java.awt.Component;
import java.awt.event.ItemEvent;
 
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
 
@SuppressWarnings("serial")
public class DESK extends DefaultTableModel {
Conn con=new Conn();
	 JFrame frame;
	private final JPanel panel = new JPanel();	
	private JTable table;
	PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);   
	ArrayList<Integer> price=new ArrayList<>();
	int o=0;JLabel lblUser;
	int x=3;
	printer pri=new printer();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public DESK() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(108,122,137));
		frame.getContentPane().setLayout(null);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {frame.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		});
		panel.setBounds(0, 0, 1200, 25);
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 24, 978, 661);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("Sign Out");
		label.setBounds(1098, 0, 92, 24);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panel.add(label);
		
		JLabel user = new JLabel(" Welcome:");
		user.setFont(new Font("SimSun", Font.BOLD, 17));
		user.setForeground(new Color(255, 255, 255));
		user.setBounds(0, 0, 132, 24);
		panel.add(user);
		
		lblUser = new JLabel("User");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("SimSun", Font.BOLD, 17));
		lblUser.setBounds(95, 1, 180, 24);
		panel.add(lblUser);label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p=label.getLocationOnScreen();
				surem s=new surem();
	
				s.jd.setLocation(p.x-300,p.y+15);
				s.jd.setVisible(true);
			
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 23, 210, 677);
		panel_1.setBackground(new Color(244, 179, 80,80));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDeleteItem = new JButton("Add");
		
		btnDeleteItem.setRolloverEnabled(false);
		btnDeleteItem.setRequestFocusEnabled(false);
		btnDeleteItem.setFocusable(false);
		btnDeleteItem.setFocusTraversalKeysEnabled(false);
		btnDeleteItem.setFocusPainted(false);
		btnDeleteItem.setBackground(new Color(245, 222, 179));
		btnDeleteItem.setBounds(10, 11, 190, 57);
		panel_1.add(btnDeleteItem);
		
		JButton btnDelete_1 = new JButton("Setup Printer");
		
		btnDelete_1.setFocusPainted(false);
		btnDelete_1.setFocusTraversalKeysEnabled(false);
		btnDelete_1.setFocusable(false);
		btnDelete_1.setRequestFocusEnabled(false);
		btnDelete_1.setRolloverEnabled(false);
		btnDelete_1.setBounds(10, 551, 190, 115);
		panel_1.add(btnDelete_1);
		
		JButton btnNewButton = new JButton("reset");
		
		btnNewButton.setBounds(46, 133, 111, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("remove selected");
		
		btnNewButton_2.setBounds(46, 180, 111, 23);
		panel_1.add(btnNewButton_2);
		
		 
		 
		
	 
		
		JLabel lblFoodManagementDetail = new JLabel("Billing Detail");
		lblFoodManagementDetail.setBounds(643, 30, 247, 25);
		lblFoodManagementDetail.setForeground(new Color(244,179,80,200));
		lblFoodManagementDetail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(lblFoodManagementDetail);

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		
		comboBox.setFocusTraversalPolicyProvider(true);
		comboBox.setFocusCycleRoot(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(220, 66, 970, 604);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel IDD = new JLabel("ID");
		IDD.setBounds(342, 11, 21, 22);
		panel_2.add(IDD);
		IDD.setText(Integer.toString(1));
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(326, 11, 11, 22);
		panel_2.add(ID);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 55, 937, 364);
		panel_2.add(scrollPane_1);
		
		
		comboBox.setBounds(111, 11, 272, 22);
		panel_2.add(comboBox);
		
		
		
		
		PreparedStatement s=con.connect.prepareStatement("select * from Foodd");
		ResultSet rs=s.executeQuery();@SuppressWarnings("unused")
		int i=1;
		while(rs.next())
		{
			comboBox.addItem(rs.getString(1));
			price.add(Integer.parseInt(rs.getString(3)));
			
		}
		
		
		    
		
		
		
		
		
		
		
		
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.no", "Food", "Units", "Price", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(217);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(124);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(145);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		scrollPane_1.setViewportView(table);
		
		
		JSpinner spinner = new JSpinner();
		 
		 
		spinner.setBackground(new Color(204, 204, 255));
		spinner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				spinner.setValue(1);
			}
			 
			 
			
		});
		spinner.setFocusTraversalPolicyProvider(true);
	
			
			
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setBounds(524, 12, 46, 20);
			panel_2.add(spinner);
		JLabel price1 = new JLabel("Price");
		price1.setBounds(612, 15, 104, 14);
		panel_2.add(price1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 24));
		lblTotal.setBounds(784, 530, 60, 35);
		panel_2.add(lblTotal);
		
		JLabel serviccecharge = new JLabel(" Service Charge");
		serviccecharge.setBounds(742, 455, 104, 14);
		panel_2.add(serviccecharge);
		
		JLabel servicetax = new JLabel(" Service Tax");
		servicetax.setBounds(760, 480, 86, 14);
		panel_2.add(servicetax);
		
		JLabel swachh = new JLabel("Swachh Bharat Cess");
		swachh.setBounds(723, 505, 123, 14);
		panel_2.add(swachh);
		
		JLabel st = new JLabel("Sub-Total");
		st.setBounds(821, 430, 46, 14);
		panel_2.add(st);
		
		JLabel totall = new JLabel("Total:");
		totall.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		totall.setBounds(852, 530, 93, 35);
		panel_2.add(totall);
		
		JLabel t1 = new JLabel(":x");
		t1.setBounds(842, 454, 46, 14);
		panel_2.add(t1);
		
		JLabel t2 = new JLabel(":x");
		t2.setBounds(842, 479, 46, 14);
		panel_2.add(t2);
		
		JLabel t3 = new JLabel(":x");
		t3.setBounds(842, 504, 46, 14);
		panel_2.add(t3);
		
		JLabel t11 = new JLabel("total");
		t11.setBounds(889, 454, 46, 14);
		panel_2.add(t11);
		
		JLabel t22 = new JLabel("total");
		t22.setBounds(889, 479, 46, 14);
		panel_2.add(t22);
		
		JLabel t33 = new JLabel("total");
		t33.setBounds(889, 504, 46, 14);
		panel_2.add(t33);
		
		JLabel subt = new JLabel("0");
		subt.setBounds(889, 430, 46, 14);
		panel_2.add(subt);
	
		
		
		
		
		
		for (int c = 0; c < services.length; c++) {
			   
		    pri.aa.addItem((services[c].getName().toString()));
	
		}
		
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(491, 15, 46, 14);
		panel_2.add(lblUnits);
		                 
	   
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable.PrintMode mode = JTable.PrintMode.FIT_WIDTH;
	
			
			try {
 
boolean complete = table.print(mode, null, new  MessageFormat("Product: "
        +""  + "  Job: "
        +"" + "  Task: " 
        ),
                                false, null,
                                false, services[x]);

/* if printing completes */
if (complete) {
/* show a success message */
JOptionPane.showMessageDialog(null,
                             "Printing Complete",
                             "Printing Result",
                             JOptionPane.INFORMATION_MESSAGE);
} else {
/* show a message indicating that printing was cancelled */
JOptionPane.showMessageDialog(null,
                             "Printing Cancelled",
                             "Printing Result",
                             JOptionPane.INFORMATION_MESSAGE);
}
} catch (PrinterException pe) {
/* Printing failed, report to the user */
JOptionPane.showMessageDialog(null,
                         "Printing Failed: " + pe.getMessage(),
                         "Printing Result",
                         JOptionPane.ERROR_MESSAGE);
}
			
}
		});

	 
		btnPrint.setFocusPainted(false);
		btnPrint.setFocusTraversalKeysEnabled(false);
		btnPrint.setFocusable(false);
		btnPrint.setRequestFocusEnabled(false);
		btnPrint.setRolloverEnabled(false);
		btnPrint.setBounds(685, 530, 89, 39);
		panel_2.add(btnPrint);
		  JButton btnNewButton_1 = new JButton("Add Item");
		
		btnNewButton_1.setBounds(742, 11, 205, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(868, 455, 11, 14);
		panel_2.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(868, 480, 11, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(868, 505, 11, 14);
		panel_2.add(label_2);
		
		JLabel lblFooddrink = new JLabel("Food/Drink");
		lblFooddrink.setBounds(255, 36, 60, 14);
		frame.getContentPane().add(lblFooddrink);
		
		
		frame.setUndecorated(true);
		frame.setBounds(100, 25, 1200, 700);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, spinner}));
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try{if(e.getStateChange()==ItemEvent.SELECTED)
			if( comboBox.getSelectedIndex()>=0)
				{
					int i= price.get((comboBox.getSelectedIndex()));
					i=i*(int)(spinner.getValue());	
					price1.setText(Integer.toString(i));
					
				}}
				catch(Exception k)
				{
					System.out.println("exception:"+k.getMessage()+" ");
				}
			}
		});
		 ChangeListener listener = new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {if( comboBox.getSelectedIndex()>=0){
		    	  int i= price.get((comboBox.getSelectedIndex()));
					i=i*(int)(spinner.getValue());	
					price1.setText(Integer.toString(i));
		      }   }
		    };

		    spinner.addChangeListener(listener);

			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{if(comboBox.getSelectedIndex()>=0)
					
						{ 
						
						IDD.setText(Integer.toString(comboBox.getSelectedIndex()+1));
						 
						}
					else
						IDD.setText(Integer.toString(0));
					}
					catch(Exception b)
					{System.out.println("dd"+b.getMessage());
						
					}
					
				}
			});
			DefaultTableModel model=(DefaultTableModel)table.getModel(); 
		o=0;
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
		
			model.addRow(new Object[] {(++o),comboBox.getSelectedItem(),spinner.getValue(),price.get(comboBox.getSelectedIndex()),price1.getText()});
			int total=0;
			for(int i=0;i<model.getRowCount();i++)
			{
				total+=Integer.parseInt(model.getValueAt(i, 4).toString());
			}
			
			subt.setText(Integer.toString(total));
			
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table.getSelectedRow());
				
				
			}
		});	   
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.fireTableRowsDeleted(0, model.getRowCount());
			 
			}
		});
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				 
				 pri.frame.setLocation((int)btnDelete_1.getLocation().getX()+200,(int)btnDelete_1.getLocation().getY()-230);
			pri.frame.setVisible(true);
		
			
			
			}});
		pri.bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x=pri.aa.getSelectedIndex();
				
				pri.frame.setVisible(false);
				
			}
		});
		
	}
}
