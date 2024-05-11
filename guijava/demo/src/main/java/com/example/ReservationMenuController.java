package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ReservationMenuController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void GoToReservationMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("ReservationMenu.fxml");
    }

    @FXML
    private void GoTorechercher_reservation(ActionEvent event) throws IOException {
        NavigationController.goTo("rechercher_reservation.fxml");
    }

    @FXML
    private void GoToafficher_reservations(ActionEvent event) throws IOException {
        NavigationController.goTo("afficher_reservations.fxml");
    }

    @FXML
    public void goBack(ActionEvent event) {
        NavigationController.goBack();
    }

    @FXML
    private void GoTosupprimer_reservation(ActionEvent event) throws IOException {
        NavigationController.goTo("supprimer_reservation.fxml");
    }

    @FXML
    private void GoToajouter_reservation(ActionEvent event) throws IOException {
        NavigationController.goTo("ajouter_reservation.fxml");
    }
}
