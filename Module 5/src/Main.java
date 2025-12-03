//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Player ploo = new Player (134, "Plooful", 135);
    Player wardell = new Player (536, "TSM Wardell", 640);
    Player deadlyJimmy = new Player (32, "DeadlyJimmy", 34);
    Player subroza = new Player (4931, "Subroza", 604);
    Player annieDro = new Player (6919, "C9 Annie", 593);

    SimpleHashTable hashtable = new  SimpleHashTable();
    hashtable.put(ploo.getUserName(), ploo);
    hashtable.put(wardell.getUserName(), wardell);
    hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
    hashtable.put(subroza.getUserName(), subroza);
    hashtable.put(annieDro.getUserName(), annieDro);

    hashtable.printHashtable();
    System.out.println("\n--------------------------");
    System.out.println("\nREMOVE PLAYER: SUBROZA");
    hashtable.remove(subroza.getUserName());
    System.out.println("\nHashtable after removing: ");
    hashtable.printHashtable();

       // the key is the player's username
//        System.out.println(hashtable.get("Subroza"));
    }
}