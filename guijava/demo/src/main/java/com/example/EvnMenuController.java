package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EvnMenuController{
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void GoToEvnMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("EvnMenu.fxml");
    }

    @FXML
    private void GoToRechercherEvn(ActionEvent event) throws IOException {
        NavigationController.goTo("RechercherEvn.fxml");
    }

    @FXML
    private void GoToAfficherEvn(ActionEvent event) throws IOException {
        NavigationController.goTo("AfficherEvn.fxml");
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
    @FXML
    private void GoToSupprimerEvn(ActionEvent event) throws IOException {
        NavigationController.goTo("SupprimerEvn.fxml");
    }

    @FXML
    private void GoToAjouterEvn(ActionEvent event) throws IOException {
        NavigationController.goTo("AjouterEvn.fxml");
    }

    
}
