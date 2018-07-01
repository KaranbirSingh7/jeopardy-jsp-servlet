<%@page import="Beans.Player, Beans.PlayerDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/Jeopardy/errorPage.jsp"%>

<%
    Player player = (Player) session.getAttribute("player");
    PlayerDB pdb = new PlayerDB();

    if (pdb.findUser(player)) {
        pdb.updateUser(player);
    } else {
        pdb.addUser(player);
    }
    String tweet = "Hey! I just won $" + player.getWinnings() + " playing Sheridan Jeopardy. You can also play it. #Sheridan_Jeopardy";
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel="stylesheet" href="style/bootstrap/css/bootstrap-grid.css">
        <link rel="stylesheet" href="style/bootstrap/css/bootstrap-reboot.css">
        <link rel="stylesheet" href="style/bootstrap/css/bootstrap.css">
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div class="container">

            <div class="m-4 p-3"></div>
            <h1 class="display-4"> You Won:
                <span id="glow" class="display-2">
                    $<%=player.getWinnings()%>
                </span>
            </h1>

            <br />
            <br />

            <h1>Let the world know</h1>
            <form action="/Jeopardy/HandleTweet" method="GET">
                <textarea name="tweetBox"  cols="105" rows="3"><%=tweet%></textarea>
                <br />
                <br />
                <input type="submit" name="tweet" value="Tweet" class="btn btn-md btn-primary">
            </form>
        </div>

        <div style="text-align:center;margin: 20px;">
            <a href="/Jeopardy/index.html"
               class="btn btn-lg btn-outline-primary">Play Again
            </a>
        </div>

        <script>
            var glow = document.getElementById("glow");
            setInterval(function() {
                var r = Math.floor(Math.random() * 255);
                var g = Math.floor(Math.random() * 255);
                var b = Math.floor(Math.random() * 255);
                glow.style.color = 'rgb(' + r + ', ' + g + ', ' + b + ')';
            }, 75);
        </script>
    </body>
</html>
