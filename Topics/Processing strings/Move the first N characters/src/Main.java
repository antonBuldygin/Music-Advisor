import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        int n = scanner.nextInt();

        if (n > 0 && n <= s.length()) {
            System.out.println(s.substring(n) + s.substring(0, n));
        } else System.out.println(s);

    }
}