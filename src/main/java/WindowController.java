import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowController extends Application {


    public WindowController() {

    }

    @Override
    public void start(Stage stage) {
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
