package com.example.doctorappointment.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.doctorappointment.DAO.PatientD;
import com.example.doctorappointment.MainClasses.Functions;
import com.example.doctorappointment.MainClasses.Patient;

@WebServlet("/register")
public class PatientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Patient patient;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		long AMKA = Long.parseLong(request.getParameter("amka"));
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");

		try {
			patient = PatientD.searchPatient(email);
		} catch (Exception e) {
			System.out.println("Search Patient Error");
		}

		// If a patient with that username does not exist
		if (patient == null) {
			String salt = Functions.generateSalt();
			String hashedpassword = Functions.encodeSha256(salt + password);
			Patient patient = new Patient(email, hashedpassword, salt, name, surname, AMKA);
			try {
				PatientD.createPatient(patient);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("Views/index.jsp");
		} else {
			// Go to Login page
			response.sendRedirect("Views/register.jsp");
		}
	}
}
