import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character {
    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<String> items;
    protected int maxHealth;
    protected int level;

    public Hero(Random rand, Connection connect) {
        type = "player";
        level = 1;
        health = 10;
        maxHealth = 10;
        attack = 2;
        defense = 0;
        dodge = 5;
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getStats() {
        String output = "HP: " + health + "/" + maxHealth + "\n";
        output += "Attack: " + attack;
        if (!weapon.getName().equals("none"))
            output += " + " + weapon.getAttack() + " from your " + weapon.getName();
        output += "\n";
        output += "Defense: " + defense;
        if (!armor.getName().equals("none"))
            output += " + " + armor.getDefense() + " from your " + armor.getName();
        output += "\n";
        output += "Dodge: " + dodge + "%";
        if (!armor.getName().equals("none"))
            output += " + " + armor.getDodge() + "% from your " + armor.getName();
        output += "\n";
        return output;
    }

    @Override
    public boolean attack(Character opponent) {
        if (r.nextInt(100) < opponent.getDodge()) {
            System.out.println("You attack, but the " + opponent.getType() + " dodges!");
            return true;
        }
        int damage = getAttack() - opponent.getDefense();
        System.out.println("You attack the " + opponent.getType() + ", dealing " + damage + " damage!");
        return opponent.takeDamage(damage);
    }

    public boolean useItem(String item) {
        int index = items.indexOf(item);
        if (index == -1) {
            return false;
        }
        if (item.equals("hp potion")) {
            System.out.println("Healed 10 HP!");
            health = Math.min(health + 10, maxHealth);
            items.remove(index);
        }
        else if (item.equals("max hp potion")) {
            System.out.println("Increased max HP by 5!");
            maxHealth += 5;
            items.remove(index);
        }
        else if (item.equals("attack potion")) {
            System.out.println("Increased attack by 1!");
            attack++;
            items.remove(index);
        }
        else if (item.equals("dodge potion")) {
            System.out.println("Increased dodge chance by 5%!");
            dodge += 5;
            items.remove(index);
        }
        else {
            System.err.println("Error: invalid item in items list!");
            return false;
        }
        return true;
    }

    public void levelUp() {
        System.out.println("Level up! Your stats have increased!");
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
