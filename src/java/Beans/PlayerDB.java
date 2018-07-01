package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDB {

    private Connection connection;
    private ResultSet rs;
    private Statement stmt;
    private String username = "questiondb";
    private String password = "{root}";
    private String databaseName = "QuestionDB";
    private String server = "den1.mysql6.gear.host";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + databaseName + "?user=" + username + "&password=" + password);
        return connection;
    }

    public void addUser(Player p) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO Users (User_Name, User_Winnings)"
                + "VALUES('" + p.getName() + "', '" + p.getWinnings() + "')");
        disconnect();
    }

    public void registerUser(String name, String password) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO Users (User_Name, User_Password)"
                + "VALUES('" + name + "', '" + password + "')");
        disconnect();
    }

    public Boolean findUser(Player p) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();

        String sql = "Select * From Users WHERE User_Name = '" + p.getName() + "'";
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean findUserByName(String username) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "Select * From Users WHERE User_Name = '" + username + "'";
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean authenticateUser(String name, String pass) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "Select * From Users WHERE User_Name = '" + name + "' AND User_Password = '" + pass + "'";
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    public void updateUser(Player p) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "Update Users SET User_Winnings = " + p.getWinnings() + " WHERE User_Name = '" + p.getName() + "'";
        st.executeUpdate(sql);
        disconnect();
    }

    public void deleteUserByName(String s) throws ClassNotFoundException, SQLException {
        Connection con = this.getConnection();
        Statement st = con.createStatement();
        String sql = "DELETE FROM Users WHERE User_Name = '" + s + "'";
        st.executeUpdate(sql);
        disconnect();
    }

    public ArrayList<Player> getAllPlayers() throws ClassNotFoundException, SQLException {
        ArrayList<Player> players = new ArrayList<>();

        Connection con = this.getConnection();
        Statement st = con.createStatement();

        ResultSet rsNew = st.executeQuery("SELECT * FROM Users");

        while (rsNew.next()) {
            Player p = new Player(rsNew.getString(2), Integer.parseInt(rsNew.getString(3)));
            players.add(p);
        }

        return players;
    }

    public ArrayList<Player> getMaxWinningReport() throws ClassNotFoundException, SQLException {
        ArrayList<Player> players = new ArrayList<>();

        Connection con = this.getConnection();
        Statement st = con.createStatement();

        ResultSet rsNew = st.executeQuery("SELECT * FROM Users ORDER BY User_Winnings DESC");

        while (rsNew.next()) {
            Player p = new Player(rsNew.getString(2), Integer.parseInt(rsNew.getString(3)));
            players.add(p);
        }

        return players;

    }

    public void disconnect() throws SQLException, ClassNotFoundException {
        this.getConnection().close();
    }
}
