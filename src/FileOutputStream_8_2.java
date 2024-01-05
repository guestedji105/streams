import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_8_2 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("example_out.txt")) {
            String data = "Hello, World!";
            byte[] byteData = data.getBytes();
            fos.write(byteData);
            fos.write(byteData, 3, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
