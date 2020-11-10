import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = scanner.nextBigInteger();
        long n = 1;
        BigInteger integaralN;

        do {
            integaralN = factorial(n);
            n++;
        } while (integaralN.compareTo(number) > 1);
        System.out.println(n - 1);
    }

    public static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}