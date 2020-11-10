package bullscows;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

public class SecretCode {

    public static String makeIntegerPart (int size, int range) {
        Random random = new Random();

        long randomNumber = Math.abs((random.nextLong()) *  ((long) Math.pow(10, 15)));
        String randomNumberToString = Long.toString(randomNumber);
        String[] randomArray = randomNumberToString.split("");
        LinkedHashSet setUniqueChars = new LinkedHashSet(Arrays.asList(randomArray));
        String constructor = String.join("", setUniqueChars).substring(0, (range - (range - size)));

        return constructor;
    }

    public static String makeAplhabetPart (int size, int range) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabet.substring(0, range - 10);
        return alphabet;
    }

    public static String makeSecretCode (int size, int range) {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        String integerPart = makeIntegerPart(size, range);
        String alphabetPart = makeAplhabetPart(size, range);
        if (range > 10) {
            StringBuilder tempSecretCode = new StringBuilder(integerPart+alphabetPart);

            for (int i = 0; i < size; i++) {
               int nextChar = random.nextInt((size + range - 10) - i);
               secretCode.append(tempSecretCode.charAt(nextChar));
               tempSecretCode.deleteCharAt(nextChar);
            }
            return secretCode.toString();

        } else {
            return makeIntegerPart(size, range);
        }
    }

    public static String makeRangeStringForPrint (int size, int range) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sizeAster = new StringBuilder();
        StringBuilder charRange = new StringBuilder(", a-");

        for (int i = 0; i < size; i++) {
            sizeAster.append("*");
        }

        if (range <= 10) {
            return "The secret is prepared: " + sizeAster + " (0-9).";
        } else {
            charRange.append(alphabet.charAt(range - (10 + 1)));
            return "The secret is prepared: " + sizeAster + " (0-9, "   + charRange + ").";
        }
    }
}
