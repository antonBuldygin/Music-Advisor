import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dateToConvert = scanner.nextLine();

        dateToConvert.replace('-', '/');


        StringBuilder output = new StringBuilder(dateToConvert.replace('-', '/'));

        output.substring(3);

        System.out.println(output.substring(5, 8) +
                output.substring(8, output.length()) +"/"+ output.substring(0, 4));
    }
}