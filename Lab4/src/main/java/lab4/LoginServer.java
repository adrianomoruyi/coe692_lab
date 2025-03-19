package lab4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab4.Persistence.WearerDB; 

@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (WearerDB.authenticateUser(username, password)) { 
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("searchpage.jsp");  
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
