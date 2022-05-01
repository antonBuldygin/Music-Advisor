import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(7);
        //write your code here
        ArrayList<Character> characters = new ArrayList<>();

        characters.add('a');
        characters.add('b');
        characters.add(1, 'c');
        characters.add(1, 'd');
        characters.add('e');
        characters.add(5, 'f');

        System.out.println(characters);
    }
}