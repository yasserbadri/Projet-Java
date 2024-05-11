package com.example;

import java.time.LocalDate;


public class Programme {
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Programme(String titre, String description, LocalDate dateDebut, LocalDate dateFin) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
}
