
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int stringLength = str.length();

        if (stringLength % 2 == 0) {
            evenCutting(stringLength, str);
        } else {
            oddCutting(stringLength, str);
        }
    }

    private static void evenCutting(int length, String str) {
        int begin = length / 2 + 1;
        int end = length / 2 - 1;
        System.out.println(str.substring(0, end) + str.substring(begin));
    }

    private static void oddCutting(int length, String str) {
        int begin = length / 2 + 1;
        int end = length / 2;
        System.out.println(str.substring(0, end) + str.substring(begin));
    }
}