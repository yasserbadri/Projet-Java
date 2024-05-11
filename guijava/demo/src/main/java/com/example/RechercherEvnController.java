package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RechercherEvnController {

    @FXML
    private TextField titreTextField;

    @FXML
    private TextArea resultTextArea;

    @FXML
    private void rechercherEvn() {
        String titre = titreTextField.getText();
        String resultat = GestionEvn.rechercherEvn(titre);
        resultTextArea.setText(resultat);
    }

    @FXML
    private void goBack() {
        NavigationController.goBack();
    }
}

