import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue queue = new ArrayQueue(10);

        int gameCount = 0;
        int playerCount = 1;
        int game = 1;

        while (gameCount < 10) {

            System.out.println("\nGAME " + game);
            System.out.println("-------------------------");
            System.out.println("Games completed: " + gameCount + "/10");
            System.out.println("Press ENTER to queue new players...");
            readInput.nextLine();
            game++;

            int playersToQueue = random.nextInt(7) + 1;
            System.out.println(playersToQueue + " players have joined the queue...");

            for (int i = 0; i < playersToQueue; i++) {
                Player player = new Player(playerCount, "Player #" + playerCount, random.nextInt(500) + 1);
                queue.add(player);

                System.out.println(player.getName() + " entered the queue.");
                playerCount++;
            }

            System.out.println("Queue size: " + queue.size());
            queue.printQueue();


            if (queue.size() >= 5) {
                System.out.println("\n[MATCH FOUND! Starting game...]");
                System.out.println("Removing 5 players from queue:");

                for (int i = 0; i < 5; i++) {
                    Player removed = queue.remove();
                    System.out.println(" - " + removed.getName());
                }

                gameCount++;
                System.out.println("GAME #" + gameCount + " STARTED!");
            }
            else {
                System.out.println("Not enough players to start a game...");
            }
        }

        System.out.println("\n10 games have been completed.");
        System.out.println("----------------------------");
        System.out.println("MATCHMAKING HAS ENDED.");
        readInput.close();
    }
}
