package com.example.doctorappointment.DAO;

import java.sql.*;

import com.example.doctorappointment.MainClasses.Patient;

public class PatientD {
	// Search
	public static Patient searchPatient(String email) {
		Patient patient = null;
		try {
			// Make the connection
			Class.forName("com.mysql.cj.jdbc.Driver");		
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "select * from patient where (email=?)";
		    PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, email);
		    ResultSet rs = query.executeQuery();
		    
		    // Take the Result of the Query and make a Patient
		    if(rs.next()){
		    	patient = new Patient(rs.getString("email"), rs.getString("hashedpassword"), rs.getString("salt"), rs.getString("name"), rs.getString("surname"), rs.getLong("patientAMKA"));
				System.out.println("Patient Exists");
		    }
		    
		    // Close Connection
		    connection.close();
		}catch(Exception e) {
			System.out.println("PatientD Search Patient Error");
			e.printStackTrace();
		}
        return patient;
	}
	
	public static void createPatient(Patient patient) throws ClassNotFoundException, SQLException {
		
		try {
			// Make the connection
			Class.forName("com.mysql.cj.jdbc.Driver");		
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "INSERT INTO patient (patientAMKA, email, hashedpassword, name, surname, salt) VALUES(?, ?, ?, ?, ?, ?);";
		    PreparedStatement query = connection.prepareStatement(sql);

			query.setLong(1, patient.getAMKA());
			query.setString(2, patient.getEmail());
			query.setString(3, patient.getHashedPassword());
			query.setString(4, patient.getName());
			query.setString(5, patient.getSurname());
			query.setString(6, patient.getSalt());

			query.executeUpdate();
			System.out.println("Patient Created");

		    // Close Connection
		    connection.close();
		    
		}catch(Exception e){
			System.out.println("PatientD Create Patient Error");
			e.printStackTrace();
		}

	}
       
}
