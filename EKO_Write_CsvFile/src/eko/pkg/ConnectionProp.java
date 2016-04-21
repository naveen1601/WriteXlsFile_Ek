package eko.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProp {
	Connection con;
	
	public void connectC() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/ekodb_icici_qa", "root", "mysql");
	}

}
