package controlers;

import DAO.EntrainerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Entraineur;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/entraineur")
public class EntraineurServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action == null || action.equals("list")) {
                List<Entraineur> entraineurs = EntrainerDAO.getAllEntraineur();
                request.setAttribute("entraineurs", entraineurs);
                request.getRequestDispatcher("/entraineur/afficherEntraineurs.jsp").forward(request, response);

            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Entraineur entraineur = EntrainerDAO.getEntraineurById(id);
                request.setAttribute("entraineur", entraineur);
                request.getRequestDispatcher("/entraineur/modifierEntraineur.jsp").forward(request, response);

            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                EntrainerDAO.suprimerEntraineur(id);
                response.sendRedirect("entraineur?action=list");
            } else if(action.equals("add")){
                request.getRequestDispatcher("/entraineur/ajouterEntraineur.jsp").forward(request,response);
            }
        } catch (SQLException | ClassNotFoundException | ServletException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || (!action.equals("add") && !action.equals("update"))) {
            System.out.println("no action");
            return;
        }
        try {
            if (action.equals("add")) {
                String nom = request.getParameter("nom");
                String speciality = request.getParameter("speciality");
                String password = request.getParameter("password");
                Entraineur entraineur = new Entraineur();
                entraineur.setNom(nom);
                entraineur.setSpeciality(speciality);
                entraineur.setPassword(password);
                EntrainerDAO.ajouterEntraineur(entraineur);
                response.sendRedirect("entraineur?action=list");
            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String speciality = request.getParameter("speciality");
                String password = request.getParameter("password");
                Entraineur entraineur = new Entraineur();
                entraineur.setId(id);
                entraineur.setNom(nom);
                entraineur.setSpeciality(speciality);
                entraineur.setPassword(password);
                EntrainerDAO.modifierEntraineur(entraineur);
                response.sendRedirect("entraineur?action=list");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

