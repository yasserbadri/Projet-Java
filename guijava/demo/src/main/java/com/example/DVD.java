package com.example;

public class DVD {
    private String titre;
    private String realisateur;
    private int duree;

    public DVD(String titre, String realisateur, int duree) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getduree() {
        return duree;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + ", Realisateur: " + realisateur + ", duree: " + duree;
    }
}
    // Getters et setters
