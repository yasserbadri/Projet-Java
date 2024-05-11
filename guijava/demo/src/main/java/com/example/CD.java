package com.example;

public class CD {
    private String titre;
    private String artiste;
    private int duree;

    public CD(String titre, String artiste, int duree) {
        this.titre = titre;
        this.artiste = artiste;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public Integer getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + ", Artiste: " + artiste + ", duree: " + duree;
    }
}
