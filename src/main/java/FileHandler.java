import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class FileHandler {

    File file;
    FileWriter fw;

    public FileHandler() {
        String fileName = giefNewName();
        try {
            file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + fileName);
            fw = new FileWriter(file, true);

        } catch (URISyntaxException e) {
            AlertBox.display("String to URI Error", "Couldn't convert String to URI");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addALine(String whattime){
        try {
            fw.write(whattime + System.lineSeparator());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter(){
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String giefNewName(){
        String curTime = LocalDateTime.now().toString();
        curTime = curTime.replace(":", ".");
        curTime = curTime.substring(0, 19);
        curTime = "Stream" + curTime + ".txt";
        return curTime;
    }
}
