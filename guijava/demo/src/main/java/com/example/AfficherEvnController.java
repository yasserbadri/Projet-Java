package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class AfficherEvnController {
    
    @FXML
    private TextArea evnTextArea;
    
    @FXML
    private void initialize() {
        afficherEvn();
    }
    
    @FXML
    private void afficherEvn() {
        String evnString = GestionEvn.afficherEvn();
        evnTextArea.setText(evnString);
    }
    
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
