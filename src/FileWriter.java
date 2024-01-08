import java.io.*;
import java.util.Arrays;

public class FileWriter {
    static final int QUOTES_AND_COLON_LEN = 3;
    public static void main(String[] args) {
        File allureResults = new File("./allure-results");
        for (String s : Arrays.stream(allureResults.list((dir, fileName) -> fileName.contains("container.json"))).toList()) {
            printUuidAndTestName(s);
        }
    }

    static void printUuidAndTestName(String fileName){
        try (DataInputStream dis = new DataInputStream(new FileInputStream("./allure-results/" + fileName))) {
            //System.out.print("File: " + fileName);
            while (dis.available() > 0) {
                String content = dis.readLine();
                System.out.print("; UUID: " + getValue("uuid", content));
                System.out.println("; Name: " + getValue("name", content));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String getValue(String valueKey, String content) {
        int nameIndex = content.indexOf(String.format("\"%s\"", valueKey));

        if (nameIndex != -1) {
            int startIndex = content.indexOf("\"", nameIndex + valueKey.length() + QUOTES_AND_COLON_LEN) + 1;
            int endIndex = content.indexOf("\"", startIndex);

            return content.substring(startIndex, endIndex);
        }
        return "";
    }
}
