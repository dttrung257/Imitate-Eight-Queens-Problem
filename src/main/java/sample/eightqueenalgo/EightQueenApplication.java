package sample.eightqueenalgo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class EightQueenApplication extends Application {

    private Canvas canvas;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("Queen2.png")));
        stage.setTitle("Eight queens puzzle");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            Exit(stage);
        });
    }

    public void Exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ImageView icon = new ImageView(this.getClass().getResource("cat.jpg").toString());
        icon.setFitHeight(50);
        icon.setFitWidth(50);
        alert.getDialogPane().setGraphic(icon);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you want to exit?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}