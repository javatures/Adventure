import java.util.Random;

public class Enemy extends Character{
    
    public Enemy(String type, Random rand) {
        this.type = type;
        this.r = rand;
        // TODO: Read from SQL database to get enemy stats
    }
    
}
