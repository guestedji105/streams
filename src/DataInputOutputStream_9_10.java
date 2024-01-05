import java.io.*;

public class DataInputOutputStream_9_10 {
    public static void main(String[] args) throws IOException {
        //readShortsFromFile();
        //writeShortsToFile();
        readWriteTextToFile();
    }

    static void readWriteTextToFile() throws IOException {
        // Запись строки в файл в кодировке UTF-8
        DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("data_out_test.txt"));
        //dataOutput.writeBytes("Sample data write to text file without typecasting or providing any additional parameters");
        dataOutput.writeUTF("Sample data write to text file without typecasting or providing any additional parameters");
        // Чтение данных из того же файла
        DataInputStream dataInput = new DataInputStream(new FileInputStream("data_out_test.txt"));
        while(dataInput.available() > 0) {
            String a = dataInput.readUTF();
            //System.out.print(dataInput.readLine());
            System.out.print(a);
        }
    }

    static void writeShortsToFile() {
        short[] shortsToWrite = {32767, 1, 12345, 9999};

        String filePath = "data_shorts.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (short value : shortsToWrite) {
                dos.writeShort(value);
                System.out.println("Wrote short: " + value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readShortsFromFile() {
        String filePath = "data_shorts.bin";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                short readShort = dis.readShort();
                System.out.println("Read short: " + readShort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
