import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileHandler {
    PrintWriter pw;

    public FileHandler() throws  Exception {
        String fileName = giefNewName();
            pw = new PrintWriter(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + fileName +  ".txt");
            //file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + fileName +  ".txt");
            //file.
        System.out.println(giefNewName());
    }

    public String giefNewName(){
        String curTime = LocalDateTime.now().toString();
        curTime = curTime.replace(":", ".");
        curTime = curTime.substring(0, 19);
        curTime = "Stream" + curTime;

        return curTime;
    }
}
