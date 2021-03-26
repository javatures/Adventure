import java.util.Scanner;

public class App {
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
        String input;
        do {
            System.out.println("Game over! Would you like to play again? (y/n)");
            input = s.next().toLowerCase();
        } while (!input.equals("y") && !input.equals("n"));
        return (input.equals("y"));
    }
}