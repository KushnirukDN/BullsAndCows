import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double root1 = 0;
        double root2 = 0;

        double determinant = b * b - 4 * a * c;

        if(determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
        }

        if (root1 > root2) {
            System.out.println(root2 + " " + root1);
        } else {
            System.out.println(root1 + " " + root2);
        }
    }
}