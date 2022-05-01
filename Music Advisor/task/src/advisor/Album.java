package advisor;

import java.util.Arrays;

public class Album  implements Parsable{
    private String name;
    private String externalUrl;
    private String [] array;


    public Album(String [] array,String name, String externalUrl ) {
        this.array =array;
        this.name = name;
        this.externalUrl = externalUrl;

    }

    public String getName() {
        return name;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public String[] getArray() {
        return array;
    }
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s", name, Arrays.toString(array), externalUrl);
    }
}
