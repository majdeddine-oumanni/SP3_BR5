package contrlers;

import DAO.UtilisateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Type;
import models.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class AjouterUtilisateurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utilisateur/ajouter.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        Type type = Type.valueOf(request.getParameter("type"));
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setType(type);
        utilisateur.setNom(nom);
        try {
            UtilisateurDAO.ajouterUtilisateur(utilisateur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("loginServlet");
    }
}
