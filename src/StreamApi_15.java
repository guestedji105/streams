import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi_15 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Doe", "Alice", "Bob");
        // Пример 1: Отфильтровать и вывести имена на 'J'
        names.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(System.out::println);
        // Пример 2: Перевести имена в верхний регистр и собрать в List
        List<String> uppercasedNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(uppercasedNames);
        // Пример 3: Посчитать количество имен с длиной больше 3
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();
        System.out.println("Number of names with length > 3: " + count);
    }
}
