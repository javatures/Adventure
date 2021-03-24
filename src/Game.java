import java.util.Scanner;

public class Game {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        boolean playAgain;
        do {
            playGame(s);
            playAgain = gameOver(s);
        } while (playAgain);
        s.close();
    }

    public static void playGame(Scanner s) {
        // TODO: Write this method
    }

    public static boolean gameOver(Scanner s) {
        // TODO: Write this method
        return false;
    }
}