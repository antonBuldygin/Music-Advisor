import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();

        boolean res1 = h1 > 0 && h2 <= 0 && h3 <= 0;
        boolean res2 = h2 > 0 && h1 <= 0 && h3 <= 0;
        boolean res3 = h3 > 0 && h2 <= 0 && h1 <= 0;
        System.out.println(res1 || res2 || res3);
    }
}