package entities;

public class Alien {
    private String name;
    private String type;

    public Alien(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
