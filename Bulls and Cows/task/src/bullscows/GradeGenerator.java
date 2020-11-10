package bullscows;

import java.util.Scanner;

public class GradeGenerator {

    public static int countCows(String secretCode, String input) {
        int cows = 0;
        for (int i = 0; i + 1 < secretCode.length(); i++) {
            if (secretCode.charAt(i) == input.charAt(i + 1)) {
                cows++;
            }
            if (input.charAt(i) == secretCode.charAt(i + 1)) {
                cows++;
            }
        }
        return cows;
    }

    public static int countBulls(String secretCode, String input) {
        int bulls = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == input.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    public static String stringCows (int cows) {
        if (cows > 0) {
            return "and " + cows + " cow(s)";
        } else {
            return "";
        }
    }

    public static String stringBulls (int bulls) {
        if (bulls > 0) {
            return bulls + " bull(s) ";
        } else {
            return "";
        }
    }

    public static void generateGrade (String secretCode, String input) {
        int cows = countCows(secretCode, input);
        int bulls = countBulls(secretCode,input);
        if (cows == 0 && bulls == 0) {
            System.out.println("Grade: None");
        } else {
            System.out.println("Grade: " + stringBulls(bulls)
                    + stringCows(cows));
        }
    }
}
