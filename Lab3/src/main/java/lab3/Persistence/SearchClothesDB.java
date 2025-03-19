package lab3.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchClothesDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/LMS";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "student";

    public static List<String> getClothingItems(String type, String brand, String color) {
        List<String> clothingItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT name FROM ClothingItem WHERE " + "(? = '' OR type = ?) AND " + "(? = '' OR brand = ?) AND " + "(? = '' OR colour = ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type); 
            ps.setString(2, type);
            ps.setString(3, brand); 
            ps.setString(4, brand);
            ps.setString(5, color); 
            ps.setString(6, color);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clothingItems.add(rs.getString("name"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clothingItems;
    }
    
}
