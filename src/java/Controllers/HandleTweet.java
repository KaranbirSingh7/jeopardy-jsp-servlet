package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@WebServlet(name = "HandleTweet", urlPatterns = {"/HandleTweet"})
public class HandleTweet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //API Keys
            String consumerKey = "aQj2Jyj6fgZP55uOMflL0Bovn";
            String consumerSecret = "Sv2nKqod9LDQ129lR8KLmWNjWPiUhXiiOHKfkm5DBYTouEn8nV";
            String accessToken = "2893254696-G7nPDrEeI79ypV3Ap8Mj2wv1lXLnKO7fS5hn7uT";
            String accessTokenSecret = "tPWxbGDWa7sjKqV9Fk7rYJc65g1qZ1CYxmC6w1R3vA90F";

            TwitterFactory twitterFactory = new TwitterFactory();
            Twitter twitter = twitterFactory.getInstance();

            twitter.setOAuthConsumer(consumerKey, consumerSecret);
            twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

            StatusUpdate statusUpdate = new StatusUpdate(request.getParameter("tweetBox"));
            Status status = twitter.updateStatus(statusUpdate);

            out.println("<h3>Tweet Successful Check it out</h3> "
                    + "<br><br><br> "
                    + "<h1><a href='/Jeopardy/index.html'>Play Again</a></h1>");

        } catch (TwitterException ex) {
            Logger.getLogger(HandleTweet.class.getName()).log(Level.SEVERE, null, ex);
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
