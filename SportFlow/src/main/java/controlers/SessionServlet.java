package controlers;

import DAO.SessionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Session;
import models.Membre;
import models.Entraineur;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null || action.isEmpty())
            action = "list";
        try {
            switch (action) {
                case "list":
                    listSessions(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteSession(request, response);
                    break;
                case "add":
                    request.getRequestDispatcher("/session/add_session.jsp").forward(request,response);
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
                    addSession(request, response);
                    break;
                case "update":
                    updateSession(request, response);
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

    private void listSessions(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Session> sessions = SessionDAO.getAllSessions();
        request.setAttribute("sessions", sessions);
        request.getRequestDispatcher("/session/sessions.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Session session = SessionDAO.getSessionById(id);
        request.setAttribute("session", session);
        request.getRequestDispatcher("/session/edit_session.jsp").forward(request, response);
    }

    private void addSession(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Date date = Date.valueOf(request.getParameter("date"));
        String timeString = request.getParameter("time");
        if (timeString.length() == 5) { 
            timeString += ":00";
        }
        Time time = Time.valueOf(timeString);
        int membreId = Integer.parseInt(request.getParameter("membre_id"));
        int entraineurId = Integer.parseInt(request.getParameter("entraineur_id"));

        Membre membre = new Membre();
        membre.setId(membreId);

        Entraineur entraineur = new Entraineur();
        entraineur.setId(entraineurId);

        Session session = new Session(0, date, time, membre, entraineur);
        SessionDAO.ajouterSession(session);
        response.sendRedirect("session?action=list");
    }

    private void updateSession(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Date date = Date.valueOf(request.getParameter("date"));
        Time time = Time.valueOf(request.getParameter("time"));
        int membreId = Integer.parseInt(request.getParameter("membre_id"));
        int entraineurId = Integer.parseInt(request.getParameter("entraineur_id"));

        Membre membre = new Membre();
        membre.setId(membreId);

        Entraineur entraineur = new Entraineur();
        entraineur.setId(entraineurId);

        Session session = new Session(id, date, time, membre, entraineur);
        SessionDAO.modifierSession(session);
        response.sendRedirect("session?action=list");
    }

    private void deleteSession(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SessionDAO.supprimerSession(id);
        response.sendRedirect("session?action=list");
    }
}
