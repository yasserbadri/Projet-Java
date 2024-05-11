package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SupprimerReservationController {

    @FXML
    private TextField titreReservationField;

    @FXML
    private void supprimerReservation() {
        String titre = titreReservationField.getText();
        // Appel à la méthode de suppression dans la classe de gestion de réservation
        boolean supprime = GestionDeReservation.supprimerReservation(titre);
        // Affichage du résultat de la suppression dans l'interface utilisateur
        // (vous pouvez le faire en utilisant une boîte de dialogue, un label, etc.)
        if (supprime) {
            System.out.println("Réservation supprimée avec succès.");
        } else {
            System.out.println("Aucune réservation trouvée avec ce titre.");
        }
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
