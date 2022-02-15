package com.example.doctorappointment.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.doctorappointment.MainClasses.Appointment;

public class AppointmentD {
	public static List<Appointment> searchAppointmentsByPatient(int AMKA) throws ClassNotFoundException, SQLException {
		List<Appointment> appointments = new ArrayList<>();
		try {
			// Make the connection
			Class.forName("com.mysql.jdbc.Driver");
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "select * from appointment where (PATIENT_patientAMKA=?)";
		    PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, AMKA);
		    ResultSet rs = query.executeQuery();
		    
		    // Take the Result of the Query and make a Patient
		    int i = 0;
		    while(rs.next()){
		    	appointments.add(new Appointment(rs.getString("date"), rs.getString("startSlotTime"), rs.getString("endSlotTime"), rs.getLong("PATIENT_patientAMKA"), rs.getLong("DOCTOR_doctorAMKA"), rs.getInt("isAvailable")));
		    	
			    // Print to console the created Patient
		    	System.out.println("Appointment: " + appointments.get(i).getDate() + " " + appointments.get(i).getStartTime() + " " + appointments.get(i).getEndTime() + " " + appointments.get(i).getPatientAMKA() + " " + appointments.get(i).getDoctorAMKA() + " " + appointments.get(i).isAvailable());
		    }
		   
		    // Close Connection
		    connection.close();
		    
		}catch(Exception e){
			System.out.println("AppoimentD search Appointments By Patient Error");
			e.printStackTrace();
		}
        return appointments;
	}
	
	public static List<Appointment> searchAppointmentsByDoctor(int AMKA) throws ClassNotFoundException, SQLException {
		List<Appointment> appointments = new ArrayList<>();
		
		try {
			// Make the connection
			Class.forName("com.mysql.jdbc.Driver");
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorAppointment?useSSL=false", "root", "12345678");
		    
		    // Make & Execute the Query
			String sql = "select * from appointment where (DOCTOR_doctorAMKA=?);";
		    PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, AMKA);
		    ResultSet rs = query.executeQuery(sql);

		    
		    // Take the Result of the Query and make a Patient
		    int i = 0;
		    while(rs.next()){
		    	appointments.add(new Appointment(rs.getString("date"), rs.getString("startSlotTime"), rs.getString("endSlotTime"), rs.getInt("PATIENT_patientAMKA"), rs.getInt("DOCTOR_doctorAMKA"), rs.getInt("isAvailable")));
		    	
			    // Print to console the created Patient
		    	System.out.println("Appointment: " + appointments.get(i).getDate() + " " + appointments.get(i).getStartTime() + " " + appointments.get(i).getEndTime() + " " + appointments.get(i).getPatientAMKA() + " " + appointments.get(i).getDoctorAMKA() + " " + appointments.get(i).isAvailable());
		    }
		   
		    // Close Connection
		    connection.close();
		    
		}catch(Exception e){
			System.out.println("AppoimentD search Appointments By Doctor Error");
			e.printStackTrace();
		}
		
        return appointments;
	}
}
