package lesson2;
//Дано число N (>0) и символы А и В
//Написать метод, кот.вернет длину строки N, которая состоит из чередования символов, начиная с А)
public class task1 {
    public static void main(String[] args) {
        int N = 10;
        char first = 'A';
        char second = 'B';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sb.append(first);
            }else {
                sb.append(second);
            }
        }
        System.out.println(sb);
    }
}
