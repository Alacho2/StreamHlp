//Implement JNativeHook NativeKeyEvent.VK_-keycomb-
//Add action-method for what to happen
//Add

import javafx.event.ActionEvent;
import javafx.stage.Popup;
import org.apache.commons.lang3.time.StopWatch;


public class ActionHandler {

    static StopWatch stopwatch;
    static WindowController wc;
    //FileHandler fh = new FileHandler();

    public ActionHandler(){
        stopwatch = new StopWatch();
    }

    public void startWatch(ActionEvent event){
        try {
            stopwatch.start();
            WindowController.timeText.setText("Running");
        } catch(IllegalStateException ise){
            AlertBox.display("Running", "Stopwatch already running");
        }
    }

    public void stopWatch(ActionEvent event){
        try{
            stopwatch.stop();
            stopwatch.reset();
            WindowController.timeText.setText("Not running");
        } catch(IllegalStateException ise){
            AlertBox.display("Stopped", "Stopwatch isn't running");
        }
    }
}
