package DAO;

import models.Session;
import models.Membre;
import models.Entraineur;
import refactor.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {
    public static void ajouterSession(Session session) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO session (date, time, membre_id, entraineur_id) VALUES (?, ?, ?, ?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, session.getDate());
        ps.setTime(2, session.getTime());
        ps.setInt(3, session.getMembre().getId());
        ps.setInt(4, session.getEntraineur().getId());
        ps.executeUpdate();
    }

    public static void modifierSession(Session session) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE session SET date=?, time=?, membre_id=?, entraineur_id=? WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, session.getDate());
        ps.setTime(2, session.getTime());
        ps.setInt(3, session.getMembre().getId());
        ps.setInt(4, session.getEntraineur().getId());
        ps.setInt(5, session.getId());
        ps.executeUpdate();
    }

    public static void supprimerSession(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM session WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static Session getSessionById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM session WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Session session = new Session();
            session.setId(rs.getInt("id"));
            session.setDate(rs.getDate("date"));
            session.setTime(rs.getTime("time"));

            // Creating Membre and Entraineur objects and setting only the ID
            Membre membre = new Membre();
            membre.setId(rs.getInt("membre_id")); // Set ID using setter

            Entraineur entraineur = new Entraineur();
            entraineur.setId(rs.getInt("entraineur_id")); // Set ID using setter

            // Assign them to the session
            session.setMembre(membre);
            session.setEntraineur(entraineur);

            return session;
        }
        return null;
    }


    public static List<Session> getAllSessions() throws SQLException, ClassNotFoundException {
        List<Session> sessions = new ArrayList<>();
        String sql = "SELECT * FROM session";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Session session = new Session();
            session.setId(rs.getInt("id"));
            session.setDate(rs.getDate("date"));
            session.setTime(rs.getTime("time"));

            Membre membre = new Membre();
            membre.setId(rs.getInt("membre_id")); // Set only ID, other fields remain unset

            Entraineur entraineur = new Entraineur();
            entraineur.setId(rs.getInt("entraineur_id")); // Set only ID, other fields remain unset

            session.setMembre(membre);
            session.setEntraineur(entraineur);

            sessions.add(session);
        }
        return sessions;
    }

}
