package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class SupprimerLivreController {
    
    @FXML
    private TextField TextField;
    
  
    
    @FXML
    private void SupprimerLivre(ActionEvent event)
     {
        System.out.println(TextField.getText());
       GestionDeLivres.supprimerLivre(TextField.getText());
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
