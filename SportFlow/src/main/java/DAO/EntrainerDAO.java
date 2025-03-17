package DAO;

import models.Entraineur;
import models.Membre;
import refactor.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrainerDAO {
    public static List<Entraineur> getAllEntraineur() throws SQLException, ClassNotFoundException {
        List<Entraineur> entraineurList = new ArrayList<>();
        String sql = "SELECT * FROM entraineur";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Entraineur entraineur = new Entraineur();
            entraineur.setId(rs.getInt("id"));
            entraineur.setSpeciality(rs.getString("specialite"));
            entraineur.setNom(rs.getString("nom"));
            entraineur.setPassword(rs.getString("password"));
            entraineurList.add(entraineur);
        }
        return entraineurList;
    }

    public static void ajouterEntraineur(Entraineur entraineur) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO entraineur(nom, specialite, password) VALUES (?,?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,entraineur.getNom());
        ps.setString(2,entraineur.getSpeciality());
        ps.setString(3,entraineur.getPassword());
        ps.executeUpdate();
    }

    public static void modifierEntraineur(Entraineur entraineur) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE entraineur SET nom=?, specialite=?, password=? WHERE id = ?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, entraineur.getNom());
        ps.setString(2, entraineur.getSpeciality());
        ps.setString(3, entraineur.getPassword());
        ps.setInt(4, entraineur.getId());
        ps.executeUpdate();
    }

    public static void suprimerEntraineur(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM entraineur WHERE id = ?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static Entraineur getEntraineurById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM entraineur WHERE id = ?";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Entraineur entraineur = new Entraineur();
        if (rs.next()){
            entraineur.setId(rs.getInt("id"));
            entraineur.setNom(rs.getString("nom"));
            entraineur.setSpeciality(rs.getString("specialite"));
            entraineur.setPassword(rs.getString("password"));
        }
        return entraineur;
    }
}
