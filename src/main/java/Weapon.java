import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Weapon {
    protected String name;
    protected int attack;
    protected Connection c;

    public Weapon(String name, Connection connect) {
        this.name = name;
        this.c = connect;
        try {
            ResultSet result = c.prepareStatement("select * from weapons").executeQuery();
            while (result.next()) {
                if (result.getString("weaponname").equals(name)) {
                    attack = result.getInt("attack");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}