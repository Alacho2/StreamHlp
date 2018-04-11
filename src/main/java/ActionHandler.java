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

    public ActionHandler() throws FileNotFoundException, UnsupportedEncodingException, URISyntaxException {
        sw = new StopWatch();
        file = new FileHandler();
    }

    public void action(){

    }

}
