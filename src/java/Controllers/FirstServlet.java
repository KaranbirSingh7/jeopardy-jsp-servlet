package Controllers;

import Beans.Player;
import Beans.PlayerDB;
import Beans.Question;
import Beans.StartGame;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FirstServlet", urlPatterns = {"/FirstServlet"})
public class FirstServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            StartGame game = new StartGame();

            ArrayList<Question> questions = game.getQuestions();

            Player player = new Player(request.getParameter("username").trim(), 0);
            PlayerDB pdb = new PlayerDB();

            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();

            RequestDispatcher pageType = null;

            if (player.getName().equals("admin")
                    || player.getName().equals("ADMIN")
                    || player.getName().equals("Admin")
                    && password.equals("admin")) {
                pageType = request.getRequestDispatcher("/admin/admin.jsp");
            } else {
                if (pdb.authenticateUser(username, password)) {
                    session.setAttribute("player", player);
                    session.setAttribute("questionCount", 0);
                    pageType = request.getRequestDispatcher("/QuestionBoard.jsp");
                } else {
                    out.println("NOT REGISTERED OR PASSWORD INCORRECT"
                            + "<br><a href='/Jeopardy/register.html'>Register Here</a>");
                }

            }
            session.setAttribute("questions", questions);
            pageType.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            request.setAttribute("e", ex);
            request.getRequestDispatcher("/Jeopardy/errorPage.jsp").forward(request, response);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FirstServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
