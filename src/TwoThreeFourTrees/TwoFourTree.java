package TwoThreeFourTrees;

public class TwoFourTree {
    TFNode root;

    public TwoFourTree() {
        root = new TFNode();

    }

    public void insertNode(int data) {
        if(root.isFull()) {
            TFNode newRoot = new TFNode();
            newRoot.children[0] = root;
            newRoot.isLeaf = false;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, data);
    }

    private void insertNonFull(TFNode root, int data) {
        int i = root.keyCount - 1;
        if (root.isLeaf) {
            while (i >= 0 && data < root.keys[i]) {
                root.keys[i + 1] = root.keys[i];
                i--;
            }
            root.keys[i + 1] = data;
            root.keyCount++;
        } else
        {
            while (i >= 0 && data < root.keys[i]) i--;
            i++;
            if(root.children[i].isFull()) {
                splitChild(root, i);
                if(data > root.keys[i]) i++;
            }
            insertNonFull(root.children[i], data);
        }
    }

    public void inOrderTraversal() {
         inOrderTraversal(root);
         System.out.println();
    }
    private void inOrderTraversal(TFNode node) {
        if (node == null) return;
        for (int i = 0; i < node.keyCount; i++) {
            if (!node.isLeaf) inOrderTraversal(node.children[i]);
            System.out.print(node.keys[i] + " ");
        }
        if (!node.isLeaf) inOrderTraversal(node.children[node.keyCount]);

    }
    private void splitChild(TFNode root, int level) {
        TFNode fullChild = root.children[level];
        TFNode newChild  = new TFNode();

        int middle = fullChild.keys[1];

        // the new right child will get upper key (index 2)
        newChild.keys[0] = fullChild.keys[2];
        newChild.keyCount = 1;
        newChild.isLeaf = fullChild.isLeaf;

        if(!fullChild.isLeaf) {
            newChild.children[0] = fullChild.children[2];
            newChild.children[1] = fullChild.children[3];
            fullChild.children[2] = null;
            fullChild.children[3] = null;
        }

        fullChild.keyCount = 1;
        fullChild.keys[1] = 0;
        fullChild.keys[2] = 0;

        for(int i = root.keyCount; i > level; i--) {
            root.keys[i] = root.keys[i - 1];
            root.children[i + 1] = root.children[i];
        }

        root.keys[level] = middle;
        root.children[level + 1] = newChild;
        root.keyCount++;
        root.isLeaf = false;
    }
}
