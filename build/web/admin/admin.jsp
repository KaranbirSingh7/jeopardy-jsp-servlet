<%@page import="java.util.ArrayList, Beans.Question,Beans.QuestionDB" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/Jeopardy/errorPage.jsp"%>--%>

<%
    ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
    Question ques;
    String[] options;
%>

<!DOCTYPE html>
<html>
    <head>
        <!-- CSS FILES-->
        <%@include file="../stylesheets.html" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Admin Console</title>
        <style>
            thead {
                background-color: black;
                color: white;
            }
        </style>
    </head>
    <body>
        <p class="display-4 text-center m-4">Administration Console</p>

        <a href="/Jeopardy/admin/reportMax.jsp"
           class="m-2 btn btn-lg btn-outline-info ripple float-left">
            Top Players
        </a>

        <a href="/Jeopardy/admin/reportTotal.jsp"
           class="m-2 btn btn-lg btn-outline-info ripple float-left">
            Total Users
        </a>

        <a href="/Jeopardy/admin/reportDB.jsp"
           class="m-2 btn btn-lg btn-outline-info ripple float-left">
            Database Info
        </a>

        <a href="/Jeopardy/admin/add.jsp"
           class="m-2 btn btn-lg btn-success ripple float-right">
            Add New Question
        </a>

        <a href="/Jeopardy/admin/users.jsp"
           class="m-2 btn btn-lg btn-dark ripple float-right">
            Remove User
        </a>

        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <td></td>
                    <td></td>
                    <th>ID#</th>
                    <th>Question</th>
                    <th>Options</th>
                    <th>Answer</th>
                    <th>Winning_Amount</th>
                </tr>
            </thead>
            <%                for (int i = 0; i < questions.size(); i++) {
                    ques = questions.get(i);
            %>

            <tr>
                <td> <a href="/Jeopardy/admin/update.jsp?question_id=<%=ques.getQuestionNumber()%>"
                        class="btn btn-md btn-primary ripple">Update</a>
                </td>

                <td> <a href="ProcessDelete?question_id=<%=ques.getQuestionNumber()%>"
                        class="btn btn-md btn-danger ripple">Delete</a>
                </td>

                <td><%=ques.getQuestionNumber()%></td>
                <td><%=ques.getQuestion()%>?</td>
                <td>
                    <%
                        for (int j = 0; j < ques.getOptions().length; j++) {
                            options = ques.getOptions();
                            if (j == 3) {
                                out.print(options[j]);
                            } else {
                                out.print(options[j] + ", ");
                            }
                        }
                    %>

                </td>
                <td><%=ques.getAnswer()%></td>
                <td>$<%=ques.getAmount()%></td>
            </tr>

            <%}%>
        </table>

        <div class="m-3 p-3"></div>

        <div style="text-align:center;margin: 20px;">
            <a href="/Jeopardy/index.html"
               class="btn btn-lg btn-outline-primary">Main Game Page
            </a>
        </div>

        <div class="m-5 p-5"></div>
    </body>
</html>
