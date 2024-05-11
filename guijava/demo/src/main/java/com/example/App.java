package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Main.fxml"));
        Parent root = fxmlLoader.load();
        
        MainController controller = fxmlLoader.getController();
        controller.setStage(stage); // Pass the stage reference to the controller
        
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

        // Set the stage in NavigationController and add the main scene to the sceneHistory stack
        NavigationController.setStage(stage);
        NavigationController.sceneHistory.push(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
