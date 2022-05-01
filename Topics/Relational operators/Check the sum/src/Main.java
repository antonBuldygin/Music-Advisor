import java.util.Scanner;

class Main {
    final static int TWENTY = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        boolean check = a + b == TWENTY || a + c == TWENTY || b + c == TWENTY;
        System.out.println(check);
    }
}