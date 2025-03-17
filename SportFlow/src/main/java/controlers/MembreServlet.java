package controlers;

import DAO.MembreDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Membre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/membre")
public class MembreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null || action.isEmpty())
            action = "list";
        try {
            switch (action) {
                case "list":
                    listMembres(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteMembre(request, response);
                    break;
                case "add":
                    request.getRequestDispatcher("/membre/addMembre.jsp").forward(request,response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add":
                    addMembre(request, response);
                    break;
                case "update":
                    updateMembre(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listMembres(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        List<Membre> membres = new MembreDAO().getAllMembre();
        request.setAttribute("membres", membres);
        request.getRequestDispatcher("/membre/listMembre.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Membre membre = MembreDAO.getMembreById(id);
        request.setAttribute("membre", membre);
        request.getRequestDispatcher("/membre/editMembre.jsp").forward(request, response);
    }

    private void addMembre(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        String nom = request.getParameter("nom");
        String sportPratique = request.getParameter("sportPratique");
        String password = request.getParameter("password");
        java.sql.Date dateNaissance = java.sql.Date.valueOf(request.getParameter("naissance"));

        Membre membre = new Membre();
        membre.setNom(nom);
        membre.setSportPratique(sportPratique);
        membre.setPassword(password);
        membre.setDateDeNaissance(dateNaissance);

        MembreDAO.ajouterMembre(membre);
        response.sendRedirect("membre?action=list");
    }

    private void updateMembre(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String sportPratique = request.getParameter("sportPratique");
        String password = request.getParameter("password");
        java.sql.Date dateNaissance = java.sql.Date.valueOf(request.getParameter("naissance"));

        Membre membre = new Membre();
        membre.setId(id);
        membre.setNom(nom);
        membre.setSportPratique(sportPratique);
        membre.setPassword(password);
        membre.setDateDeNaissance(dateNaissance);

        MembreDAO.modifierMembre(membre);
        response.sendRedirect("membre?action=list");
    }

    private void deleteMembre(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        MembreDAO.suprimerMembre(id);
        response.sendRedirect("membre?action=list");
    }
}
