package TwoThreeFourTrees;

public class TFNode {
   int[] keys = new int[3];
   TFNode[] children = new TFNode[4];
   int keyCount = 0;

   boolean isLeaf = true; //when given children will flip to false

    boolean isFull() {
       return keyCount == 3;
   }


}
