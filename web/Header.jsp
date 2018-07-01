<%@page import="Beans.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark" style="background-color: #ff4429;">
    <p class=" navbar-brand h4 text-uppercase"><%=player.getName()%></p>
    <p class=" navbar-brand h4">
        Winnings :
        <span style="color: chartreuse">$<%=player.getWinnings()%>
        </span></p>
</nav>
