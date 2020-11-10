import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static BigInteger result(BigInteger num1, BigInteger num2, BigInteger num3, BigInteger num4) {
        return num1.negate().multiply(num2).add(num3).subtract(num4);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] parts = scanner.nextLine().split("\\s+");

        BigInteger num1 = null;
        BigInteger num2 = null;
        BigInteger num3 = null;
        BigInteger num4 = null;

        try {
            num1 = new BigInteger(parts[0]);
            num2 = new BigInteger(parts[1]);
            num3 = new BigInteger(parts[2]);
            num4 = new BigInteger(parts[3]);
        } catch (Exception e) {
            System.out.println("Can't parse a big integer value");
            e.printStackTrace();
        }
        System.out.println(result(num1, num2, num3, num4));
    }
}