package lesson1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        sout
//        System.out.println("Hello, world!");
//        test();
//        inputNameAndPrintHi();
        arrMax();
    }

    private static void test() {
        System.out.println("Apple");
        System.out.print("Apple");
        System.out.println();
        System.out.printf("%3d -- %.2f -- %s%n", 5, 5.45456456, "Hello");
    }
//    private static void inputNameAndPrintHi() {
//        Пример того, как не пишут...ниже, как правильно.
//        Scanner iscanner = new Scanner(System.in);
//        System.out.printf("введите имя: ");
//        String name = iscanner.nextLine();
//        System.out.printf("Привет, %s!", name);
//        iscanner.close();
//    }
    private static void inputNameAndPrintHi() {
        //lowerCamelCase
        //UpperCamelCase
        Scanner in = new Scanner(System.in);
        System.out.printf("name: ");
        String name = in.nextLine();
        System.out.printf("Привет, %s!", name);
        in.close();

    }
    private static void inputNameAndPrintHiAtTime() {
        Scanner iscanner = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = iscanner.nextLine();
        System.out.println(LocalDateTime.now());
        var time = LocalDateTime.now();

    }
    private static void arrMax() {
        int[] arr = {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
        int count = 0;
        int temp = 0;

//        for (int i = 0; i < arr.length; i++) {
//              int num = arr[i];
        for (int num : arr) {
            if (num == 1) {
                temp++;
                if (count < temp) {
                    count = temp;
                }
            } else {

                temp = 0;
            }
        }

        System.out.println(count);
    }

}
