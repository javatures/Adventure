import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    protected Scanner s;
    protected int room;
    protected Random r;
    protected Connection c;
    protected Hero hero;

    public Dungeon(Scanner s) {
        this.s = s;
        this.room = 1;
        this.r = new Random();
        try {
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.hero = new Hero(r, c);
    }

    public void play() {
        boolean isPlaying = true;

        while (isPlaying) {
            switch (room) {
                case 1:
                    isPlaying = room1();
                    break;
                case 2:
                    isPlaying = room2();
                    break;
                case 3:
                    isPlaying = room3();
                    break;
                case 4:
                    isPlaying = room4();
                    break;
                case 5:
                    isPlaying = room5();
                    break;
                case 6:
                    System.out.println("You won! Congratulations on defeating the dungeon!");
                    return;
                default:
                    System.err.println("Error: room has an unexpected value!");
                    break;
            }
            room++;
        }
    }

    private boolean room1() {
        System.out.println("Welcome to the dungeon.");
        int rng = r.nextInt(100);
        if (rng < 50) {
            System.out.println("Room 1 contains a goblin!");
            return combat("goblin");
        }
        if (rng < 75) {
            System.out.println("Room 1 is empty.");
            return true;
        }
        System.out.println("Room 1 contains a chest!");
        chest();
        return true;
    }

    private boolean room2() {
        System.out.println("You've reached room 2.");
        int rng = r.nextInt(100);
        if (rng < 50) {
            System.out.println("Room 2 contains a rogue!");
            return combat("rogue");
        }
        if (rng < 70) {
            System.out.println("Room 2 is empty.");
            return true;
        }
        System.out.println("Room 2 contains a chest!");
        chest();
        return true;
    }
    
    private boolean room3() {
        System.out.println("You've reached room 3.");
        int rng = r.nextInt(100);
        if (rng < 60) {
            System.out.println("Room 3 contains a wizard!");
            return combat("wizard");
        }
        if (rng < 70) {
            System.out.println("Room 3 is empty.");
            return true;
        }
        System.out.println("Room 3 contains a chest!");
        chest();
        return true;
    }

    private boolean room4() {
        System.out.println("You've reached room 4.");
        int rng = r.nextInt(100);
        if (rng < 65) {
            System.out.println("Room 4 contains a troll!");
            return combat("troll");
        }
        System.out.println("Room 4 contains a chest!");
        chest();
        return true;
    }

    private boolean room5() {
        System.out.println("You feel uneasy...");
        System.out.println("Room 5 contains a demon!");
        return combat("demon");
    }

    private boolean combat(String enemy) {
        Enemy e = new Enemy(enemy, r, c);
        while (true) {
            System.out.println("You're in combat! Would you like to attack, defend, or use an item?");
            String input = s.nextLine().toLowerCase();
            if (input.equals("attack")) {
                if (!hero.attack(e))
                return true;
                if (!e.attack(hero))
                return false;
            }
            else if (input.equals("defend")) {
                hero.defend();
                if (!e.attack(hero))
                return false;
                hero.undefend();
            }
            else if (input.split(" ")[0].equals("use")) {
                if (hero.useItem(input.substring(4))) {
                    if (!e.attack(hero))
                    return false;
                }
                else {
                    System.out.println("Item not found. Please try again.");
                }
            }
            else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private void chest() {
        // TODO: Use SQL to implement item statistics
    }
}
