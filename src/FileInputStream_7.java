import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_7 {
    public static void main(String[] args) throws IOException {
        //plainRead();
        chunkRead();
        //bytesCountRead();
    }

    static void plainRead() throws FileNotFoundException {
        File a = new File("fine.jpg");
        FileInputStream fis = new FileInputStream(a);
        try {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.println("Current byte: " + byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void chunkRead() throws IOException {
        File a = new File("fine.jpg");
        FileInputStream fis = new FileInputStream(a);
        byte[] r = new byte[1024];
        try {
            int byteData;
            int count = 0;
            while ((byteData = fis.read(r)) != -1) {
                count++;
                System.out.println("Current bytes size: " + byteData + "; Chunk #" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
    }

    static void bytesCountRead() throws FileNotFoundException {
        File a = new File("fine.jpg");
        FileInputStream fis = new FileInputStream(a);
        try {
            System.out.println("Bytes available for read: " + fis.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
