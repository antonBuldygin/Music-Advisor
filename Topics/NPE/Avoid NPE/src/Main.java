import java.util.*;

class FixingNullPointerException {

    public static void main(String[] args) {

        String s = null;
        s.replace("a", "b");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = "null".equals(string) ? null : string;
        /* Do not change code above */

        string = string !=null? string.toLowerCase():"NPE!";
        System.out.println(string);
    }
}