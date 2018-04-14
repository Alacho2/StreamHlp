import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox{

    static Button close;
    static Stage stage;

    public static void display(String title, String text){
        stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);
        stage.setMaxWidth(250);
        stage.setMinHeight(100);
        stage.setMaxHeight(100);

        Label label = new Label(text);
        close = new Button("Okay");
        close.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, close);
        layout.setAlignment(Pos.CENTER);

        myEnterKey();

        Scene scene = new Scene(layout, 250, 100);
        stage.setScene(scene);
        stage.show();
    }

    private static void myEnterKey(){
        close.addEventHandler(KeyEvent.KEY_PRESSED, e-> {
            if(e.getCode() == KeyCode.ENTER){
                stage.close();
            }
        });
    }
}
