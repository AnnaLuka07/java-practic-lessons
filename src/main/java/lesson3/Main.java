package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        test();
        foo();
//        ex1();
        ex2();
    }

    private static void foo() {
        String str = "123";

        int n = 0;
        try {
            n = Integer.parseInt(str);
            System.out.println(n + 1);

        } catch (NumberFormatException e) {
            System.out.println("Это было не число!");
        }

    }

    private static void test() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
//        arrayList.add("3");

//        arrayList.sort(Comparator.naturalOrder());
        Collections.addAll(arrayList, 1, 2, 3, 4, 5, 6, 7, 8);
        Collections.sort(arrayList, Collections.reverseOrder());

//        System.out.println(arrayList);

        arrayList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        List<String> names = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");

        List<String> planets = new ArrayList<>(names);
    }

    private static void ex1() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(20, 100));
        }

//        Collections.sort(arrayList);
        arrayList.sort(Comparator.reverseOrder());

        System.out.println(arrayList);
    }

    public static void ex2() {
        List<String> names = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");

        // Генерируем коллекцию планет с повторениями
        List<String> planets = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            planets.add(names.get(random.nextInt(names.size())));
        }

        System.out.println("Список планет с повторениями: " + planets);

        // Выводим количество повторений каждой планеты в исходном списке
        frequencyPlanet_1(names, planets);

        System.out.println("=============");

        frequencyPlanet_2(planets);
    }

    private static void frequencyPlanet_2(List<String> planets) {
        Collections.sort(planets);

        int count = 1;
        String prevPlanet = planets.get(0);

        for (int i = 1; i < planets.size(); i++) {
            String planet = planets.get(i);

            if (planet.equals(prevPlanet)) {
                count++;
            } else {
                System.out.println(prevPlanet + ": " + count);
                prevPlanet = planet;
                count = 1;
            }
        }

        System.out.println(prevPlanet + ": " + count);
    }

    private static void frequencyPlanet_1(List<String> names, List<String> planets) {
        System.out.println("Количество повторений каждой планеты:");
        for (String planetNames : names) {
            int count = 0;
            for (String planet : planets) {
                if (planetNames.equals(planet)) {
                    count++;
                }
            }
            System.out.println(planetNames + "\t->\t" + count);
        }
    }
}


