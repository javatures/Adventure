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
            System.out.println("You're in combat! What would you like to do?");
            String input = s.nextLine().toLowerCase();
            if (input.equals("attack")) {
                if (!hero.attack(e)) {
                    System.out.println("You win!");
                    hero.levelUp();
                    return true;
                }
                if (!e.attack(hero)) {
                    System.out.println("You died!");
                    return false;
                }
            }
            else if (input.split(" ")[0].equals("use")) {
                if (hero.useItem(input.substring(4))) {
                    if (!e.attack(hero))
                        System.out.println("You died!");
                        return false;
                }
                else {
                    System.out.println("Item not found. Please try again.");
                }
            }
            else if (input.equals("view items")) {
                System.out.println(hero.getItems());
            }
            else if (input.equals("view stats")) {
                System.out.println(hero.getStats());
            }
            else if (input.equals("help")) {
                System.out.println("Possible commands:");
                System.out.println("'attack' to attack the enemy");
                System.out.println("'use [item name]' to use an item from your inventory");
                System.out.println("'view items' to view the items in your inventory");
                System.out.println("'view stats' to view your current stats\n");
            }
            else {
                System.out.println("Invalid command. You can type 'help' for a list of commands.");
            }
        }
    }

    private void chest() {
        boolean reward = false;
        switch (room) {
            case 1:
                if (r.nextInt(100) < 50) {
                    System.out.println("You found a dagger! It deals 1 damage, and your current weapon deals "
                        + hero.getWeapon().getAttack() + " damage.");
                    System.out.println("Would you like to switch weapons? (y/n)");
                    String input = s.nextLine().toLowerCase();
                    while (!input.equals("y") && !input.equals("n")) {
                        System.out.println("Invalid response. Would you like to switch weapons? (y/n)");
                        input = s.nextLine().toLowerCase();
                    }
                    if (input.equals("y"))
                        hero.setWeapon(new Weapon("dagger", c));
                    reward = true;
                }
                if (r.nextInt(100) < 50) {
                    System.out.println("You found leather armor! It has 1 defense and 0 dodge, and your current armor has " +
                        hero.getArmor().getDefense() + " defense and " + hero.getArmor().getDodge() + " dodge.");
                    System.out.println("Would you like to switch armor? (y/n)");
                    String input = s.nextLine().toLowerCase();
                    while (!input.equals("y") && !input.equals("n")) {
                        System.out.println("Invalid response. Would you like to switch armor? (y/n)");
                        input = s.nextLine().toLowerCase();
                    }
                    if (input.equals("y"))
                        hero.setArmor(new Armor("leather", c));
                    reward = true;
                }
                if (!reward) {
                    System.out.println("You found a HP potion! It has been added to your inventory.");
                }
                break;
            case 2:
            if (r.nextInt(100) < 50) {
                System.out.println("You found a sword! It deals 2 damage, and your current weapon deals "
                    + hero.getWeapon().getAttack() + " damage.");
                System.out.println("Would you like to switch weapons? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch weapons? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setWeapon(new Weapon("sword", c));
                reward = true;
            }
            if (r.nextInt(100) < 50) {
                System.out.println("You found light armor! It has 0 defense and 10 dodge, and your current armor has " +
                    hero.getArmor().getDefense() + " defense and " + hero.getArmor().getDodge() + " dodge.");
                System.out.println("Would you like to switch armor? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch armor? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setArmor(new Armor("light", c));
                reward = true;
            }
            if (!reward) {
                System.out.println("You found a max HP potion! It has been added to your inventory.");
            }
            break;
            case 3:
            if (r.nextInt(100) < 50) {
                System.out.println("You found a sword! It deals 2 damage, and your current weapon deals "
                    + hero.getWeapon().getAttack() + " damage.");
                System.out.println("Would you like to switch weapons? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch weapons? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setWeapon(new Weapon("sword", c));
                reward = true;
            }
            if (r.nextInt(100) < 50) {
                System.out.println("You found iron armor! It has 2 defense and 0 dodge, and your current armor has " +
                    hero.getArmor().getDefense() + " defense and " + hero.getArmor().getDodge() + " dodge.");
                System.out.println("Would you like to switch armor? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch armor? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setArmor(new Armor("iron", c));
                reward = true;
            }
            if (!reward) {
                System.out.println("You found a dodge potion! It has been added to your inventory.");
            }
            break;
            case 4:
            if (r.nextInt(100) < 50) {
                System.out.println("You found Excalibur! It deals 3 damage, and your current weapon deals "
                    + hero.getWeapon().getAttack() + " damage.");
                System.out.println("Would you like to switch weapons? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch weapons? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setWeapon(new Weapon("excalibur", c));
                reward = true;
            }
            if (r.nextInt(100) < 50) {
                System.out.println("You found iron armor! It has 2 defense and 0 dodge, and your current armor has " +
                    hero.getArmor().getDefense() + " defense and " + hero.getArmor().getDodge() + " dodge.");
                System.out.println("Would you like to switch armor? (y/n)");
                String input = s.nextLine().toLowerCase();
                while (!input.equals("y") && !input.equals("n")) {
                    System.out.println("Invalid response. Would you like to switch armor? (y/n)");
                    input = s.nextLine().toLowerCase();
                }
                if (input.equals("y"))
                    hero.setArmor(new Armor("iron", c));
                reward = true;
            }
            if (!reward) {
                System.out.println("You found a HP potion! It has been added to your inventory.");
                System.out.println("You found an attack potion! It has been added to your inventory.");
            }
            break;
            case 5: break;
            default:
            System.err.println("Error: Invalid room when opening a chest!");
            break;
        }
    }
}
