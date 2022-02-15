package com.example.doctorappointment.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.doctorappointment.MainClasses.Patient;

/**
 * Servlet implementation class PatientS
 */
@WebServlet("/patientMain")
public class PatientS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Patient patient;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		patient = (Patient)request.getAttribute("patient");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("history") != null) {
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("Views/Main/patientFeatures/AppointmentsHistory.jsp").forward(request, response);
        } else if (request.getParameter("feature") != null) {
        	request.setAttribute("patient", patient);
            request.getRequestDispatcher("Views/Main/patientFeatures/FeatureAppointments.jsp").forward(request, response);
        } else if (request.getParameter("book") != null) {
        	request.setAttribute("patient", patient);
            request.getRequestDispatcher("Views/Main/patientFeatures/BookAppointment.jsp").forward(request, response);
        }
	}
}
