package controlers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty())
            action = "home";
        switch (action){
            case "home":
                request.getRequestDispatcher("homePage.jsp").forward(request,response);
                break;
            case "session":
                response.sendRedirect("session");
                break;
            case "membre":
                response.sendRedirect("membre");
                break;
            case "entraineur":
                response.sendRedirect("entraineur");
                break;
        }
    }

}
