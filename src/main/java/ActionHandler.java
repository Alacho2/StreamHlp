import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.time.StopWatch;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.lang.annotation.Native;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class ActionHandler implements NativeKeyListener {

    StopWatch stopwatch;
    static WindowController wc;
    FileHandler fh;
    boolean shift, f12, d;
    private static Logger logger = Logger.getLogger(GlobalScreen.class.getName());

    public ActionHandler(){
        stopwatch = new StopWatch();
        shift = false;
        f12 = false;
        d = false;

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(this);
        LogManager.getLogManager().reset(); //Cancels all logging of all events.
    }

    public void startWatch(ActionEvent event){
        bishPlease();
    }

    public void stopWatch(ActionEvent event){
        try{
            stopwatch.stop();
            stopwatch.reset();
            WindowController.timeText.setText("Not running");
            WindowController.timeText.setTextFill(Color.RED);
            fh.closeWriter();
            GlobalScreen.unregisterNativeHook();

        } catch(IllegalStateException ise){
            AlertBox.display("Stopped", "Stopwatch isn't running");
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.removeNativeKeyListener(new ActionHandler());
    }

    public void writeToFile(ActionEvent event){
        theWriter();
    }

    public void theWriter(){
        fh.addALine(stopwatch.toString());
    }

    public void bishPlease(){
        try {
            WindowController.timeText.setText("Running");
            WindowController.timeText.setTextFill(Color.GREEN);
            stopwatch.start();
            fh = new FileHandler();
        } catch(IllegalStateException ise){
            AlertBox.display("Running", "Stopwatch already running");
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke)
    {
        Platform.runLater( () -> {
        if(nke.getKeyCode() == NativeKeyEvent.VC_SHIFT){
            //System.out.print(NativeKeyEvent.getKeyText(nke.getKeyCode())); Can love everything.
            shift = true;
        }
        if(nke.getKeyCode() == NativeKeyEvent.VC_F12){
            f12 = true;
        }
        if(nke.getKeyCode() == NativeKeyEvent.VC_D) {
            d = true;
        }

        if(shift && d){
            theWriter();
        }

        if(shift && f12){
            bishPlease();
        }
        });
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        if(nke.getKeyCode() == NativeKeyEvent.VC_SHIFT){
            shift = false;
        }
        if(nke.getKeyCode() == NativeKeyEvent.VC_F12){
            f12 = false;
        }
        if(nke.getKeyCode() == NativeKeyEvent.VC_D){
            d = false;
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        //throw new UnsupportedOperationException("Not implemented jet");
    }

}
