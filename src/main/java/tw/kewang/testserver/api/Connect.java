package tw.kewang.testserver.api;

import java.sql.*;

public class Connect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db?serverTimezone=NST";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mm774188";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to DB");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user_data";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                String first = rs.getString("account");
                String last = rs.getString("password");
                String ID=rs.getString("ID");
                String mail=rs.getString("mail");

                //Display values
                System.out.println("ID: " + ID);
                System.out.println(", First: " + first);
                System.out.println(", Last: " + last);
                System.out.println(", Mail: " + mail);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}