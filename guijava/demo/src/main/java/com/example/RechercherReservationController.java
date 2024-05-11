package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RechercherReservationController {

    @FXML
    private TextField titreReservationField;

    @FXML
    private void rechercherReservation() {
        String titre = titreReservationField.getText();
        // Appel à la méthode de recherche dans la classe de gestion de réservation
        String resultat = GestionDeReservation.rechercherReservation(titre);
        // Affichage du résultat dans l'interface utilisateur
        // (vous pouvez le faire en utilisant une boîte de dialogue, un label, etc.)
        System.out.println(resultat);
    }
    @FXML
private void goBack(ActionEvent event) {
    NavigationController.goBack();
}
}
