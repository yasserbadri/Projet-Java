package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Stack;

public class NavigationController {
    private static Stage stage;
    public static Stack<Scene> sceneHistory = new Stack<>();

    public static void goTo(String fxmlFile) throws IOException {
        if (stage == null) {
            throw new IllegalStateException("Stage is not set.");
        }

        Parent root = FXMLLoader.load(App.class.getResource(fxmlFile));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        sceneHistory.push(scene); // Add current scene to history
        stage.show();
    }

    public static void goBack() {
        if (sceneHistory.isEmpty() || sceneHistory.size() == 1) {
            System.out.println("No previous scene to go back to.");
            return;
        }
    
        sceneHistory.pop(); // Remove the current scene from history
        Scene previousScene = sceneHistory.peek();
        stage.setScene(previousScene); // Go back to the previous scene
        stage.show();
    }
    

    public static void setStage(Stage stage) {
        NavigationController.stage = stage;
    }
}
