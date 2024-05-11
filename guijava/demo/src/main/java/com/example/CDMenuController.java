package com.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class CDMenuController{
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void GoToCDMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("CDMenu.fxml");
    }

    @FXML
    private void GoToRechercherCD(ActionEvent event) throws IOException {
        NavigationController.goTo("RechercherCD.fxml");
    }

    @FXML
    private void GoToAfficherCD(ActionEvent event) throws IOException {
        NavigationController.goTo("AfficherCD.fxml");
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
    @FXML
    private void GoToSupprimerCD(ActionEvent event) throws IOException {
        NavigationController.goTo("SupprimerCD.fxml");
    }

    @FXML
    private void GoToAjouterCD(ActionEvent event) throws IOException {
        NavigationController.goTo("AjouterCD.fxml");
    }
}
