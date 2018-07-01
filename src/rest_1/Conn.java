package rest_1;
import java.sql.*;

import javax.swing.JOptionPane;


public class Conn {
public Connection connect;
Conn()
{
	try {
		Class.forName("org.sqlite.JDBC");
		Connection connect=DriverManager.getConnection("JDBC:sqlite:‪‪my.sqlite");
	
		this.connect=connect;
	} catch (Exception e) {
		
	}
	
	
	
	
	
	
}

	
	
	
}
