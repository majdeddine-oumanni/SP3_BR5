package DAO;

import models.Membre;
import refactor.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {

    public static List<Membre> getMembers() throws SQLException {
        String sql = "SELECT * FROM member";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List<Membre> members = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Membre membre = new Membre();
            membre.setId(rs.getInt("id"));
            membre.setNom(rs.getString("name"));
            membre.setDateDeNaissance(rs.getDate("dateDeNaissance"));
            members.add(membre);
        }
        return members;
    }
    public static void addMembre(Membre membre) throws SQLException {
        String sql = "INSERT INTO membre(nom, dateDeNaissance) VALUES (?,?)";
        Connection con = Connector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, membre.getNom());
        ps.setDate(2, membre.getDateDeNaissance());
        ps.executeUpdate();
    }

    public static void getMembreById() throws SQLException {
        String sql = "SELECT * FROM membre WHERE id=?";
        Connection con = Connector.getConnection();
    }

}
