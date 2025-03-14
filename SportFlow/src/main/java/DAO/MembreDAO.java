package DAO;

import models.Membre;
import models.Utilisateur;
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
            membre.setDateDeNaissance(rs.getDate("dateDeNaissance"));
            membre.setNom(rs.getString("nom"));
        }
        return membres;
    }

    public static void ajouterMembre(Membre membre) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO membre(dateDeNaissance, sportPratique, nom) VALUES (?,?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, (Date) membre.getDateDeNaissance());
        ps.setString(2, membre.getSportPratique());
        ps.setString(3, membre.getNom());
        ps.executeUpdate();
    }

    public static void modifierMembre(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE membre SET dateDeNaissance=?, sportPratique=?,nom=? WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        Membre membre = new Membre();
        ps.setDate(1, (Date) membre.getDateDeNaissance());
        ps.setString(2, membre.getSportPratique());
        ps.setString(3, membre.getNom());
        ps.executeUpdate();
    }

    public static void suprimerMembre(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM membre WHERE id=?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }
}
