package lesson2;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(10000);

        for (int i = 0; i < 10000; i++) {
            sb.append(i).append(": ").append((char)i).append(System.lineSeparator());

            /*sb = sb.append(i);
            sb = sb.append(": ");
            sb = sb.append((char)i);*/
        }

        /*String strResult = sb.toString();
        System.out.println(strResult);*/

        System.out.println(sb);

    }
}

