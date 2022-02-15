<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin - Doctor Appointment</title>
    <style>
      <%@include file="../../WEB-INF/css/style.css"%>
    </style>

    <%-- <link rel="stylesheet" href="../../WEB-INF/css/style.css" /> --%>
  </head>
  <body>
  	<%@ page import = "com.example.doctorappointment.MainClasses.Admin" %>
  
  	<%
  	Admin admin = (Admin)request.getAttribute("admin");
  	String name = admin.getEmail();
  	%>
  	
    <h1>Welcome, <%out.print(name); %></h1>
    <br /><br />
    <div align="center">
      <table>
        <!-- Delete Doctor -->
        <tr>
          <td>
            <div class="container" style="height: 240px">
              <form
                action="<%= request.getContextPath() %>/deleteDoctor"
                method="post"
              >
                <table align="center">
                  <tr>
                    <td>
                      <h2>Delete Doctor</h2>
                    </td>
                  </tr>
                  <!-- AMKA -->
                  <tr>
                    <td>
                      <label for="amka" class="label">Doctor AMKA:</label
                      ><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="number"
                        class="label"
                        name="amka"
                        id="amka"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Delete Button -->
                  <tr>
                    <td align="center">
                      <input
                        type="submit"
                        value="Delete"
                        name="delete"
                        id="delete"
                        class="button"
                        style="background-color: rgb(129, 17, 32)"
                      />
                    </td>
                  </tr>
                </table>
              </form>
            </div>
            <br /><br />
            <p
              style="
                font-size: 20px;
                color: rgb(73, 73, 73);
                text-align: center;
              "
            >
              OR
            </p>
            <br /><br />
          </td>
        </tr>
        <!-- Create Doctor -->
        <tr>
          <td>
            <div class="container" style="height: 640px">
              <form
                action="<%= request.getContextPath() %>/createDoctor"
                method="post"
              >
                <table align="center">
                  <tr>
                    <td>
                      <h2>Create Doctor</h2>
                    </td>
                  </tr>
                  <!-- AMKA -->
                  <tr>
                    <td><label for="amkac" class="label">AMKA:</label><br /></td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        name="somename"
                        oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                        type="number"
                        maxlength="12"
                        class="label"
                        name="amka"
                        id="amkac"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Name -->
                  <tr>
                    <td><label for="name" class="label">Name:</label><br /></td>
                  </tr>
                  <tr>
                    <td>
                      <input type="text" class="label" name="name" id="name" />
                      <br />
                      <br />
                    </td>
                  </tr>
                  <!-- Surname -->
                  <tr>
                    <td>
                      <label for="surname" class="label">Surname:</label><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="text"
                        class="label"
                        name="surname"
                        id="surname"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Specialty -->
                  <tr>
                    <td>
                      <label for="specialty" class="label">Specialty:</label
                      ><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="text"
                        class="label"
                        name="specialty"
                        id="specialty"
                      />
                      <br />
                      <br />
                    </td>
                  </tr>
                  <!-- Username -->
                  <tr>
                    <td>
                      <label for="username" class="label">Username:</label
                      ><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="text"
                        class="label"
                        name="username"
                        id="username"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Password -->
                  <tr>
                    <td>
                      <label for="password" class="label">Password:</label
                      ><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="password"
                        class="label"
                        name="password"
                        id="password"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Confirm Password -->
                  <tr>
                    <td>
                      <label for="cpassword" class="label"
                        >Confirm Password:</label
                      ><br />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="password"
                        class="label"
                        name="cpassword"
                        id="cpassword"
                      /><br />
                      <br />
                    </td>
                  </tr>
                  <!-- Register Button -->
                  <tr>
                    <td style="text-align: center"><!-- text align conflict  -->
                      <input type="reset" value="Clear" class="reset-button" />
                      <input
                        type="submit"
                        value="Register"
                        name="register"
                        id="register"
                        class="button"
                      />
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
