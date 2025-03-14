package models;

public class Membre {
    private int id;
    private String nom;
    private String password;
    private java.sql.Date dateDeNaissance;
    private String sportPratique;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(java.sql.Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSportPratique() {
        return sportPratique;
    }

    public void setSportPratique(String sportPratique) {
        this.sportPratique = sportPratique;
    }
}
