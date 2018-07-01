<%@page import="Beans.QuestionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    QuestionDB qdb = new QuestionDB();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../stylesheets.html" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database Info</title>
    </head>
    <body>
        <p class="display-3 text-center bg-light">
            Database Information
        </p>

        <hr />

        <p class="display-4 ">
            Database Server:
            <span class="h2">
                <u>
                    <%=qdb.getServer()%>
                </u>
            </span>
        </p>

        <p class="display-4">
            Database Name:
            <span class="h2">
                <u>
                    <%=qdb.getDatabaseName()%>
                </u>
            </span>
        </p>

        <p class="display-4">
            Database Tables :
            <span class="h2">
                <u>
                    <%=qdb.getDatabaseTables()%>
                </u>
            </span>
        </p>

        <p class="display-4">Total Questions :
            <span class="h2">
                <u>
                    <%=qdb.getAllQuestions().size()%>
                </u>
            </span>
        </p>

        <div style="text-align:center;margin: 20px;">
            <a href="/Jeopardy/admin/admin.jsp"
               class="btn btn-lg btn-outline-primary ripple"> Back to Admin Console
            </a>
        </div>

        <div class="m-5 p-5"></div>
    </body>
</html>
