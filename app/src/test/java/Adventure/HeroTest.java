package Adventure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    
    @Test
    public void constructorTest() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Hero hero = new Hero(new Random(), c);
        assertEquals(hero.getLevel(), 1);
        assertEquals(hero.getAttack(), 2);
        assertEquals(hero.getWeapon().getName(), "none");
        assertEquals(hero.getWeapon().getAttack(), 0);
        assertEquals(hero.getArmor().getName(), "none");
        assertEquals(hero.getArmor().getDefense(), 0);
        assertEquals(hero.getArmor().getDodge(), 0);
    }
}