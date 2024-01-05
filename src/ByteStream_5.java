import java.io.*;

public class ByteStream_5 {
    public static void main(String[] args) throws FileNotFoundException {
        byte[] byteArray = {65, 66, 67, 68, 69}; // ASCII значения для A, B, C, D, E

        try (ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
            int byteData;
            while ((byteData = bais.read()) != -1) {
                System.out.println((char) byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

