package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class SupprimerCDController {
    
    @FXML
    private TextField TextField;
    
  
    
    @FXML
    private void SupprimerCD(ActionEvent event)
     {
        System.out.println(TextField.getText());
       GestionDeCD.supprimerCD(TextField.getText());
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
