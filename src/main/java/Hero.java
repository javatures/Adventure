import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character {
    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<String> items;
    protected int maxHealth;
    protected int level;
    protected boolean defending;

    public Hero(Random rand, Connection connect) {
        type = "player";
        level = 1;
        health = 10;
        maxHealth = 10;
        attack = 2;
        defense = 0;
        dodge = 5;
        defending = false;
        c = connect;
        weapon = new Weapon("none", c);
        armor = new Armor("none", c);
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

    public void defend() {
        dodge += 50;
    }

    public void undefend() {
        dodge -= 50;
    }

    public boolean useItem(String item) {
        // TODO: Write useItem method
        return true;
    }

    public void levelUp() {
        level++;
        maxHealth += 5;
        health = maxHealth;
        attack++;
        if (level % 2 == 0) {
            defense++;
            dodge += 5;
        }
    }
}
