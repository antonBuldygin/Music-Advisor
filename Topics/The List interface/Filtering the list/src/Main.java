import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> initial = new ArrayList<>();
        for (String s : scanner.nextLine().split("\\s+")) {
            Integer parseInt = Integer.parseInt(s);
            initial.add(parseInt);
        }

        List<Integer> nwList = new ArrayList<>();
        for (int i = 0; i < initial.size(); i++) {

            if (i % 2 != 0) {
                nwList.add(initial.get(i));

            }
        }
        Collections.reverse(nwList);

        for (Integer integer: nwList){
        System.out.print(integer+ " ");}
    }
}