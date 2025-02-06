package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchClothesServer")
public class SearchClothesServer extends HttpServlet {
    private static final List<ClothingItem> clothes = new ArrayList<>();

    static {
        clothes.add(new ClothingItem("hat", "Nike", "red", "Red Nike Cap"));
        clothes.add(new ClothingItem("shirt", "Zara", "blue", "Blue Zara Shirt"));
        clothes.add(new ClothingItem("pants", "Adidas", "black", "Black Adidas Pants"));
        clothes.add(new ClothingItem("shoes", "Uniqlo", "white", "White Uniqlo Sneakers"));
        clothes.add(new ClothingItem("shirt", "Nike", "red", "Red Nike T-Shirt"));
        clothes.add(new ClothingItem("hat", "Adidas", "blue", "Blue Adidas Hat"));
        clothes.add(new ClothingItem("jacket", "H&M", "black", "Black H&M Jacket"));
        clothes.add(new ClothingItem("dress", "Zara", "red", "Red Zara Dress"));
        clothes.add(new ClothingItem("shoes", "Gucci", "black", "Black Gucci Loafers"));
        clothes.add(new ClothingItem("hat", "Gucci", "green", "Green Gucci Hat"));
        clothes.add(new ClothingItem("shirt", "Uniqlo", "white", "White Uniqlo Shirt"));
        clothes.add(new ClothingItem("pants", "H&M", "blue", "Blue H&M Jeans"));
        clothes.add(new ClothingItem("jacket", "Nike", "yellow", "Yellow Nike Windbreaker"));
        clothes.add(new ClothingItem("dress", "H&M", "green", "Green H&M Summer Dress"));
        clothes.add(new ClothingItem("shoes", "Adidas", "red", "Red Adidas Running Shoes"));
        clothes.add(new ClothingItem("pants", "Gucci", "white", "White Gucci Trousers"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");

        //List the filtered clothes
        List<String> filteredClothes = new ArrayList<>();
        for (ClothingItem item : clothes) {
            if ((type == null || type.isEmpty() || item.getType().equals(type)) &&
                (brand == null || brand.isEmpty() || item.getBrand().equals(brand)) &&
                (color == null || color.isEmpty() || item.getColor().equals(color))) {
                filteredClothes.add(item.getDescription());
            }
        }

        request.setAttribute("clothingItems", filteredClothes);
        request.getRequestDispatcher("searchpage.jsp").forward(request, response);
    }
    
    //Clothing class
    private static class ClothingItem {
        private String type, brand, color, description;
        public ClothingItem(String type, String brand, String color, String description) {
            this.type = type;
            this.brand = brand;
            this.color = color;
            this.description = description;
        }

        public String getType() { return type; }
        public String getBrand() { return brand; }
        public String getColor() { return color; }
        public String getDescription() { return description; }
    }
}
