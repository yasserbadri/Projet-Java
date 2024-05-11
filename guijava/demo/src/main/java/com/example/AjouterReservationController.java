package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AjouterReservationController {

    @FXML
    private TextField nomClientField;

    @FXML
    private TextField dateReservationField;

    @FXML
    private TextField detailsField;
     @FXML
    private TextArea ajouterres;

    // Méthode pour ajouter une réservation
    @FXML
    private void ajouterReservation() {
        // Récupérer les valeurs des champs
        String nomClient = nomClientField.getText();
        String dateReservation = dateReservationField.getText();
        String details = detailsField.getText();
        GestionDeReservation.ajouterReservation(nomClient, dateReservation, details);
        // Ajouter le code pour ajouter une réservation avec les valeurs récupérées
        // Exemple de code fictif pour afficher les valeurs récupérées
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de réservation");
        alert.setHeaderText(null);
        alert.setContentText("Nom du client: " + nomClient + "\nDate de la réservation: " + dateReservation + "\nDétails: " + details);
        alert.showAndWait();
        ajouterres.setText("reservation ajouter avec succes");

    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
