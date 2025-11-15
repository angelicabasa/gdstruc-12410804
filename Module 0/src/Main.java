//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    //declare an array of int
        int[] numbers = new int[5];

        numbers[0] = 90;
        numbers[1] = 85;
        numbers[2] = -15;
        numbers[3] = 50;
        numbers[4] = 105;

       int index = -1;

       for (int i = 0; i < numbers.length; i++) {
           if (numbers[i] == 50)
           {
               index = i;
               break;
           }
       }
       System.out.println(index);
    }
}