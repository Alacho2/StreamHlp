import org.apache.commons.lang3.time.StopWatch;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class FileHandler {
    static StopWatch stopwatch;
    PrintWriter pw;

    public FileHandler() {
        String fileName = giefNewName();

        try {
            //Get the path of jar directory.
            pw = new PrintWriter(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + fileName +  ".txt", "UTF-8");
        } catch (FileNotFoundException e) {
            AlertBox.display("File Not Found", "Didn't manage to make a new file.");
        } catch (UnsupportedEncodingException e) {
            AlertBox.display("Encoding Format Error", "Expected UTF-8. Fileformat was different.");
        } catch (URISyntaxException e) {
            AlertBox.display("String to URI Error", "Couldn't convert String to URI");
        }
    }

    public void addALine(String whattime){
        pw.append(whattime);
    }

    public String giefNewName(){
        String curTime = LocalDateTime.now().toString();
        curTime = curTime.replace(":", ".");
        curTime = curTime.substring(0, 19);
        curTime = "Stream" + curTime;

        return curTime;
    }
}
