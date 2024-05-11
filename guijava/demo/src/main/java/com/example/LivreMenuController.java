package com.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class LivreMenuController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void GoToLivreMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("LivreMenu.fxml");
    }

    @FXML
    private void GoToRechercherLivre(ActionEvent event) throws IOException {
        NavigationController.goTo("RechercherLivre.fxml");
    }

    @FXML
    private void GoToAfficherLivre(ActionEvent event) throws IOException {
        NavigationController.goTo("AfficherLivre.fxml");
    }
    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }
    @FXML
    private void GoToSupprimerLivre(ActionEvent event) throws IOException {
        NavigationController.goTo("SupprimerLivre.fxml");
    }

    @FXML
    private void GoToAjouterLivre(ActionEvent event) throws IOException {
        NavigationController.goTo("AjouterLivre.fxml");
    }
}
