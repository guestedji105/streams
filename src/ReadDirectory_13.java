import java.io.File;
public class ReadDirectory_13 {

    public static void main(String[] args) {
        createDirectory();
        listDirectory();
    }
    static void createDirectory() {
        String nameDir = "./example/subdir/newdir";
        File a = new File(nameDir);

        // Создание на диске папки и всех вышестоящих каталогов
        System.out.println(a.mkdirs());
    }
    static void listDirectory(){
        File pathDir = null;
        String[] pathsFilesAndDir;

        try {
            // Создание нового объекта file
            pathDir = new File("./"); // Обязательно должен существовать указанный каталог на диске, иначе программа выдаст ошибку

            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();

            for(String path:pathsFilesAndDir) {
                // Вывод списка файлов и каталогов
                System.out.println(path);
            }
        }catch(Exception e) {
            // Если произошла ошибка
            e.printStackTrace();
        }
    }
}