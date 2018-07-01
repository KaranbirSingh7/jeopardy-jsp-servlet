<%--<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/Jeopardy/errorPage.jsp"%>--%>
<%@page import="Beans.PlayerDB,Beans.Player,java.util.ArrayList"%>

<%
    PlayerDB pdb = new PlayerDB();
    ArrayList<Player> players = pdb.getAllPlayers();
    Player player;

    if (request.getParameter("pName") != null) {
        pdb.deleteUserByName(request.getParameter("pName"));
        response.sendRedirect("/Jeopardy/admin/users.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- CSS FILES  -->
        <%@include file="../stylesheets.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Users</title>
        <style>
            thead {
                background-color: black;
                color: white;
            }
        </style>
    </head>
    <body>
        <%if (players.size() > 0) {%>
        <p class="display-4 text-center m-4">Users</p>

        <table class="table table-hover  table-bordered">
            <thead>
                <tr>
                    <td></td>
                    <th>ID#</th>
                    <th>Name</th>
                    <th>Winnings</th>
                </tr>
            </thead>
            <%
                for (int i = 0; i < players.size(); i++) {
                    player = players.get(i);
            %>
            <tr>
                <td><a class="btn btn-danger btn-md ripple"
                       href="users.jsp?pName=<%=player.getName()%>">
                        Delete
                    </a>
                </td>
                <td><%=i + 1%></td>
                <td><%=player.getName()%></td>
                <td>$<%=player.getWinnings()%></td>
                <%      }
                } else {%>
            <p class="display-4 text-center m-4">Sorry No Users At ALL</p>
            <%}%>
        </table>

        <div class="m-3 p-3"></div>

        <div style="text-align:center;margin: 20px;">
            <a href="/Jeopardy/admin/admin.jsp"
               class="btn btn-lg btn-outline-primary ripple"> Back to Admin Console
            </a>
        </div>

        <div class="m-5 p-5"></div>

    </body>
</html>
