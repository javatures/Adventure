public class Armor {
    protected String name;
    protected int defense;
    protected int dodge;

    public Armor(String name) {
        this.name = name;
        // TODO: Read from SQL database to get defense and dodge values
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodge() {
        return dodge;
    }
}
