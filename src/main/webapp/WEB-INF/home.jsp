<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Glass Website</title>
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="./home.css" />
</head>

<body>
  <main>
    <section class="glass">
      <div class="dashboard">
        <div class="user">
          <img src="./images/logo (2).png" alt="" />
        </div>
        <div class="links">
          
          <a href="/contact" style="text-decoration: none;"><div class="link" >
            <img src="./images/Icon=about.png" alt="" />
            <h2>Contact</h2>
          </div>
        </a>
          <!-- <div class="link">
              <img src="./images/library.png" alt="" />
              <h2>Library</h2>
            </div> -->
        </div>

      </div>
      <div class="games">
        <div class="status">
          <h1>Save a soul</h1>
          
        </div>
        <!-- Register -->
        <div class="cards">
          <div class="card">
            <div class="card-info">
              <h2>Register!</h2>

              <p>
                <form:errors path="user.*" />
              </p>
              <table>
              <form:form method="POST" action="/registration" modelAttribute="user">
                <tr>
                  <form:label path="firstName">firstName:</form:label>
                  <form:input path="firstName" />
                </tr>
                <tr>
                  <form:label path="email">Email:</form:label>
                  <form:input path="email" />
                </tr>
                <tr>
                  <form:label path="phone">Phone:</form:label>
                  <form:input path="phone" />
                </tr>
                <tr>
                  <form:label path="password">Password:</form:label>
                  <form:password path="password" />
                </tr>
                <tr>
                  <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                  <form:password path="passwordConfirmation" />
                </tr>
                <input type="submit" value="/home" />
              </form:form>
            </table>
            </div>
          </div>
          <h1>OR</h1>
          <!-- Login -->
          <div class="cards">
            <div class="card">
              <div class="card-info">
                <c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <h2>Login</h2>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
    <table>
    <form method="POST" action="/login">
     
        <tr>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </tr>
        <tr>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>
  </table>
              </div>
            </div>


          </div>
        </div>
    </section>
  </main>
  <div class="circle1"></div>
  <div class="circle2"></div>
</body>

</html>