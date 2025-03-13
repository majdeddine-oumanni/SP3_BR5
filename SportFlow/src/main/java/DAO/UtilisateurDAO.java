package DAO;

import models.Utilisateur;
import refactor.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    public static void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO utilisateure(nom, type) VALUES (?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,utilisateur.getNom());
        ps.setString(2,utilisateur.getType().toString());
        ps.executeUpdate();
    }
    public static List<Utilisateur> getUtilisateure() throws SQLException {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(rs.getInt("id"));
            utilisateur.setNom(rs.getString("nom"));
        }
        return utilisateurList;
    }
    
}
