package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AjouterEvnController {

    

    @FXML
    private TextField titreField;
    @FXML
    private TextField lieuField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField heureDebutField;
    @FXML
    private TextField heureFinField;
    @FXML
    private TextArea ajouterevn;
    //@FXML
    //private TextArea feedbackTextArea;
    @FXML
private void ajouterEvn(ActionEvent event) {
        String titre = titreField.getText();
        String lieu = lieuField.getText();
        String date = dateField.getText();
        String heureDebut = heureDebutField.getText();
        String heureFin = heureFinField.getText();
        GestionEvn.ajouterEvn(titre, lieu, date, heureDebut, heureFin);
        ajouterevn.setText("Événement ajouté avec succès.");
}

    

    
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
    
}
