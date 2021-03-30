public abstract class Character {
    protected String type;
    protected int health;
    protected int attack;
    protected int defense;
    protected int dodge;

    public abstract boolean attack(Character opponent);

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
