import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardStack deck = new CardStack();
        CardStack discardPile = new CardStack();
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            deck.push(new Card("Card" + ((i - 1) % 10 + 1)));
        }

        System.out.println("Welcome — deck created with 30 cards.");
        System.out.println("Commands: draw x   |   discard x   |   get x   (where x = 1..5)");
        System.out.println("Type 'hand' to view hand, or 'quit' to exit early.\n");

        int round = 1;
        boolean quit = false;

        while (!deck.isEmpty() && !quit) {
            System.out.println("[ROUND " + round + "]");
            System.out.print("Enter command: ");
            String line = scanner.nextLine();
            if (line == null) line = "";
            String input = line.trim().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("No input. Try again.");
                continue;
            }
            if (input.equals("hand")) {
                displayHand(hand);
                System.out.println("Deck remaining: " + deck.size() + " | Discard pile: " + discardPile.size());
                continue;
            }
            if (input.equals("quit")) {
                System.out.println("[SYSTEM QUIT]");
                quit = true;
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Use: draw x | discard x | get x  (x = 1..5)");
                continue;
            }

            String command = parts[0];
            int x;
            try {
                x = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("x must be a number between 1 and 5.");
                continue;
            }

            if (x < 1 || x > 5) {
                System.out.println("x must be between 1 and 5.");
                continue;
            }

            switch (command) {
                case "draw":
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty. Cannot draw.");
                        break;
                    }
                    int actuallyDrawn = 0;
                    for (int i = 0; i < x; i++) {
                        Card card = deck.pop();
                        if (card == null) break;
                        hand.add(card);
                        actuallyDrawn++;
                    }
                    System.out.println("Drew " + actuallyDrawn + " card(s).");
                    break;

                case "discard":
                    if (hand.isEmpty()) {
                        System.out.println("Hand is empty. Nothing to discard.");
                        break;
                    }
                    int toDiscard = Math.min(x, hand.size());
                    for (int i = 0; i < toDiscard; i++) {
                        Card removed = hand.remove(hand.size() - 1);
                        discardPile.push(removed);
                    }
                    System.out.println("Discarded " + toDiscard + " card(s) to the discard pile.");
                    if (x > toDiscard) {
                        System.out.println("(You requested " + x + " but only had " + toDiscard + " card(s) in hand.)");
                    }
                    break;

                case "get":
                    if (discardPile.isEmpty()) {
                        System.out.println("Discard pile is empty. Nothing to get.");
                        break;
                    }
                    int actuallyGot = 0;
                    for (int i = 0; i < x; i++) {
                        Card card = discardPile.pop();
                        if (card == null) break;
                        hand.add(card);
                        actuallyGot++;
                    }
                    System.out.println("Took " + actuallyGot + " card(s) from discard pile into hand.");
                    break;

                default:
                    System.out.println("Unknown command. Use 'draw', 'discard', or 'get'.");
                    continue;
            }

            System.out.println("\n-- STATUS AFTER ROUND " + round + " --");
            displayHand(hand);
            System.out.println("Cards remaining in deck: " + deck.size());
            System.out.println("Cards in discard pile:" + discardPile.size() + "\n");

            round++;
        }

        if (deck.isEmpty()) {
            System.out.println("[GAME OVER]");
            System.out.println("The deck is empty. Final status:");
            displayHand(hand);
            System.out.println("Discard pile size: " + discardPile.size());
        }

        scanner.close();
    }


    private static void displayHand(ArrayList<Card> hand) {
        System.out.println("Current Hand (" + hand.size() + "):");
        if (hand.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + hand.get(i));
            }
        }
    }
}
