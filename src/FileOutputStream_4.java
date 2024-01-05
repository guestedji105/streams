import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_4 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("example_out.txt")) {
            String data = "Hello, World!";
            byte[] byteData = data.getBytes();
            fos.write(byteData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
