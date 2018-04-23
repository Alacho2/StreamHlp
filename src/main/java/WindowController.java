import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class WindowController extends Application {

    ActionHandler ah = new ActionHandler();
    GridPane pane;
    Text mainTitle;
    Text welcomeText;
    Button start;
    Button stop;
    static Button addTime;
    static Label timeText;

    @Override
    public void start(Stage stage){
        stage.setTitle("King Landor");
        stage.setMinHeight(360);
        stage.setMinWidth(640);

        setMystage();

        Scene scene = new Scene(pane, 640, 360);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setMystage(){
        buttonController();
        labelController();
        paneController();
    }

    public void buttonController() {
        start = new Button("Start");
        start.setOnAction(ah::startWatch);
        addTime = new Button("Log time");
        addTime.setOnAction(ah::writeToFile);
        stop = new Button("Stop");
        stop.setOnAction(ah::stopWatch);
    }

    private void paneController() {
        pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.add(mainTitle, 0, 0);
        pane.add(welcomeText, 0, 1);
        pane.add(timeText, 0, 2);
        pane.add(start, 0,3);
        pane.add(addTime, 0, 4);
        pane.add(stop, 1, 3);
    }

    private void labelController() {
        mainTitle = new Text("StreamHlp");
        mainTitle.setId("mainLabel");
        welcomeText = new Text("Welcome to StreamHlp. StreamHlp is a small utility that \n" +
                                "help you keep track of your highlights in a stream");
        welcomeText.setId("welcomeLabel");
        timeText = new Label("Not running");
        timeText.setId("timeLabel");
    }
}