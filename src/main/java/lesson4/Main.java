package lesson4;

import java.io.*;
import java.util.*;

public class Main {
    private static Scanner fileScanner;
    private static PrintWriter printWriter;
    private static File file;
    public static void main(String[] args) {
//        ex0();
        ex1();
    }

    private static void ex0() {
        final int SIZE = 1_000_000;
        Random random = new Random();

        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(0, random.nextInt());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(0, random.nextInt());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }

    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();

        Map<Integer, String> wordsMap = getValuesFromFile();

        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.trim().length() == 0) {
//            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("каша не вари")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordsMap);
                continue;
            }
            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("\\~");

            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue;
            }

            String word = parts[0];
            int num = 0;

            try {
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Выражение не содержит числа");
                continue;
            }


            if (word.equalsIgnoreCase("print")) {
                if (!wordsMap.containsKey(num - 1) || valueIsNull(wordsMap, num)) {
                    System.out.println("Указанного значения не существует");
                    continue;
                } else {
                    System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
                    wordsMap.remove(num - 1);
                }
            } else if (wordsMap.containsKey(num - 1)) {
                String oldWord = wordsMap.get(num - 1);

                if (valueIsNull(wordsMap, num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordsMap.put(num - 1, word);
            } else {
                wordsMap.put(wordsMap.size(), word);
                printAddMessage(word, num);
            }

            StringBuilder sb = new StringBuilder();
            for (Integer key : wordsMap.keySet()) {
                sb.append(key).append(" ").append(wordsMap.get(key));
            }
            printWriter.print(sb);
        }


    }

    private static void printAllNotNullValues(Map<Integer, String> wordsMap) {
        for (Integer num : wordsMap.keySet()) {
            System.out.printf("%d) %s%n", num, wordsMap.get(num));
        }
    }

    private static boolean valueIsNull(Map<Integer, String> wordsMap, int num) {
        return wordsMap.get(num - 1) == null;
    }

    private static Map<Integer, String> getValuesFromFile() {

        try {
            file = new File("src/main/resources/files/values.txt");
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Map<Integer, String> resultMap = new TreeMap<>();
        while (fileScanner.hasNextLine()) {
            String[] parts = fileScanner.nextLine().split("\s", 2);
            resultMap.put(Integer.parseInt(parts[0]), parts[1]);
        }

        return resultMap;
    }

    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >= 1 & num <= size;
    }
}
