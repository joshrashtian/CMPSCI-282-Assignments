package DequeArray;

import java.util.ArrayDeque;

public class main {
    public static void main(String[] args) {
        DequeArray<Integer> Array = new DequeArray<Integer>(4);
        Array.addFront(4);
        Array.addFront(5);
        Array.addRear(3);


        System.out.println(Array.toString());
    }
}
