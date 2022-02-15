<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Patient - Doctor Appointment</title>
    <style>
      <%@include file="../../WEB-INF/css/main_style.css"%>
    </style>
  </head>
  <body>
  	<%@ page import = "com.example.doctorappointment.MainClasses.Patient" %>
  
  	<%
  	Patient patient = (Patient)request.getAttribute("patient");
  	String name = patient.getName();
  	request.setAttribute("patient", patient);
  	%>
    <h1>Welcome, <%out.print(name); %></h1>
    <br /><br />

    <div align="center">
      <table class="p">
        <tr>
          <td>
          
            <p>This is the main page for Patients. Here you can:</p>
          </td>
        </tr>
        <tr>
          <td>
            <ol>
              <li>Watch your <em>Appointments History</em>.</li>
              <br />
              <input type="hidden" name="patient" value="<%=patient%>" />
              <button class="button" style="background-color: rgb(179, 83, 0)">History</button>
<br /><br /><br />
              <li>
                Watch your
                <em style="color: rgb(51, 79, 133)">Feature Appointments</em>.
              </li>
              <br>
              <button class="button" style="width:230px">Feature Appointments</button>
              <br /><br /><br />
              <li>
                Book an
                <em style="color: rgb(41, 119, 26)">Appointment</em>. <br />
                <br />
                <button class="button" style="background-color: rgb(41, 119, 26)">Booking</button>
              </li>
            </ol>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
