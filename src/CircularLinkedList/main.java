package CircularLinkedList;

public class main {
    public static void main(String[] args) {
    Node head = new Node(1);
    CircularSinglyList list = new CircularSinglyList(head);

    list.append(new Node(3));
    list.append(new Node(5));
    list.removeNext();

    list.step();
    list.search(5);
    list.display();

    }
}
