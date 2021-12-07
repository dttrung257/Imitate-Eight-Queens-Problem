package sample.eightqueenalgo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.action.Action;

import static sample.eightqueenalgo.ImitateAlgorithm.*;

public class Controller implements Initializable {
    static int step = 1;
    private ArrayList<Integer> coordinateXofSolution = new ArrayList<>();
    private ArrayList<String> stringSolution = new ArrayList<>();
    static Timeline timeline;
    static boolean stopped = false;
    static boolean isSolution = false;
    static int mySpeed;
    static int saveSpeed;

    @FXML
    private Slider slider;

    @FXML
    private Label textSpeed;

    @FXML
    private Label textStep;

    @FXML
    private Label textSolution;

    @FXML
    private Label labelSpeed;

    @FXML
    private Label textActionStep;

    @FXML
    private Pane Board1;

    @FXML
    private Pane Board2;

    @FXML
    private ListView<String> Solution;

    @FXML
    private static ImageView image1;

    @FXML
    private static ImageView image2;

    @FXML
    private static ImageView image3;

    @FXML
    private static ImageView image4;

    @FXML
    private static ImageView image5;

    @FXML
    private static ImageView image6;

    @FXML
    private static ImageView image7;

    @FXML
    private static ImageView image8;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        ImitateAlgorithm.pos = Algorithm.positionOfSolution();
        stringSolution = Board.allSolutionInListView();
        mySpeed = 500;
        textSpeed.setText("500");
        slider.valueProperty().addListener((observableValue, number, t1) -> {
            mySpeed = (int) slider.getValue();
            textSpeed.setText(Integer.toString(mySpeed));
        });
    }

    @FXML
    void Create(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(false);
        setImage(32);
    }

    @FXML
    ImageView createImage(double x, double y, ImageView image) {
        Image img = new Image(this.getClass().getResource("Queen.png").toString());
        image = new ImageView();
        image.setImage(img);
        image.setX(x);
        image.setY(y);
        image.setFitWidth(30);
        image.setFitHeight(30);
        return image;
    }

    @FXML
    void setImage(double firstImage) {
        image1 = createImage(firstImage, 30, image1);
        Board2.getChildren().add(image1);
        image2 = createImage(32, 30 + 43.5, image2);
        Board2.getChildren().add(image2);
        image3 = createImage(32, 30 + 43.5 * 2, image3);
        Board2.getChildren().add(image3);
        image4 = createImage(32, 30 + 43.5 * 3, image4);
        Board2.getChildren().add(image4);
        image5 = createImage(32, 30 + 43.5 * 4, image5);
        Board2.getChildren().add(image5);
        image6 = createImage(32, 30 + 43.5 * 5, image6);
        Board2.getChildren().add(image6);
        image7 = createImage(32, 30 + 43.5 * 6, image7);
        Board2.getChildren().add(image7);
        image8 = createImage(32, 30 + 43.5 * 7, image8);
        Board2.getChildren().add(image8);
    }

    @FXML
    void clickA(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(1);
        setImage(32);
    }

    @FXML
    void clickB(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(2);
        setImage(32 + 43.5);
    }

    @FXML
    void clickC(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(3);
        setImage(32 + 43.5 * 2);
    }

    @FXML
    void clickD(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(4);
        setImage(32 + 43.5 * 3);
    }

    @FXML
    void clickE(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(5);
        setImage(32 + 43.5 * 4);
    }

    @FXML
    void clickF(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(6);
        setImage(32 + 43.5 * 5);
    }

    @FXML
    void clickG(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(7);
        setImage(32 + 43.5 * 6);
    }

    @FXML
    void clickH(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Solution.setVisible(true);
        getSolutionInListView(8);
        setImage(32 + 43.5 * 7);
    }

    @FXML
    void allSolution(MouseEvent event) {
        ArrayList<String> solution = Board.allSolutionInListView();
        Solution.getItems().clear();
        Solution.getItems().addAll(solution);
        Solution.setVisible(true);
        clearBoard(event);
        setImage(32);
    }

    @FXML
    void clearSolution(MouseEvent event) {
        Solution.getItems().clear();
        clearBoard(event);
    }

    @FXML
    void getSolutionInListView(int select) {
        ArrayList<String> solution = Board.solutionForSelection(select);
        Solution.getItems().clear();
        Solution.getItems().addAll(solution);
        Solution.setVisible(true);
    }

    @FXML
    void displaySolutionInBoard(MouseEvent event) {
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
        }
        resetImage();
        step = 1;
        isSolution = false;
        countSolution = 0;
        textSolution.setText("");
        String solution = Solution.getSelectionModel().getSelectedItem();
        Board1.setVisible(false);
        Board2.setVisible(true);
        clearBoard(event);
        setImage(32);
        showSolutionInBoard(solution);
    }

    @FXML
    void showSolutionInBoard(String solution) {
        ArrayList<Integer> coordinateXofSolution = Board.handleSolution(solution);
        setPositionForImage(coordinateXofSolution.get(0), 0, 1);
        setPositionForImage(coordinateXofSolution.get(1), 1, 2);
        setPositionForImage(coordinateXofSolution.get(2), 2, 3);
        setPositionForImage(coordinateXofSolution.get(3), 3, 4);
        setPositionForImage(coordinateXofSolution.get(4), 4, 5);
        setPositionForImage(coordinateXofSolution.get(5), 5, 6);
        setPositionForImage(coordinateXofSolution.get(6), 6, 7);
        setPositionForImage(coordinateXofSolution.get(7), 7, 8);
    }

    @FXML
    static void resetImage() {
        image1.relocate(32, 30);
        image2.relocate(32, 30 + 43.5);
        image3.relocate(32, 30 + 43.5 * 2);
        image4.relocate(32, 30 + 43.5 * 3);
        image5.relocate(32, 30 + 43.5 * 4);
        image6.relocate(32, 30 + 43.5 * 5);
        image7.relocate(32, 30 + 43.5 * 6);
        image8.relocate(32, 30 + 43.5 * 7);
    }

    @FXML
    static void moveImage(double newX, double newY, ImageView image) {
        image.relocate(32 + (newX - 1) * 43.5, 30 + newY * 43.5);
    }

    static void setVisibleTrueForAllImage() {
        image1.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);
        image4.setVisible(true);
        image5.setVisible(true);
        image6.setVisible(true);
        image7.setVisible(true);
        image8.setVisible(true);
    }

    static void setVisibleFalseForImage(int start) {
        switch (start) {
            case 2 -> {
                image2.setVisible(false);
                image3.setVisible(false);
                image4.setVisible(false);
                image5.setVisible(false);
                image6.setVisible(false);
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 3 -> {
                image3.setVisible(false);
                image4.setVisible(false);
                image5.setVisible(false);
                image6.setVisible(false);
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 4 -> {
                image4.setVisible(false);
                image5.setVisible(false);
                image6.setVisible(false);
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 5 -> {
                image5.setVisible(false);
                image6.setVisible(false);
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 6 -> {
                image6.setVisible(false);
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 7 -> {
                image7.setVisible(false);
                image8.setVisible(false);
            }
            case 8 -> image8.setVisible(false);
            default -> {
            }
        }
    }

    @FXML
    static void setPositionForImage(Integer x, Integer y, int index) {
        switch (index) {
            case 1 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(2);
                moveImage(x, y, image1);
            }
            case 2 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(3);
                moveImage(x, y, image2);
            }
            case 3 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(4);
                moveImage(x, y, image3);
            }
            case 4 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(5);
                moveImage(x, y, image4);
            }
            case 5 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(6);
                moveImage(x, y, image5);
            }
            case 6 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(7);
                moveImage(x, y, image6);
            }
            case 7 -> {
                setVisibleTrueForAllImage();
                setVisibleFalseForImage(8);
                moveImage(x, y, image7);
            }
            case 8 -> {
                setVisibleTrueForAllImage();
                moveImage(x, y, image8);
            }
            default -> {
            }
        }
    }

    @FXML
    void back(MouseEvent event) {
        Board1.setVisible(true);
        Board2.setVisible(false);
        Solution.setVisible(false);
        Solution.getItems().clear();
        Board2.getChildren().remove(image1);
        Board2.getChildren().remove(image2);
        Board2.getChildren().remove(image3);
        Board2.getChildren().remove(image4);
        Board2.getChildren().remove(image5);
        Board2.getChildren().remove(image6);
        Board2.getChildren().remove(image7);
        Board2.getChildren().remove(image8);
        step = 1;
        countSolution = 0;
        isSolution = false;
        textSolution.setText("");
        textStep.setText("");
        labelSpeed.setText("");
        textActionStep.setText("");
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
        }
    }

    @FXML
    void clearBoard(MouseEvent event) {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Board2.getChildren().remove(image1);
        Board2.getChildren().remove(image2);
        Board2.getChildren().remove(image3);
        Board2.getChildren().remove(image4);
        Board2.getChildren().remove(image5);
        Board2.getChildren().remove(image6);
        Board2.getChildren().remove(image7);
        Board2.getChildren().remove(image8);
        step = 1;
        countSolution = 0;
        isSolution = false;
        textSolution.setText("");
        textStep.setText("");
        labelSpeed.setText("");
        textActionStep.setText("");
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
        }
    }

    void clearImage() {
        Board1.setVisible(false);
        Board2.setVisible(true);
        Board2.getChildren().remove(image1);
        Board2.getChildren().remove(image2);
        Board2.getChildren().remove(image3);
        Board2.getChildren().remove(image4);
        Board2.getChildren().remove(image5);
        Board2.getChildren().remove(image6);
        Board2.getChildren().remove(image7);
        Board2.getChildren().remove(image8);
    }

    @FXML
    void Start(MouseEvent event) {
        saveSpeed = mySpeed;
        clearImage();
        setImage(32);
        setVisibleFalseForImage(2);
        if (!stopped) {
            resetImage();
            step = 1;
        } else {
            jumpToStep(step);
        }
        Board1.setVisible(false);
        Board2.setVisible(true);
        timeline = new Timeline(new KeyFrame(Duration.millis(mySpeed), e -> stepAlgorithm(event)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    void stepAlgorithm(MouseEvent event) {
        clearImage();
        setImage(32);
        Board1.setVisible(false);
        Board2.setVisible(true);
        Step(step);
        if (isSolution) {
            String str = stringSolution.get(countSolution - 1);
            str = str.substring(3);
            textSolution.setText("Solution " + countSolution + ": " + str);
            isSolution = false;
        } else {
            textSolution.setText("\t\t\t\tRunning ...");
        }
        step++;
        textStep.setText("Step: " + (step - 1));
        labelSpeed.setText("Speed: " + saveSpeed);
        textActionStep.setText(actionOfStep);
        System.out.println(mySpeed);
    }

    //@FXML
    static void Step(int s) {
        ImitateAlgorithm.temp = 0;
        ImitateAlgorithm.StepOfAlgorithm(1, 8, s);
    }

    @FXML
    void Stop(MouseEvent event) {
        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            stopped = true;
        }
    }

    static void jumpToStep(int s) {
        step = s;
        ImitateAlgorithm.c = 0;
        jumpToStepOfAlgorithm(1, 8, s);
    }
}