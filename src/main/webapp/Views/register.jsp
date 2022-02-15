<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Patient Register - Doctor Appointment</title>
    <style>
      <%@include file="../WEB-INF/css/style.css"%>
    </style>
    <!-- <link rel="stylesheet" href="../WEB-INF/css/style.css" /> -->
  </head>
  <script>
    function matchPassword(){
      const newPassword = document.getElementById("password").value;
      const newCPassword = document.getElementById("cpassword").value;
      if(newPassword!==newCPassword){
        alert("Password mismatch!");
        event.preventDefault();
      }
    }
  </script>
  <body>
    <h1>Patient Register</h1>
    <br />
    <div class="register-container">
      <form action="<%= request.getContextPath() %>/register" method="post">
        <table align="center">
          <tr>
            <td>
              <h2>Register</h2>
            </td>
          </tr>
          <!-- AMKA -->
          <tr>
            <td><label for="amka" class="label">AMKA:</label><br /></td>
          </tr>
          <tr>
            <td>
              <input
                oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                type="text"
                maxlength="12"
                class="label"
                name="amka"
                id="amka"
                pattern="[\d]{12}"
                required
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
              <input type="text" class="label" name="name" id="name" required minlength="2" maxlength="45"/>
              <br />
              <br />
            </td>
          </tr>
          <!-- Surname -->
          <tr>
            <td><label for="surname" class="label">Surname:</label><br /></td>
          </tr>
          <tr>
            <td>
              <input
                type="text"
                class="label"
                name="surname"
                id="surname"
                required minlength="2" maxlength="45"
              /><br />
              <br />
            </td>
          </tr>
          <!-- Email -->
          <tr>
            <td><label for="email" class="label">Email:</label><br /></td>
          </tr>
          <tr>
            <td>
              <input
                type="email"
                class="label"
                name="email"
                id="email"
                required minlength="2" maxlength="45"
              /><br />
              <br />
            </td>
          </tr>
          <!-- Password -->
          <tr>
            <td><label for="password" class="label">Password:</label><br /></td>
          </tr>
          <tr>
            <td>
              <input
                      pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                      type="password"
                      class="label"
                      name="password"
                      id="password"
                      required
              /><br />
              <br />
            </td>
          </tr>
          <!-- Confirm Password -->
          <tr>
            <td>
              <label for="cpassword" class="label">Confirm Password:</label
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
            <td align="center">
              <input type="reset" value="Clear" class="reset-button" />
              <input
                      onclick="matchPassword()"
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
  </body>
</html>
