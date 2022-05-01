package advisor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;


public class MusicAdvisor {
    boolean adviceOn = false;
    String cName;
    Parsable[] cashedCategories;
    Parsable[] result;

    void advise() {
        adviceOn = true;
        chooseCommand();
    }

    void chooseCommand() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNext("auth")) {
            if (scanner.nextLine().equals("exit")) {
                exit();
                break;
            }
            System.out.println("Please, provide access for application.");
        }

        while (adviceOn) {
            String command = scanner.nextLine();

            if (command.contains("playlists")) {
                String[] category = command.split(" ");
                command = "playlists";
                if (category.length > 1) {

                    cName = String.join(" ", Arrays.copyOfRange(category, 1, category.length));

                }
                if (category.length <= 1) {
                    throw new IllegalArgumentException(
                            "Invalid command arguments. Please specify playlist category.");
                }

            }


            switch (command) {
                case "new":

                    result = Parsable.parse(Client.getInstance().postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/new-releases"), 0);

                    Pagination.printFirstPage(result);
                    Pagination.printPageNumberAndTotalPages();

//                    Parsable.printView(res);

                    break;
                case "featured":
                    result = Parsable.parse(Client.getInstance().postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/featured-playlists"), 1);

                    Pagination.printFirstPage(result);
                    Pagination.printPageNumberAndTotalPages();
//                    Parsable.printView(res1);

                    break;
                case "categories":
                    if (Client.postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/categories") != null) {
                        result = Parsable.parse(Client.getInstance().postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/categories"), 0);
                        cashedCategories = result;

                        Pagination.printFirstPage(result);
                        Pagination.printPageNumberAndTotalPages();
//                        Parsable.printView(res2);
                    }
                    break;
                case "playlists":

                    String categoryId = null;
                    if (cashedCategories == null) {
                        if (Client.postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/categories") != null) {

                            cashedCategories = Parsable.parse(Client.getInstance().postToGetNewReleases(Config.SPOTIFY_API_PATH + "/v1/browse/categories"), 0);
                        }

                    }

                    for (Parsable category : cashedCategories
                    ) {
                        if (((Category) category).getName().equals(cName)) {
                            categoryId = ((Category) category).getId();
                        }
                    }
                    if (categoryId == null) {
                        System.out.println("Unknown category name.");
                        break;
                    }
                    String uri = Config.SPOTIFY_API_PATH + "/v1/browse/categories/" + categoryId + "/playlists";
                    JsonObject temp = Client.postToGetNewReleases(uri);

                    Set<Map.Entry<String, JsonElement>> members = temp.entrySet();
                    List<Map.Entry<String, JsonElement>> membersList = new ArrayList<>(members);

                    String type = membersList.get(0)
                            .getKey()
                            .equals("error") ? "error" : "OK";

                    if (type == "error") {
                        JsonObject Obj = temp.getAsJsonObject("error");
                        String status = Obj.get("status").getAsString();
                        String message = Obj.get("message").getAsString();

                        if (status.equals("404")) {
                            System.out.println(message);
                            break;
                        }
                    } else {
                        result = Parsable.parse(temp, 0);
                        Pagination.printFirstPage(result);
                        Pagination.printPageNumberAndTotalPages();

//                        Parsable.printView(res3);
                    }
                    break;
                case "next":
                    Pagination.printNextPage(result);

                    break;
                case "prev":
                    Pagination.printPrevPage(result);

                    break;

                case "exit":
//                    exit();
                    continue;
                case "auth":
                    auth();
                    break;
                default:
                    error();
            }
        }
    }

    void auth() {
        Authorization auth = new Authorization();
        auth.createHttpServer();
        auth.authRequest();
    }

    void error() {
        System.out.println("Incorrect command. Try again.");
    }

    void exit() {
        System.out.println("---GOODBYE!---");
        adviceOn = false;
    }
}