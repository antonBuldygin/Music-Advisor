import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String sub = scanner.nextLine();

        String res = s.replace(sub, "");

        int freq = (s.length() - res.length()) / sub.length();

        System.out.println(freq);

    }
}
