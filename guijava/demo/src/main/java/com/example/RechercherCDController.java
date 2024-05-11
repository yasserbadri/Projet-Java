package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class RechercherCDController {
    
    @FXML
    private TextField TextField;
    @FXML
    private TextArea bookArea;
  
    
    @FXML
    private void RechercherCD(ActionEvent event)
     {
        System.out.println(TextField.getText());
        String monCD= GestionDeCD.rechercherCD(TextField.getText());
        bookArea.setText(monCD);
      
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
}
