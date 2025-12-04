//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(18);
        tree.insert(26);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.println("MAX DATA: " + tree.getMax());
        System.out.println("MIN DATA: " + tree.getMin());

        System.out.println("\nTree Ascending Order:");
        tree.traverseInOrder();

        System.out.println("\nTree Descending Order:");
        tree.traverseInOrderDescending();
    }
}