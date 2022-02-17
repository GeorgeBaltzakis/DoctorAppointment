<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Doctor Appointment</title>
    <style>
      <%@include file="WEB-INF/css/style.css"%>
    </style>
<%--      <script src="https://smtpjs.com/v3/smtp.js"></script>--%>
<%--      <script src="index.js"></script>--%>
  </head>
  <body>
    <h1>Doctor Appointment</h1>
    <br />
    <div class="container">
      <form action="<%= request.getContextPath() %>/login" method="post">
        <table align="center">
          <tr>
            <td>
              <h2>Log-in</h2>
            </td>

<%--            Email--%>
          </tr>
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
                required
              /><br />
              <br />
            </td>
          </tr>
          <tr>

<%--            Password--%>
            <td><label for="password" class="label">Password:</label><br /></td>
          </tr>
          <tr>
            <td>
              <input
                type="password"
                class="label"
                name="password"
                id="password"
                required
              />
            <tr>
            <td>

<%--&lt;%&ndash;                Verification Code Button&ndash;%&gt;--%>
<%--                <input type="button" value="Send Verification Code" onclick="sendVerificationCode();" name="sendVerification"/>--%>
<%--        </tr>--%>
<%--          <tr>--%>
<%--&lt;%&ndash;            Verification code&ndash;%&gt;--%>
<%--            <td><label for="vcode" class="label">Verification Code:</label><br /></td>--%>
<%--          </tr>--%>
<%--          <tr>--%>
<%--            <td>--%>
<%--              <input--%>
<%--                      pattern="[\d]{6}"--%>
<%--                oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"--%>
<%--                type="text"--%>
<%--                class="label"--%>
<%--                name="vcode"--%>
<%--                id="vcode"--%>
<%--                      maxlength="6"--%>
<%--                      required--%>
<%--              />--%>

              <br />
              <br />
            </td>
          </tr>
          <tr>
<%--            Category--%>
            <td><label for="category" class="label">I am:</label></td>
          </tr>
          <tr>
            <td>
              <select name="category" id="category" class="label">
                <option value="patient">Patient</option>
                <option value="doctor">Doctor</option>
                <option value="admin">Admin</option>
              </select>
              <br />
              <br />
              <br />
            </td>
          </tr>

<%--            Login Button--%>
          <tr></tr>
          <tr>
            <td align="center">
              <input
<%--                      onclick="checkVerificationCode()"--%>
                type="submit"
                value="Log-in"
                name="Log-in"
                id="Log-in"
                class="button"
              />
            </td>
          </tr>
        </table>
      </form>
    </div>
    <br />
    <br /><br />

    <p class="main">
      <em>Info: </em> This is Doctor Appointment Web App. You can make an
      Appointment with your Doctor. But first you need to <em>Log-in</em> or
      <a href="Views/register.jsp" class="em">Register</a>.
    </p>
  </body>
</html>
