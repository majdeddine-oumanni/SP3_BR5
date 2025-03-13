package models;

public class Membre extends Utilisateur {
    private java.sql.Date dateDeNaissance;
    private String sportPratique;


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
