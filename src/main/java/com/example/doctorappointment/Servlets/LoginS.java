/*// 
 * For Patient Print Data
 * 
 * 				Set the next JSP's Attributes
					
						// Your Data
					request.setAttribute("username", patient.getUsername());
					request.setAttribute("name", patient.getName());
					request.setAttribute("surname", patient.getSurname());
					request.setAttribute("amka", patient.getAMKA());
					
						// Your History Appointments
					try {
						appointments = appointmentd.searchAppointments(patient.getAMKA());
					}catch(Exception e) {
						System.out.println("Login Patient Error 2");
					}							
					request.setAttribute("appointments", appointments);	*/

package com.example.doctorappointment.Servlets;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.example.doctorappointment.DAO.*;

import com.example.doctorappointment.MainClasses.*;

@WebServlet("/login")
public class LoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Patient patient;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		patient = null;
		Admin admin = null;
		Doctor doctor = null;

		// Get the form's email and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		String category = request.getParameter("category");
		String vCode = request.getParameter("vcode");

		// PATIENT

		Patient patient = null;

		switch (category) {
			case "patient":
				// Search the patient
				try {
					patient = PatientD.searchPatient(email);
				} catch (Exception e) {
					System.out.println("Login Patient Error");
				}

				// If a patient with that email exists
				if (patient != null) {
					String hashedpassword = patient.getHashedPassword();
					String salt = patient.getSalt();

					// Check Password
					if (Functions.encodeSha256(salt + password).equals(hashedpassword)) {
						System.out.println("Patient Login Success");
						System.out.println("Patient: " + patient.getEmail() + " " + patient.getHashedPassword() + " " + patient.getSalt() + " " + patient.getName() + " " + patient.getSurname() + " " + patient.getAMKA());

						// Go to 'patientMain'
						HttpSession session = request.getSession();
						session.setAttribute("patient", patient.getName());
						request.getRequestDispatcher("Views/Main/patientMain.jsp").forward(request, response);

					} else {
						// Go to Login page
						System.out.println("Wrong Password");
						response.sendRedirect("index.jsp");
					}
				} else {
					// Go to Login page
					response.sendRedirect("index.jsp");
				}


				// DOCTOR

				break;
			case "doctor":
				// Search the doctor
				try {
					doctor = DoctorD.searchDoctor(email);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Login Doctor Error");
				}

				// If a patient with that email exists
				if (doctor != null) {
					String hashedpassword = doctor.getHashedPassword();
					String salt = doctor.getSalt();

					// Check Password
					if (Functions.encodeSha256(salt + password).equals(hashedpassword)) {
						System.out.println("Doctor: " + doctor.getEmail() + " " + doctor.getHashedPassword() + " " + doctor.getSalt() + " " + doctor.getName() + " " + doctor.getSurname() + " " + doctor.getAdminUserId() + " " + doctor.getAMKA() + " " + doctor.getSpecialty());
						// Go to 'patientLogin'
						HttpSession session = request.getSession();
						session.setAttribute("doctor", doctor);
						request.getRequestDispatcher("Views/Main/doctorMain.jsp").forward(request, response);

					} else {
						// Go to Login page
						response.sendRedirect("index.jsp");
					}
				} else {
					// Go to Login page
					response.sendRedirect("index.jsp");
				}


				// ADMIN

				break;
			case "admin":
				// Search the doctor
				try {
					admin = AdminD.searchAdmin(email);
				} catch (Exception e) {
					System.out.println("Login Admin Error 1");
				}

				// If a patient with that email exists
				if (admin != null) {
					String hashedpassword = admin.getHashedPassword();
					String salt = admin.getSalt();

					// Check Password
					if (Functions.encodeSha256(salt + password).equals(hashedpassword)) {
						System.out.println("Admin: " + admin.getEmail() + " " + admin.getHashedPassword() + " " + admin.getSalt() + " " + admin.getUserid());
						// Go to 'adminMain'
						HttpSession session = request.getSession();
						session.setAttribute("admin", admin);
						request.getRequestDispatcher("Views/Main/adminMain.jsp").forward(request, response);

					} else {
						// Go to Login page
						response.sendRedirect("index.jsp");
					}
				} else {
					// Go to Login page
					response.sendRedirect("index.jsp");
				}
				break;
		}
	}		
}
