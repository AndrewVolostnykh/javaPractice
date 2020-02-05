<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>User profile</title>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        </head>
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-indigo w3-right-align">
            <h1>My app :)</h1>
        </div>
        <div class="w3-container w3-padding">
            <div class="w3-container w3-center w3-blue">
                <h2>Login</h2>
            </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>E-mail:
                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
            </label>
            <br>

            <label>Password:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <br>

            <button class="w3-btn w3-blue w3-round-large w3-margin-bottom" type="submit">Submit</button>
        </form>
            <div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-round-large" onclick="location.href='/webattempt_war_exploded/'">Back to main</button>
            </div>
        </div>
    </body>
</html>

