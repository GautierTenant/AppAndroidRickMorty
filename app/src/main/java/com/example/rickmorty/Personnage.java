package com.example.rickmorty;

import java.io.Serializable;

public class Personnage implements Serializable {
    private String nom;
    private String status;
    private String espece;
    private String genre;
    private String image;

    public Personnage(String nom, String status, String espece, String genre, String image) {
        this.nom = nom;
        this.status = status;
        this.espece = espece;
        this.genre = genre;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
