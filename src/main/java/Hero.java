import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character {
    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<String> items;
    protected int maxHealth;
    protected int level;
    protected Random r;

    public Hero(Random rand) {
        type = "player";
        level = 1;
        health = 10;
        maxHealth = 10;
        attack = 2;
        defense = 0;
        dodge = 5;
        weapon = new Weapon("none");
        armor = new Armor("none");
        items = new ArrayList<>();
        r = rand;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getItems() {
        // TODO: Make this return a String of items instead
        return items;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public boolean attack(Character opponent) {
        // TODO: Write attack method
        return true;
    }

    public void useItem(String item) {
        // TODO: Write useItem method
    }

    public void levelUp() {
        // TODO: Write levelUp method
    }
}
