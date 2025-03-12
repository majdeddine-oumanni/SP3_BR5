package models;

import java.util.Date;

public class Membre extends utilisateur{
    private Date dateDeNaissance;
    private String sportPratique;
    public Membre (int id, String nom, Date dateDeNaissance, String sportPratique){
        super(id, nom);
        this.dateDeNaissance = dateDeNaissance;
        this.sportPratique = sportPratique;
    }
}
