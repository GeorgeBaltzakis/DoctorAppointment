package com.example.doctorappointment.DAO;

import java.sql.*;

import com.example.doctorappointment.MainClasses.Doctor;

public class DoctorD {
	public static Doctor searchDoctor(String email) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Doctor doctor = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("h");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		System.out.println("h1");

		// Make & Execute the Query
		String sql = "select * from doctor where (email=?)";
		PreparedStatement query = connection.prepareStatement(sql);
		query.setString(1, email);
		ResultSet rs = query.executeQuery();
		System.out.println("h2");

		// Take the Result of the Query and make a Doctor
		if(rs.next()){
			doctor = new Doctor(rs.getString("email"), rs.getString("hashedpassword"), rs.getString("salt"), rs.getString("name"), rs.getString("surname"), rs.getInt("ADMIN_userid"), rs.getLong("doctorAMKA"),rs.getString("specialty"));
			System.out.println("Doctor " + doctor.getName() + " Exists");
		}
		    
//		    // Print to console the created Doctor
//		    if(doctor != null)
//		    	System.out.println("Doctor Exists");
        return doctor;
	}
	
	public static void deleteDoctor(int AMKA) throws ClassNotFoundException, SQLException {
		
		try {
			// Make the connection
			Class.forName("com.mysql.cj.jdbc.Driver");		
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "delete from doctor where doctorAMKA=?";
		    PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, AMKA);
			query.executeQuery();
		 
		    // Close Connection
		    connection.close();
		    
		}catch(Exception e){
			System.out.println("AdminD Delete Doctor Error");
			e.printStackTrace();
		}

	}

	public static void createDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
	
		try {
			// Make the connection
			Class.forName("com.mysql.cj.jdbc.Driver");		
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "INSERT INTO doctor (doctorAMKA, email, hashedpassword, name, surname, specialty, ADMIN_userid, salt) Values(?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement query = connection.prepareStatement(sql);

			query.setLong(1, doctor.getAMKA());
			query.setString(2, doctor.getEmail());
			query.setString(3, doctor.getHashedPassword());
			query.setString(4, doctor.getName());
			query.setString(5, doctor.getSurname());
			query.setString(6, doctor.getSpecialty());
			query.setInt(7, doctor.getAdminUserId());
			query.setString(8, doctor.getSalt());

			query.executeQuery();
			System.out.println("Doctor Created");

		    // Close Connection
		    connection.close();
		    
		}catch(Exception e){
			System.out.println("AdminD Create Doctor Error");
			e.printStackTrace();
		}
	}
}
