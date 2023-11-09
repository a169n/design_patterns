package factory;
import entities.Alien;
import entities.GreenAlien;
import entities.RedAlien;

public class AlienFactory {
    public static Alien createAlien(String name, String type) {
        if (type.equals("Green")) {
            return new GreenAlien(name);
        } else if (type.equals("Red")){
            return new RedAlien(name);
        }
        return null;
    }
}
