import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.commons.lang3.time.StopWatch;

public class WindowController extends Application {

    StopWatch sw = new StopWatch();
    FileHandler file = new FileHandler();

    public WindowController() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Diamond");
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.show();

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
    }
}
