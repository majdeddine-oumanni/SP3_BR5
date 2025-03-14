package DAO;

import models.Type;
import models.Utilisateur;
import refactor.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    public static void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO utilisateure(nom, type) VALUES (?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,utilisateur.getNom());
        ps.setString(2,utilisateur.getType().toString().toLowerCase());
        ps.executeUpdate();
    }
    public static List<Utilisateur> getUtilisateure() throws SQLException, ClassNotFoundException {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        String sql = "SELECT * FROM utilisateure";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(rs.getInt("id"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setType(Type.valueOf(rs.getString("type").toLowerCase()));
            utilisateurList.add(utilisateur);
        }
        return utilisateurList;
    }

    public static void suprimerUtilisateure(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM utilisateure WHERE id = ?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
}
