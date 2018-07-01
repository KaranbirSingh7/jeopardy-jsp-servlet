<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/Jeopardy/errorPage.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- CSS FILES  -->
        <%@include file="../stylesheets.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Question</title>
    </head>
    <body>
        <div class="m-4 p-4"></div>
        <div class="container">
            <form method="POST" action="/Jeopardy/InsertHandle">

                <div class="form-group col-4">
                    <p>Question</p>
                    <input type ="text" class="form-control" name="question"  width="500%" required/></div>
                <div class="form-group has-warning col-10">
                    <p>Question Options</p>
                    <input type ="text" class="form-control" name="options"  required/>
                    <small class="form-text text-danger">Option should be in this order [ Option1, Option2, Option3, Option4 ]</small>
                </div>
                <div class="form-group col-5">
                    <p>Question Answer</p>
                    <input type ="text" class="form-control" name="answer"  required/></div>
                <div class="form-group col-5">
                    <p>Question Amount</p>
                    <input type ="number" default="100"
                           class="form-control" name="amount" step="100" min="0" max="1000" required/>
                </div>

                <input type="submit"
                       class="btn btn-md btn-success ml-3 mr-5 mt-2"
                       name="add"
                       value="Add"/>

                <!--                <input type="submit" class="btn btn-md btn-danger mr-4 mt-2"
                                       name="cancel" value="Cancel"/>-->
                <a href="/Jeopardy/admin/admin.jsp" class="btn btn-md btn-danger mr-4 mt-2">
                    Cancel
                </a>
            </form>
        </div>
    </body>
</html>
