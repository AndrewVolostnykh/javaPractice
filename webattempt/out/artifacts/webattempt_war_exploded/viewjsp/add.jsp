<%--
  Created by IntelliJ IDEA.
  User: zigha
  Date: 04.02.2020
  Time: 1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add new user</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-indigo w3-right-align">
            <h1>My app :)</h1>
        </div>
        <div class="w3-container w3-padding">
            <%
                if(request.getAttribute("userName") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                            "   <h5>User '" + request.getAttribute("userName") + "' added!</h5>\n" +
                            "</div>");
                }
            %>
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-blue">
                    <h2>Add user</h2>
                </div>
                <form method="post" class="w3-selection w3-light-grey w3-padding">
                    <label>Name:
                        <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                    </label>
                        <br>

                    <label>E-mail:
                        <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                    </label>
                        <br>

                    <label>Password:
                        <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <br>

                    <label>Gender:
                        <input type="radio" name="gender" value="female" chacked class="w3-radio">Female
                        <input type="radio" name="gender" value="male" class="w3-radio">Male
                    </label>
                    <br><br>

                    <label>Country:
                        <select name="country" class="w3-select w3-border">
                            <option>Ukraine</option>
                            <option>Canada</option>
                            <option>Spain</option>
                            <option>France</option>
                            <option>Germany</option>
                            <option>USA</option>
                        </select>
                    </label>
                    <br><br>

                    <label>Birth date:
                        <input type="date" name="birthdate" class="w3-date">
                    </label>
                    <br><br>

                    <button class="w3-btn w3-blue w3-round-large w3-margin-bottom" type="submit">Submit</button>
                </form>
            </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/webattempt_war_exploded/'">Back to main</button>
        </div>

    </body>
</html>

