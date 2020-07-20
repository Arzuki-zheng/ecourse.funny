package tw.kewang.testserver.api;

import java.sql.*;

public class ConnectToMySQL {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db?serverTimezone=NST";

    static final String USER = "root";
    static final String PASS = "mm774188";

    private Connection conn = null;
    private Statement stmt = null;
    private String sql;

    public ConnectToMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to DB");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void create(UserData In) throws SQLException {
        sql = "insert into user_data(account,password,ID,mail)values(\"" +
                In.getAccount() + "\",\"" +
                In.getPassword() + "\",\"" +
                In.getID() + "\",\"" +
                In.getMail() + "\");";

        stmt.execute(sql);

        stmt.close();
        conn.close();
    }

    /*public void login(UserData In) throws SQLException {

    }*/
}