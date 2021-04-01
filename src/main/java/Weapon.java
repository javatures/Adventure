public class Weapon {
    protected String name;
    protected int attack;

    public Weapon(String name) {
        this.name = name;
        // TODO: Read from SQL database to get attack value
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}