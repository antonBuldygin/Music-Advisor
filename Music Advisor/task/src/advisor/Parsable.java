package advisor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

public interface Parsable {

    static Parsable[] parse(JsonObject responseJsonObject, Integer flag) {
        Set<Map.Entry<String, JsonElement>> members = responseJsonObject.entrySet();
        List<Map.Entry<String, JsonElement>> membersList = new ArrayList<>(members);
//        System.out.println(membersList.get(0));

        String type = membersList.get(0)
                .getKey()
                .equals("message") ? membersList.get(1)
                .getKey() : membersList.get(0)
                .getKey();
//        System.out.println("type: " + type);

        JsonArray content = membersList.get(flag)
                .getValue()
                .getAsJsonObject()
                .getAsJsonArray("items");

        int size = content.size();
//        System.out.println(size);
//        System.out.println(content);

        Parsable[] ret = new Parsable[size];
        for (int j = 0; j < size; j++) {
            if ("categories".equals(type)) {
                String name = content.get(j)
                        .getAsJsonObject()
                        .get("name")
                        .getAsString();
                String id = content.get(j)
                        .getAsJsonObject()
                        .get("id")
                        .getAsString();
                ret[j] = new Category(name, id);
            }
            if ("albums".equals(type)) {
                String name = content.get(j)
                        .getAsJsonObject()
                        .get("name")
                        .getAsString();
                List<String> artists = new ArrayList<>();
                JsonArray artistsJsonArray = content.get(j)
                        .getAsJsonObject()
                        .get("artists")
                        .getAsJsonArray();
                for (JsonElement artist : artistsJsonArray) {
                    artists.add(((JsonObject) artist).get("name")
                            .getAsString());
                }
                String externalUrl = content.get(j)
                        .getAsJsonObject()
                        .get("external_urls")
                        .getAsJsonObject()
                        .get("spotify")
                        .getAsString();
                ret[j] = new Album(artists.toArray(new String[0]), name, externalUrl);

            }
            if ("playlists".equals(type)) {

                String name = content.get(j)
                        .getAsJsonObject()
                        .get("name")
                        .getAsString();
                String externalUrl = content.get(j)
                        .getAsJsonObject()
                        .getAsJsonObject("external_urls")
                        .get("spotify")
                        .getAsString();
                ret[j] = new Playlist(name, externalUrl);
            }
        }return ret;
    }

    static void printView(Parsable[] res){
        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i]);
            if ( !(res[i] instanceof Category)) {
                System.out.println();
            }

        }
    }
}
