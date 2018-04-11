import javafx.application.Application;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;


public class Main {

    public static void main(String[] args) {
        Application.launch(WindowController.class, args);

        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("Didn't manage to find location for file.");
        }

        try {
            throw new UnsupportedEncodingException();
        }catch (UnsupportedEncodingException e) {
            System.out.println("Can't use UTF-8");
        }
    }
}
