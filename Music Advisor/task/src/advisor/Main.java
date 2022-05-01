package advisor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

            Scanner scanner = new Scanner(System.in);

        Map<String, String> argsMap = new HashMap<>();

        try {
            for (int i = 0; i < args.length; i += 2) {
                argsMap.put(args[i], args[i + 1]);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        Config.SERVER_PATH = argsMap.getOrDefault("-access", Config.SERVER_PATH);
        Config.SPOTIFY_API_PATH = argsMap.getOrDefault("-resource", Config.SPOTIFY_API_PATH);
        Config.ENTRIES_PER_PAGE =argsMap.getOrDefault("-page", Config.ENTRIES_PER_PAGE);
//        if (args.length > 1 && args[0].equals("-access")) { Config.SERVER_PATH = args[1]; }

        MusicAdvisor advisor = new MusicAdvisor();
        advisor.advise();
    }
}