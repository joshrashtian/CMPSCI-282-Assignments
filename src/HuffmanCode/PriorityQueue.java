package HuffmanCode;

/* From PriorityQ */

public class PriorityQueue {
    HuffmanNode[] arr;
    int front;

    public PriorityQueue(int size) {
        arr = new HuffmanNode[size];
        front = 0;
    }

    public boolean isEmpty() {
        return front == 0;
    }

    public boolean isFull() {
        return front == arr.length;
    }

    public HuffmanNode delete() {
        HuffmanNode temp = arr[front - 1];
        front--;
        return temp;
    }

    public HuffmanNode peek() {
        return arr[front - 1];
    }

    public void insert(HuffmanNode node) {
        if (isEmpty()) {
            arr[front] = node;
            front++;
        } else {
            int i;
            for (i = front - 1; i >= 0; i--) {
                if (node.data > arr[i].data)
                    arr[i + 1] = arr[i];
                else
                    break;
            }
            arr[i + 1] = node;
            front++;
        }
    }
}