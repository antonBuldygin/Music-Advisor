package advisor;

public class Playlist implements Parsable {
    private final String name;
    private final String externalUrl;

    public Playlist(String name, String externalUrl) {
        this.name = name;
        this.externalUrl = externalUrl;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", name, externalUrl);
    }
}
