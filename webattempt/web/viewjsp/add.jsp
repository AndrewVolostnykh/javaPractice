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
    </head>
    <body>
        <div>
            <h1>My app :)</h1>
        </div>
        <div>
            <%
                if (request.getAttribute("userName") != null) {
                    out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
                }
            %>
            <div>
                <div>
                    <h2>Add user</h2>
                </div>
                <form method="post">
                    <label>Name:
                        <input type="text" name="name"><br />
                    </label>

                    <label>Password:
                        <input type="password" name="pass"><br />
                    </label>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>

        <div>
            <button onclick="location.href='/webattempt_war_exploded/'">Back to main</button>
        </div>

    </body>
</html>

