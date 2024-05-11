package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class AfficherLivreController {
    
    @FXML
    private TextArea booksTextArea;
    
    @FXML
    private void initialize() {
        // Call afficherLivres method when the application is initialized
        afficherLivre();
    }
    
    @FXML
    private void afficherLivre() {
        String books = GestionDeLivres.afficherLivres(); // Assuming afficherLivres() returns a String representation of the books
        booksTextArea.setText(books);
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
