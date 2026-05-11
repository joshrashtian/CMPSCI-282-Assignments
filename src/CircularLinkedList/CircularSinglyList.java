package CircularLinkedList;

public class CircularSinglyList {
    private Node last;
    private Node current;
    public CircularSinglyList(Node newNode) {
        if (newNode == null) {
            this.last = null;
            return;
        }
        this.last = newNode;
        this.last.next = last;
        this.current = last;
    }
    public void append(Node newNode) {
        if(last == null) {
            last = newNode;
            last.next = last;
            current = last;
            return;
        }
        newNode.next = last.next;
        last.next =  newNode;
        last = newNode;

    }

    public Node search(int val) {
        if(last==null) return null;
        Node temp = current;
        do {
            if(temp.data == val) {
                return temp;
            }
            else temp = temp.next;
        } while (temp != current);
        return null;
    }

    public void display() {
        if(last == null) {
            System.out.println("List is Empty");
            return;
        }
        Node curr = last.next;
        do{
            System.out.print(curr.data+" -> ");
            curr = curr.next;
        } while (curr != last.next);
        System.out.print("(Head)");
    }
    public void removeNext() {
      if(last == null) return;
      if(current.next == current) {
          last = null;
          current = null;
          return;
      }
          Node toDel = current.next;
      current.next = toDel.next;
      if(toDel == last) {
          last = current;
      }
    }

    public void step()
    {
        if(current!=null) {
            current = current.next;
        }
    }
}
