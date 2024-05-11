package com.example;

public class Livre {
    private String titre;
    private String auteur;
    private String annee;

    public Livre(String titre, String auteur, String annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getAnnee() {
        return annee;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + ", Auteur: " + auteur + ", Année: " + annee;
    }
}