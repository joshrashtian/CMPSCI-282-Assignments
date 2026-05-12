package HashMap;

public class BST {
    Node root;
    public BST() {
        root = null;
    }

    public void insert(Student newStudent) {
        Node current = root;

        if(root == null) { root = new Node(newStudent); return; }
        while (true) {
            if (newStudent.id < current.data.id) {
                if (current.left == null) {
                    current.left = new Node(newStudent);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(newStudent);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

        public Student search(Student newStudent) {
            Node current = root;
            while (current != null) {
                if (newStudent.id == current.data.id) {
                    return current.data;
                } else if (newStudent.id < current.data.id) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return null; // not found
        }
    public void delete(Student newStudent) {
        root = deleteRec(root, newStudent.id);
    }

    private Node deleteRec(Node current, int id) {
        if (current == null) return null;

        if (id < current.data.id) {
            current.left = deleteRec(current.left, id);
        } else if (id > current.data.id) {
            current.right = deleteRec(current.right, id);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node successor = findMin(current.right);
            current.data = successor.data;

            current.right = deleteRec(current.right, successor.data.id);
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void print() {
       recursivePrint(root);
    }

    private void recursivePrint(Node node) {
        if (node == null) return;
        recursivePrint(node.left);
        System.out.print(node.data + " ");
        recursivePrint(node.right);
    }
}


