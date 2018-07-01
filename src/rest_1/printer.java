package rest_1;

 

 
import javax.swing.JComboBox;
import javax.swing.JDialog;

 
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;



import javax.swing.ImageIcon;
import java.awt.Color;
 

@SuppressWarnings("serial")
public class printer extends JDialog {

	  JDialog frame;
	@SuppressWarnings("rawtypes")
	JComboBox aa;JButton bb;
private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the application.
	 */
	public printer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JDialog();
		frame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame.setModal(true);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 460, 300);
		frame.getContentPane().setLayout(null);
		
		  aa = new JComboBox();
		aa.setFont(new Font("Times New Roman", Font.BOLD, 19));
		aa.setBounds(10, 0, 440, 35);
		frame.getContentPane().add(aa);
		
		  bb = new JButton("Select Printer");
		  bb.setFont(new Font("Times New Roman", Font.BOLD, 22));
		bb.setBounds(10, 205, 440, 84);
		frame.getContentPane().add(bb);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(printer.class.getResource("/images/images/user-6.png")));
		lblNewLabel.setBounds(-397, 0, 857, 477);
		frame.getContentPane().add(lblNewLabel);
	}

}
