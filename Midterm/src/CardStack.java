import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card c) {
        if (c != null) {
            stack.addFirst(c); // top = first
        }
    }

    public Card pop() {
        if (isEmpty()) return null;
        return stack.removeFirst();
    }

    public Card peek() {
        if (isEmpty()) return null;
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
