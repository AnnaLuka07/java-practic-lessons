package lesson6;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ex1();
    }

    private static void ex0() {

//        List<String> data = List.of("Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять");
        List<?> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        var dataNew = new ArrayList<>(data);
        Collections.reverse(dataNew);

        System.out.println(new HashSet<>(dataNew));
        System.out.println(new LinkedHashSet<>(dataNew));
        System.out.println(new TreeSet<>(dataNew));
    }

    private static void ex1() {
        final int ARRAY_SIZE = 100000;
        Integer[] arr =  new Integer[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, ARRAY_SIZE + 1);
        }

        HashSet<Integer> uniq = new HashSet<>(Arrays.asList(arr));

        double n = uniq.size() * 100 / arr.length;
        System.out.printf("%.2f%n", 1.0 * uniq.size() * 100 / arr.length);
        System.out.println(n);
        System.out.println((double) uniq.size() * 100 / arr.length);

    }
}
