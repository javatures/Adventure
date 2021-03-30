import java.util.Scanner;

public class Dungeon {
    private Scanner s;
    private int room;

    public Dungeon(Scanner s) {
        this.s = s;
        this.room = 1;
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
        }
    }

    // TODO: Write room methods
    private boolean room1() {
        return false; 
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
}
