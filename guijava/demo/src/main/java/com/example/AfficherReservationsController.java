package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class AfficherReservationsController {

    @FXML
    private TextArea reservationsTextArea;

    // Méthode pour initialiser la zone de texte avec les réservations
    @FXML
    private void initialize() {
        loadReservations();
    }

    // Méthode pour charger les réservations depuis le fichier CSV et les afficher dans la zone de texte
    private void loadReservations() {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GestionDeReservation.FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(GestionDeReservation.CSV_SEPARATOR);
                if (parts.length >= 5) {
                    try {
                        LocalDate date = LocalDate.parse(parts[2]);
                        LocalTime startTime = LocalTime.parse(parts[3]);
                        LocalTime endTime = LocalTime.parse(parts[4]);
                        sb.append("Nom du client: ").append(parts[0]).append(", ")
                                .append("Nombre de personnes: ").append(parts[1]).append(", ")
                                .append("Date: ").append(date).append(", ")
                                .append("Heure de début: ").append(startTime).append(", ")
                                .append("Heure de fin: ").append(endTime).append("\n");
                    } catch (DateTimeParseException e) {
                        System.err.println("Erreur lors de l'analyse de la date ou de l'heure : " + e.getMessage());
                    }
                } else {
                    System.err.println("Ligne mal formatée : " + line);
                }
            }
            reader.close();
            reservationsTextArea.setText(sb.toString());
            System.out.println("Réservations chargées avec succès."); // Message de débogage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
