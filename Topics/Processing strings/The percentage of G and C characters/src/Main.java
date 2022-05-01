import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String genomeSequences = scanner.nextLine();

        char[] gCcount = genomeSequences.toLowerCase().toCharArray();

        int count = 0;

        for (char gc :
                gCcount) {
            if (gc == 'g' || gc == 'c') {
                ++count;

            }

        }
        System.out.println((double) count / genomeSequences.length() * 100.0);
    }
}