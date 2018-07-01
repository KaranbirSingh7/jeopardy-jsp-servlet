<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/Jeopardy/errorPage.jsp"%>
<%@page import="Beans.QuestionDB,java.util.ArrayList, Beans.Question"%>

<%
    QuestionDB qdb = new QuestionDB();
    String id = request.getParameter("question_id");
    Question q = qdb.findQuestionById(id);
%>

<!DOCTYPE html>
<html>
    <head>
        <!-- CSS FILES  -->
        <%@include file="../stylesheets.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <div class="m-4 p-4"></div>
        <div class="container">

            <form method="POST" action="/Jeopardy/UpdateHandle">
                <div class="form-group col-4">
                    <p>Question Number</p>
                    <input type ="text" class="form-control" name="question_id" value="<%=q.getQuestionNumber()%>" readonly/>
                </div>
                <div class="form-group col-10">
                    <p>Question</p>
                    <input type ="text" class="form-control" name="question" value="<%=q.getQuestion()%>" width="500%" required/>
                </div>
                <div class="form-group col-5">
                    <p>Question Options</p>
                    <input type ="text" class="form-control" name="options" value="<%=qdb.arrayInLine(q.getOptions())%>" required/>
                    <small class="form-text text-muted">Option should be in this order [ Order1, Order2, Order3, Order4 ]</small>
                </div>
                <div class="form-group col-5">
                    <p>Question Answer</p>
                    <input type ="text" class="form-control" name="answer" value="<%=q.getAnswer()%>" required/>
                </div>
                <div class="form-group col-5">
                    <p>Question Amount</p>
                    <input type ="number" class="form-control"
                           name="amount" step="100" min="0" max="1000" value="<%=q.getAmount()%>" required/>
                </div>
                <input type="submit" class="btn btn-md btn-success ml-3 mr-5 mt-2"
                       name="update" value="Update"/>
                <input type="submit" class="btn btn-md btn-danger mr-4 mt-2"
                       name="cancel" value="Cancel"/>
            </form>
            <div class="m-4 p-4"></div>
        </div>
    </body>
</html>
