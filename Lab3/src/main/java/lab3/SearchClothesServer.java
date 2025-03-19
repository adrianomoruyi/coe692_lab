package lab3;

import lab3.Persistence.SearchClothesDB; 
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchClothesServer")
public class SearchClothesServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");

        List<String> clothingItems = SearchClothesDB.getClothingItems(type, brand, color);

        request.setAttribute("clothingItems", clothingItems);
        request.getRequestDispatcher("searchpage.jsp").forward(request, response);
    }
}
