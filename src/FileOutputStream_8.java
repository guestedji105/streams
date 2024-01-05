import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_8 {
    public static void main(String[] args) {
        //appendTest();
        flushTest();
    }

    static void appendTest() {
        File f = new File("example_out.txt");
        for (int i = 0; i < 3; i++) {
            try (FileOutputStream fos = new FileOutputStream(f, true)) {
                String data = "Hello, World!\r\n";
                byte[] byteData = data.getBytes();
                fos.write(byteData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static void flushTest() {
        File f = new File("example_out.txt");
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write("Before flush #1\r\n".getBytes());
            fos.write("Before flush #2\r\n".getBytes());
            fos.flush();
            fos.write("After flush\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
