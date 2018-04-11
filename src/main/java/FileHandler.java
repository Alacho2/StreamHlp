import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class FileHandler {
    PrintWriter pw;

    public FileHandler() throws URISyntaxException, FileNotFoundException, UnsupportedEncodingException {
        String fileName = giefNewName();
            //Get the path of jar directory.
            pw = new PrintWriter(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + fileName +  ".txt", "UTF-8");
        System.out.println(giefNewName());
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
