package lab3.Persistence;

import java.sql.*;

public class WearerDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "student"; 

    public static boolean authenticateUser(String username, String password) {
        boolean isValidUser = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password); 

            ResultSet rs = ps.executeQuery();
            isValidUser = rs.next(); 

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValidUser;
    
    }
}
