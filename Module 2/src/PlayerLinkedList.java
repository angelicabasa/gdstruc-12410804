public class PlayerLinkedList {

    private PlayerNode head;
    private int size;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    public Player removeFromFront()
    {
        if (head == null)
            return null;
        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayer();
        size--;
        return removedPlayer;
    }

    public void printList()
    {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) // this checks if the current node is not null
        {
            System.out.println(current);
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public boolean contains(Player player)
    {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return true;
            }
            current = current.getNextPlayer();
        }
    return false;
    }

public int indexOf(Player player) {
    PlayerNode current = head;
    int index = 0;

    while (current != null) {
        if (current.getPlayer().equals(player)) {
            return index;
        }
        current = current.getNextPlayer();
        index++;
    }
    return -1;
}

}
