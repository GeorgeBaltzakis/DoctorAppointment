<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Doctor - Doctor Appointment</title>
    <style>
      <%@include file="../../WEB-INF/css/main_style.css"%>
    </style>

    <%-- <link rel="stylesheet" href="../../WEB-INF/css/main_style.css" /> --%>
  </head>
  <body>
  <%@ page import = "com.example.doctorappointment.MainClasses.Doctor" %>
  
  	<%
  	Doctor doctor = (Doctor)request.getAttribute("doctor");
  	String name = doctor.getName();
  	%>
    <h1>Welcome, <%out.print(name); %></h1>
    <br /><br />

    <div align="center">
      <table class="p">
        <tr>
          <td>
            <p>This is the main page for Doctors. Here you can:</p>
          </td>
        </tr>
        <tr>
          <td>
            <ol>
              <li>Watch & Edit your <em>Booked Appointments</em>.</li>
              <br />
              <button class="button" style="background-color: rgb(179, 83, 0)">
                Booked Appointments</button
              ><br /><br /><br />
              <li>
                Set your
                <em style="color: rgb(51, 79, 133)">Availability</em> by month.
              </li>
              <br />
              <button class="button">Set Availability</button
              ><br /><br /><br />
            </ol>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
