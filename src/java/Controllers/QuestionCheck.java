package Controllers;

import Beans.Player;
import Beans.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "QuestionCheck", urlPatterns = {"/QuestionCheck"})
public class QuestionCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
            Player player = (Player) session.getAttribute("player");
            Question question = (Question) session.getAttribute("question");

            int questionNumber = question.getQuestionNumber();

            if (request.getParameter("skip") != null) {
                player.setWinnings(player.getWinnings());
            } else {
                String userAnswer = request.getParameter(String.valueOf(questionNumber));
                String rightAnswer = question.getAnswer();
                if (userAnswer.equals(rightAnswer)) {
                    player.setWinnings(player.getWinnings() + question.getAmount());
                } else {
                    if (player.getWinnings() - question.getAmount() <= 0) {
                        player.setWinnings(0);
                    } else {
                        player.setWinnings(player.getWinnings() - question.getAmount());
                    }
                }
            }

            question.setQuestionState("disabled=true");
            questions.set(questionNumber - 1, question);

            session.setAttribute("question", question);
            session.setAttribute("player", player);
            request.getRequestDispatcher("QuestionBoard.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
