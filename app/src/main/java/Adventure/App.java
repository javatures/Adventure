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
        Dungeon dungeon = new Dungeon(s);
        dungeon.play();
    }

    public static boolean gameOver(Scanner s) {
        String input;
        System.out.println("Game over! Would you like to play again? (y/n)");
        input = s.nextLine().toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.println("Invalid response. Would you like to play again? (y/n)");
            input = s.nextLine().toLowerCase();
        }
        return (input.equals("y"));
    }
}