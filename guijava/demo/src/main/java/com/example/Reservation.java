package com.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private String nomClient;
    private int nombrePersonnes;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    public Reservation(String nomClient, int nombrePersonnes, LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
        this.nomClient = nomClient;
        this.nombrePersonnes = nombrePersonnes;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public String getNomClient() {
        return nomClient;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
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
        return "Nom du client: " + nomClient + ", Nombre de personnes: " + nombrePersonnes +
               ", Date: " + date + ", Heure de début: " + heureDebut + ", Heure de fin: " + heureFin;
    }
}
