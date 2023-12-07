import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of sides for the dice: ");
        int numSides = scanner.nextInt();


        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name for player " + (i + 1) + ": ");
            String playerName = scanner.next();

            Die playerDie = new Die(numSides);
            Player player = new Player(playerName, playerDie);

            players.add(player);
        }

        try {
            PrintStream fileStream = new PrintStream(new File("DiceGameOutput.txt"));
            System.setOut(fileStream);

            for (Player player : players) {
                player.getDie().roll();
                System.out.println(
                        "Player " + player.getName() +
                                " rolled a " + player.getDie().getValue() +
                                " on a " + numSides + "-sided die"
                );
            }

            int winnerIndex = decideWinner(players);
            System.out.println(players.get(winnerIndex).getName() + " won the game!");

            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static int decideWinner(List<Player> players) {
        int maxIndex = 0;
        int maxValue = players.get(0).getDie().getValue();

        for (int i = 1; i < players.size(); i++) {
            int currentValue = players.get(i).getDie().getValue();
            if (currentValue > maxValue) {
                maxIndex = i;
                maxValue = currentValue;
            }
        }

        return maxIndex;
    }
}

