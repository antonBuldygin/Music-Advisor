import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> initial = new ArrayList<>();
        for (String s : scanner.nextLine().split("\\s+")) {
            initial.add(s);
        }

        System.out.println(initial);
    }
}