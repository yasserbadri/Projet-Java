package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class AfficherCDController {
    
    @FXML
    private TextArea booksTextArea;
    
    @FXML
    private void initialize() {
        // Call afficherLivres method when the application is initialized
        afficherCD();
    }
    
    @FXML
    private void afficherCD() {
        String CDs = GestionDeCD.afficherCD(); // Assuming afficherLivres() returns a String representation of the books
        booksTextArea.setText(CDs);
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
