package DAO;

import models.Membre;
import refactor.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {
    public List<Membre> getAllMembre() throws SQLException, ClassNotFoundException {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM membre";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Membre membre = new Membre();
            membre.setId(rs.getInt("id"));
            membre.setDateDeNaissance(rs.getDate("naissance"));
            membre.setNom(rs.getString("nom"));
            membre.setSportPratique(rs.getString("sportPratique"));
            membre.setPassword(rs.getString("password"));
            membres.add(membre);
        }
        return membres;
    }

    public static void ajouterMembre(Membre membre) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO membre(naissance, sportPratique, nom, password) VALUES (?,?,?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, (Date) membre.getDateDeNaissance());
        ps.setString(2, membre.getSportPratique());
        ps.setString(3, membre.getNom());
        ps.setString(4, membre.getPassword());
        ps.executeUpdate();
    }

    public static void modifierMembre(Membre membre) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE membre SET naissance=?, sportPratique=?, nom=?, password = ? WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, (Date) membre.getDateDeNaissance());
        ps.setString(2, membre.getSportPratique());
        ps.setString(3, membre.getNom());
        ps.setString(4, membre.getPassword());
        ps.setInt(5,membre.getId());
        ps.executeUpdate();
    }

    public static void suprimerMembre(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM membre WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static Membre getMembreById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM membre WHERE id = ?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Membre membre = new Membre();
        if(rs.next()){
            membre.setId(rs.getInt("id"));
            membre.setNom(rs.getString("nom"));
            membre.setSportPratique(rs.getString("sportPratique"));
            membre.setDateDeNaissance(rs.getDate("naissance"));
            membre.setPassword(rs.getString("password"));
        }
        return membre;
    }
}
