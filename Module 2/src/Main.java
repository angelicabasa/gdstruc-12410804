import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskjet = new Player(3, "HPDeskjet", 34);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);

        playerLinkedList.printList();
        System.out.println("Size of List: " + playerLinkedList.getSize());

        System.out.println("\nContains lethalBacon? " + playerLinkedList.contains(lethalBacon));

        System.out.println("Index of LethalBacon: " + playerLinkedList.indexOf(lethalBacon));

        System.out.println("\nRemoved Player from front: " + playerLinkedList.removeFromFront());
        playerLinkedList.printList();
        System.out.println("Size of List: " + playerLinkedList.getSize());

//    List<Player> playerList = new ArrayList<Player>();

//        playerList.add(new Player(1, "Asuna", 100));
//        playerList.add(new Player(2, "LethalBacon", 205));
//        playerList.add(new Player(3, "HPDeskjet", 34));



//        // get function code
//        System.out.println(playerList.get(1)); // this will print out the 3rd player
//
//        // to insert element
//        playerList.add(2, new Player(553, "Arctis", 55));
//
//        // remove an element
//        playerList.remove(2);
//
//        System.out.println(playerList.contains(new Player(2, "LethalBacon", 205)));
//
//        System.out.println(playerList.indexOf(new Player(2, "LethalBacon", 205)));
//
//        for (Player p : playerList)
//        {
//            System.out.println(p);
//        }

    }
}