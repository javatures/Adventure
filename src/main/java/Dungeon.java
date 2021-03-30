import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    private Scanner s;
    private int room;
    private Random r;
    private Hero hero;

    public Dungeon(Scanner s) {
        this.s = s;
        this.room = 1;
        this.r = new Random();
        this.hero = new Hero();
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
        return chest();
    }

    private boolean room2() {
        return true;
    }
    
    private boolean room3() {
        return true;
    }

    private boolean room4() {
        return true;
    }

    private boolean room5() {
        return true;
    }

    private boolean combat(String enemy) {
        // TODO: Use SQL to implement enemy statistics
    }

    private boolean chest() {
        // TODO: Use SQL to implement item statistics
    }
}
