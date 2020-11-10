package bullscows;

import com.sun.jdi.Value;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int size = 0;
        int range = 0;
        String secretCode = "";
        Pattern pattern = Pattern.compile("\\d{1,}");

        String stringSize = scanner.nextLine();
        if (!stringSize.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.\n", stringSize);
            return;
        }
        size = Integer.parseInt(stringSize);

        if (size > 36 || size <= 0) {
            System.out.printf("Error: can't generate a secret " +
                    "number with a length of %d because there aren't" +
                    " enough unique digits.%n", size);
        } else {
            System.out.println("Input the number of possible symbols in the code:");
            String stringRange = scanner.nextLine();

            if (!stringRange.matches("\\d+")) {
                System.out.printf("Error: %s isn't a valid number.\n", stringRange);
                return;
            }
                range = Integer.parseInt(stringRange);

            if (range < size) {
                System.out.println("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.");
            } else if (range > 36) {
                System.out.printf("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
                // scanner.nextLine();
                System.out.println(SecretCode.makeRangeStringForPrint(size, range));
                System.out.println("Okay, let's start a game!");
                secretCode = SecretCode.makeSecretCode(size, range);
                int bulls = 0;
                int turnNumber = 1;

                    do {
                        System.out.printf("Turn %d:%n", turnNumber);
                        String input = scanner.nextLine();
                        GradeGenerator.generateGrade(secretCode, input);
                        turnNumber++;
                        bulls = GradeGenerator.countBulls(secretCode, input);
                    } while (bulls < size);

                    if (bulls == size) {
                        System.out.println("Congratulations! You guessed the secret code.");
                    }
            }
        }
    }
}

