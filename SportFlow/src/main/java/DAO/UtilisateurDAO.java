package DAO;

import models.Utilisateur;
import refactor.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurDAO {
    public static void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO utilisateure(nom, type) VALUES (?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,utilisateur.getNom());
        ps.setString(2,utilisateur.getType().toString());
        ps.executeUpdate();
    }
}
