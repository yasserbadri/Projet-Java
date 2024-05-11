package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class SupprimerEvnController {
    
    @FXML
    private TextField titreTextField;
    
    @FXML
    private void supprimerEvn(ActionEvent event) {
        String titre = titreTextField.getText();
        boolean supprime = GestionEvn.supprimerEvn(titre);
        if (supprime) {
            System.out.println("Événement supprimé avec succès.");
        } else {
            System.out.println("Aucun événement trouvé avec ce titre.");
        }
    }
    
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
