<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <div>
            <h2>My app :)</h2>
        </div>
        <div>
            <div>
                <div>
                    <h2>List of Users</h2>
                </div>

                    <%
                        List<String> names = (List<String>)request.getAttribute("userNames");

                        if (names != null && !names.isEmpty()) {
                            out.println("<ui>");
                            for (String s : names) {
                                out.println("<li>" + s + "</li>");
                            }
                            out.println("</ui>");
                        } else out.println("<p>There are no users yet!</p>");
                    %>
            </div>
        </div>

        <div>
            <button onclick="location.href='/webattempt_war_exploded/'">Back to main</button>
        </div>

    </body>
</html>
