package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDB {

    private Connection connection;
    private ResultSet rs;
    private Statement stmt;
    private String username = "questiondb";
    private String password = "{root}";
    private String databaseName = "QuestionDB";
    private String server = "den1.mysql6.gear.host";

    public ResultSet getRs() {
        return rs;
    }

    public Statement getStmt() {
        return stmt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getServer() {
        return server;
    }

    public QuestionDB() {

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + databaseName + "?user=" + username + "&password=" + password);
        return connection;
    }

    public void addQuestion(Question q) throws ClassNotFoundException, SQLException {
        String qOptions = arrayInLine(q.getOptions());
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        ResultSet totalQuestionRS = st.executeQuery("SELECT COUNT(Question_ID) from Questions");
        totalQuestionRS.next();
        int totalQuestions = Integer.parseInt(totalQuestionRS.getString(1));
        st.executeUpdate("ALTER TABLE Questions AUTO_INCREMENT = " + totalQuestions);
        String sql = "INSERT INTO Questions (Question_Name, Question_Options, Question_Answer, Question_Amount)"
                + "VALUES('" + q.getQuestion() + "', '" + qOptions + "', '" + q.getAnswer() + "', " + q.getAmount() + ")";
        st.executeUpdate(sql);
        disconnect();
    }

    public Question findQuestionById(String id) throws Exception {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "SELECT * FROM Questions WHERE Question_ID = " + id;
        ResultSet rs = st.executeQuery(sql);
        Question q = new Question();
        while (rs.next()) {
            q = new Question(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    lineInArray(rs.getString(3)),
                    rs.getString(4),
                    Integer.parseInt(rs.getString(5))
            );
        }
        disconnect();
        return q;
    }

    public void updateQuestion(Question q) throws ClassNotFoundException, SQLException {
        String qOptions = arrayInLine(q.getOptions());
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE Questions SET Question_Name = '" + q.getQuestion() + "',"
                + "Question_Options = '" + qOptions + "', "
                + "Question_Answer = '" + q.getAnswer() + "',"
                + "Question_Amount = '" + q.getAmount() + "' "
                + "WHERE Question_ID = " + q.getQuestionNumber());
        disconnect();
    }

    public void deleteQuestion(Question q) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "DELETE FROM Questions WHERE Question_ID = '" + q.getQuestionNumber() + "'";
        st.executeUpdate(sql);
        disconnect();
    }

    public void deleteQuestionById(String id) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "DELETE FROM Questions WHERE Question_ID = '" + id + "'";
        st.executeUpdate(sql);
        disconnect();
    }

    public String getDatabaseTables() throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "SHOW TABLES";

        ResultSet totalTables = st.executeQuery(sql);
        String tables = " ";

        while (totalTables.next()) {
            tables += totalTables.getString(1) + ", ";
        }

        return tables;
    }

    public ArrayList<Question> getAllQuestions() throws ClassNotFoundException, SQLException {
        ArrayList<Question> resultSet = new ArrayList<>();

        Connection con = this.getConnection();
        Statement st = con.createStatement();

        ResultSet rsNew = st.executeQuery("SELECT * FROM Questions");

        while (rsNew.next()) {
            Question q = new Question(
                    Integer.parseInt(rsNew.getString(1)),
                    rsNew.getString(2),
                    lineInArray(rsNew.getString(3)),
                    rsNew.getString(4),
                    Integer.parseInt(rsNew.getString(5))
            );
            resultSet.add(q);
        }
        return resultSet;
    }

    public String arrayInLine(String[] a) {
        String[] options = a;
        String sqlOptions = "";
        for (int i = 0; i < options.length; i++) {
            if (i == 3) {
                sqlOptions = sqlOptions + options[i];
            } else {
                sqlOptions = options[i] + ", " + sqlOptions;
            }
        }
        return sqlOptions;
    }

    public String[] lineInArray(String s) {
        String[] option = s.split(", ");
        return option;
    }

    public void disconnect() throws SQLException, ClassNotFoundException {
        this.getConnection().close();
    }
}
