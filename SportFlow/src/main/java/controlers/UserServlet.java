package controlers;



import DAO.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Type;
import models.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            try {
                List<Utilisateur> allUsers = utilisateurDAO.getUtilisateure();
                List<Utilisateur> membres = new ArrayList<>();
                List<Utilisateur> entraineurs = new ArrayList<>();

                for (Utilisateur user : allUsers) {
                    if ("membre".equalsIgnoreCase(user.getType().toString())) {
                        membres.add(user);
                    } else if ("entraineur".equalsIgnoreCase(user.getType().toString())) {
                        entraineurs.add(user);
                    }
                }

                req.setAttribute("membres", membres);
                req.setAttribute("entraineurs", entraineurs);
                req.getRequestDispatcher("/utilisateur/utilisateursList.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                suprimer(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void suprimer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        UtilisateurDAO.suprimerUtilisateure(id);
        resp.sendRedirect("UserServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        Type type = Type.valueOf(req.getParameter("type"));

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setType(type);

        try {
            utilisateurDAO.ajouterUtilisateur(utilisateur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("UserServlet");
    }
}
