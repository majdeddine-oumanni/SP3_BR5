package models;

import java.sql.Date;
import java.sql.Time;

public class Session {
    private int id;
    private Date date;
    private Time time;
    private Membre membre;
    private Entraineur entraineur;
    public Session() {
    }

    public Session(int id, Date date, Time time, Membre membre, Entraineur entraineur) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.membre = membre;
        this.entraineur = entraineur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }
}
