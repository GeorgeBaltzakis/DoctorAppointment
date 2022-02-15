package com.example.doctorappointment.DAO;

import java.sql.*;

import com.example.doctorappointment.MainClasses.Admin;

public class AdminD {
	Admin admin;

	public static Admin searchAdmin(String email) throws ClassNotFoundException, SQLException {
		Admin admin = null;
		try {
			// Make the connection
			Class.forName("com.mysql.cj.jdbc.Driver");		
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "select * from admin where (email=?)";
		    PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, email);
		    ResultSet rs = query.executeQuery();
		    
		    // Take the Result of the Query and make a Admin
		    if(rs.next()){
		    	admin = new Admin(rs.getString("email"), rs.getString("hashedpassword"), rs.getString("salt"), rs.getInt("userid"));
		    }
		    
		    // Close Connection
		    connection.close();
		    
		    // Print to console the created Admin
		    if(admin != null)
		    	System.out.println("Admin Exists");
		    
		}catch(Exception e){
			System.out.println("AdminD Error");
			e.printStackTrace();
		}
		
        return admin;
	}	
}
