import org.apache.commons.lang3.time.StopWatch;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

//Implement JNativeHook NativeKeyEvent.VK_-keycomb-
//Add action-method for what to happen
//Add

public class ActionHandler {

    StopWatch sw;
    FileHandler file;
    static WindowController wc;

    public ActionHandler() {
        sw = new StopWatch();
        try {
        file = new FileHandler();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }

}
