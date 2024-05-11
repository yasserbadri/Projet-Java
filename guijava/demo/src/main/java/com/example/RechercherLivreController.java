package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class RechercherLivreController {
    
    @FXML
    private TextField TextField;
    @FXML
    private TextArea bookArea;
  
    
    @FXML
    private void RechercherLivre(ActionEvent event)
     {
        System.out.println(TextField.getText());
        String monLivre= GestionDeLivres.rechercherLivre(TextField.getText());
        bookArea.setText(monLivre);
      
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
