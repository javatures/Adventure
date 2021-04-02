import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Enemy extends Character{
    
    public Enemy(String type, Random rand, Connection connect) {
        this.type = type;
        this.r = rand;
        this.c = connect;
        try {
            ResultSet result = c.prepareStatement("select * from enemies").executeQuery();
            while (result.next()) {
                if (result.getString("enemytype").equals(type)) {
                    health = result.getInt("health");
                    attack = result.getInt("attack");
                    defense = result.getInt("defense");
                    dodge = result.getInt("dodge");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
