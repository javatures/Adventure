package Adventure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Armor {
    protected String name;
    protected int defense;
    protected int dodge;
    protected Connection c;

    public Armor(String name, Connection connect) {
        this.name = name;
        this.c = connect;
        try {
            ResultSet result = c.prepareStatement("select * from armors").executeQuery();
            while (result.next()) {
                if (result.getString("armorname").equals(name)) {
                    defense = result.getInt("defense");
                    dodge = result.getInt("dodge");
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

    public int getDefense() {
        return defense;
    }

    public int getDodge() {
        return dodge;
    }
}
