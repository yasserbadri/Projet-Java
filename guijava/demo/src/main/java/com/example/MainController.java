package com.example;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void GoToLivreMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("LivreMenu.fxml");
    }
    @FXML
    private void GoToCDMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("CDMenu.fxml");
    }
    @FXML
    private void GoToReservationMenu(ActionEvent event) throws IOException {
        NavigationController.goTo("ReservationMenu.fxml");
    }

    @FXML
    private void GoToEvnMenu(ActionEvent event) throws IOException {
       NavigationController.goTo("EvnMenu.fxml");
    }

   
}
