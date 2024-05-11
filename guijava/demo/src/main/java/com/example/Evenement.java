package com.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {
    private String titre;
    private String lieu;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    public Evenement(String titre, String lieu, LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
        this.titre = titre;
        this.lieu = lieu;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public String getTitre() {
        return titre;
    }

    public String getLieu() {
        return lieu;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + ", Lieu: " + lieu + ", Date: " + date + ", Heure de début: " + heureDebut + ", Heure de fin: " + heureFin;
    }
}
