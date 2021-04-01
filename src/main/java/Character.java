import java.util.Random;

public abstract class Character {
    protected String type;
    protected int health;
    protected int attack;
    protected int defense;
    protected int dodge;
    protected Random r;

    public boolean attack(Character opponent) {
        if (r.nextInt(100) < opponent.getDodge()) {
            return true;
        }
        int damage = getAttack() - opponent.getDefense();
        return opponent.takeDamage(damage);
    }

    public boolean takeDamage(int damage) {
        health -= damage;
        return health > 0;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodge() {
        return dodge;
    }
}
