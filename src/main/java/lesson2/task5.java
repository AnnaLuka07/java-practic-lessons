package lesson2;
//1.метод, который вернет содержимое текущей папки в виде массива строк
//2.метод, который запишет массив, возвращенный предыдущим методом в файл
//3.Обработайте ошибки с помощью try catсh, ошибки должны записаться  в log файл
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class task5 {
    static Logger logger = Logger.getLogger("Task5");

    public static void main(String[] args) {

        ex5("D:\\Обучение GB\\11. Java\\java-practic1");
    }

    private static void ex5(String pathDir) {
        String[] filesNamesFromDir = new String[0];
        try {
            filesNamesFromDir = convertPathToNamesArr(pathDir);
        } catch (DirectoryIsNotFoundException e) {
            logger.severe(e.getMessage());
            System.exit(1);
        }

        StringBuilder sb = new StringBuilder();
        for (String fileName : filesNamesFromDir) {
            sb.append(fileName).append(System.lineSeparator());
        }

/*        PrintWriter pw = null;
        try {
            pw = new PrintWriter("src/main/resources/files/lesson2_5.txt");
            pw.print(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            pw.close();
        }*/

        File output = new File("src/main/resources/files/lesson2_5.txt");
        if (!output.exists()) {
            try {
                output.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(output, true))) {
            pw.print(sb);
        } catch (IOException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException("Файл не найден по пути: " + output.getPath());
        }
    }

    private static String[] convertPathToNamesArr(String path) {
        File dir = new File(path);

        if (!dir.isDirectory()) {
            throw new DirectoryIsNotFoundException("По указанному пути не было найдено директории: " + path);
        }
        return dir.list();

    }
}
