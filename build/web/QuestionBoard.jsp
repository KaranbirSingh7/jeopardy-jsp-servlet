<%@page import="Beans.Player, Beans.Question, java.util.ArrayList" errorPage="/Jeopardy/errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Player player = (Player) session.getAttribute("player");
    ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
    Question ques;
    int questionCount = (Integer) session.getAttribute("questionCount");

    if (questionCount == questions.size()) {
        response.sendRedirect("Result.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jeopardy</title>
        <!-- CSS FILES  -->
        <%@include file="stylesheets.html" %>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div>
            <div class="m-4 p-3"></div>
            <div class="container">
                <form action="/Jeopardy/QuestionFinder" method="POST">
                    <table>
                        <tr>
                            <% for (int i = 1; i <= questions.size(); i++) {
                                    ques = questions.get(i - 1);
                            %>
                            <td>
                                <div class="container">
                                    <button type="submit"
                                            name="questionNumber"
                                            value="<%=ques.getQuestionNumber()%>"
                                            <%=ques.getQuestionState()%>
                                            class="button button--lg button--blue m-4 p-4 ripple" >
                                        $<%=ques.getAmount()%>
                                    </button>
                                </div>
                            </td>
                            <% if (i % 5 == 0) { %>
                        <tr></tr>
                        <% } %>
                        <% }%>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <script src="style/bootstrap/js/bootstrap.js"></script>
        <script src="style/bootstrap/js/bootstrap.bundle.js"></script>
    </body>
</html>
