import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream_5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        try {
            fileIn = new FileInputStream("file.txt");
            fileOut = new FileOutputStream("copied_file.txt");
            int a;
            while ((a = fileIn.read()) != -1) {// Копирование содержимого файла file.txt
                fileOut.write(a); // Чтение содержимого файла file.txt и запись в файл copied_file.txt
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileIn != null) fileIn.close();
            if (fileOut != null) fileOut.close();
        }

    }
}
