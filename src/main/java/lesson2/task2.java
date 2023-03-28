package lesson2;
//сократить количество символов(дана строка ааааббббббввгдддд, должно получиться а4б6в2гд4)
public class task2 {
    public static void main(String[] args) {
        String str1 = "aaabbcdd";
        System.out.println(pressString(str1));
        group1(str1);
    }

    private static String pressString(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        char current = array[0];
        char next = 0;

        for (int i = 0; i < array.length - 1; i++) {
            current = array[i];
            next = array[i + 1];

            if (current != next) {
                sb.append(current);
                if (count > 1) {
                    sb.append(count);
                }
                count = 0;
            }
            count++;

        }
        return sb.append(array[array.length - 1])
                .append((count > 1) ? count : "")
                .toString();
    }

    private static void group1(String str) {
        if (str.length() == 0) {
            System.out.println("Строка пуста");
            return;
        }

        char[] array = str.toCharArray();
        System.out.println(array);
        int count = 1;
        char current = array[0];
        char next = 0;
        StringBuilder res = new StringBuilder(String.valueOf(current));

        for (int i = 0; i < str.length() - 1; i++) {
            current = array[i];
            next = array[i + 1];

            if (next != current) {
                if (count > 1) {
                    res.append(count);
                }
                res.append(next);
                count = 0;
            }
            count++;

        }
        if (count > 1) {
            res.append(count);
        }


        System.out.println(res);
    }
}


