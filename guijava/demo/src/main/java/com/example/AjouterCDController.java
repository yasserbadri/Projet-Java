package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;
public class AjouterCDController {

    @FXML
    private TextField titreTextField;

    @FXML
    private TextField auteurTextField;

    @FXML
    private TextField yearTextField;
    @FXML
    private TextArea Ajoutcdd;
    
    @FXML
    private void helloWorld(ActionEvent event) {
        System.out.println("Hello World!");
    }
    @FXML
    private void AjouterCD(ActionEvent event) {
        String titre = titreTextField.getText();
        String auteur = auteurTextField.getText();
        String annee = yearTextField.getText();
       GestionDeCD.ajouterCD(titre, auteur, annee);
        Ajoutcdd.setText("Cd ajouté avec succes");
       
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
    
}
