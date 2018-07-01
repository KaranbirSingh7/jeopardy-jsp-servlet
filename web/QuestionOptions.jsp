<%@page import="Beans.Player, Beans.Question" errorPage="/Jeopardy/errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Player player = (Player) session.getAttribute("player");
    Question question = (Question) session.getAttribute("question");
    String[] options = question.getOptions();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Question <%=question.getQuestionNumber()%></title>

        <!-- CSS FILES  -->
        <%@include file="stylesheets.html" %>
    </head>
    <body>
        <!-- Include NavBar -->
        <%@include file="Header.jsp"%>
        <div class="m-4 p-3"></div>
        <div class="container">

            <!--Question Display-->
            <p class="display-4"><%=question.getQuestion()%> ?</p>

            <!--TIMER-->
            <div class="mr-5">
                <div class="mr-5"><div class="mr-5">
                        <div id="timer" class="display-2 h-75 text-danger float-right mr-5 mt-4">
                        </div>
                    </div>
                </div>
            </div>
            <form method="GET" action="/Jeopardy/QuestionCheck" class="d-inline-block" >

                <div class="custom-controls-stacked">

                    <% for (int i = 0; i < options.length; i++) {%><br />

                    <!-- Question Options  -->

                    <input type="radio"
                           name="<%=question.getQuestionNumber()%>"
                           value="<%=options[i]%>"
                           required />

                    <label>
                        <%=options[i]%>
                    </label>

                    <% }%><br />
                </div>

                <div class="m-2 p-2"></div>

                <!--Question SUBMIT Button-->
                <input type="submit" value="Submit" class="btn btn-md btn-info"  />
            </form>

            <!--Question SKIP Button-->
            <div class="d-inline-block">
                <form method="GET" action="/Jeopardy/QuestionCheck">
                    <button type="submit" name="skip" id="skip" class="btn btn--skip">Skip</button>
                </form>
            </div>

        </div>
        <script>
            var time = 15;
            var divTimer = document.getElementById("timer");
            setInterval(function() {
                divTimer.innerHTML = time--;
                if (time == 0) {
                    document.getElementById("skip").click();
                    divTimer.innerHTML = 0;
                    clearInterval(this);
                }
            }, 1000);
        </script>
    </body>
</html>