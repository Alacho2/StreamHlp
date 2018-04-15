//Implement JNativeHook NativeKeyEvent.VK_-keycomb-
//Add action-method for what to happen
//Add

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.time.StopWatch;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class ActionHandler implements NativeKeyListener {

    StopWatch stopwatch;
    static WindowController wc;
    FileHandler fh;

    public ActionHandler(){
        stopwatch = new StopWatch();
    }

    public void startWatch(ActionEvent event){
        try {
            stopwatch.start();
            WindowController.timeText.setText("Running");
            WindowController.timeText.setTextFill(Color.GREEN);
            fh = new FileHandler();
        } catch(IllegalStateException ise){
            AlertBox.display("Running", "Stopwatch already running");
        }
    }

    public void stopWatch(ActionEvent event){
        try{
            stopwatch.stop();
            stopwatch.reset();
            WindowController.timeText.setText("Not running");
            WindowController.timeText.setTextFill(Color.RED);
            fh.closeWriter();
        } catch(IllegalStateException ise){
            AlertBox.display("Stopped", "Stopwatch isn't running");
        }
    }

    public void writeToFile(ActionEvent event){
        fh.addALine(stopwatch.toString());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}
