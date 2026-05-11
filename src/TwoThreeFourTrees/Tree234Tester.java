package TwoThreeFourTrees;

public class Tree234Tester {
public static void main(String[] args) {
  TwoFourTree tree = new TwoFourTree();

  int[] values = {5, 10, 40, 20, 30, 50, 100, 135};
  for(int v : values) tree.insertNode(v);

  System.out.println("In Order Traversal:");
  tree.inOrderTraversal();
}
}
