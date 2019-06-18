package com.lti.training.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUserManager {
	public boolean isValidUser(String username, String password) {
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
				
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");	
			    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			    String sql="select count(*) from tb_user where username=? and password=? and active=1";
				st=con.prepareStatement(sql);
				st.setString(1,username);
				st.setString(2,password);
				rs=st.executeQuery();
				rs.next();
				int count=rs.getInt(1);
				if(count==1)
					return true;
				else 
					 return false;
			}			 
			catch(ClassNotFoundException e){
				System.out.println("JDBC driver not found");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
}

