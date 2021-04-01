import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character {
    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<String> items;
    protected int maxHealth;
    protected int level;

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

    @Override
    public int getAttack() {
        return attack + weapon.getAttack();
    }

    @Override
    public int getDefense() {
        return defense + armor.getDefense();
    }

    @Override
    public int getDodge() {
        return dodge + armor.getDodge();
    }

    public int getLevel() {
        return level;
    }

    public String getItems() {
        String output = "";
        for (String item: items) {
            output += item + "\n";
        }
        return output;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void useItem(String item) {
        // TODO: Write useItem method
    }

    public void levelUp() {
        // TODO: Write levelUp method
    }
}
