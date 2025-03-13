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
    public List<Membre> getAllMembre() throws SQLException {
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
}
