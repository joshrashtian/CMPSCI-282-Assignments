package DequeArray;

public class DequeArray<T> {
    private T[] arr;
    private int rear;
    private int size;
    private int capacity;

    DequeArray(int capacity) {

        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (arr.length == 0) return true;
        else return false;
    }
    public boolean isFull() {
        if (size == capacity) return true;
        else return false;
    }

    public void addFront(T newItem) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque is full");
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newItem;
        size++;
        rear++;
    }

    public void addRear(T newItem) {
        if(isFull()) throw new IndexOutOfBoundsException();
        rear++; arr[rear] = newItem; size++;
    }

    public T removeFront() {
       if(isEmpty()) throw new IndexOutOfBoundsException();
       T item = arr[0];
       for(int i = 0; i <= rear; i++) arr[i] = arr[i + 1];
       rear--;
       size--;
       return arr[0];
    }

    public T removeRear() {
        if(rear == 0) throw new IndexOutOfBoundsException();
        T newItem = arr[rear];
        arr[rear] = null;
        rear --;
        size--;
        return newItem;
    }

    public T getFront() {
        if(rear == 0) throw new IndexOutOfBoundsException();
        return arr[0];
    }

    public T getRear() {
        if(rear == 0) throw new IndexOutOfBoundsException();
        return arr[rear];
    }

    @Override
    public String toString() {
        String message = "";
        for(int i = 0; i < size; i++) {
            message += arr[i] + " ";
        }
     return message;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        this.arr = (T[]) new Object[capacity];
    }

    public void rotate(int k) {
       int changesNumber = k;
       while(changesNumber != 0) {
           if(changesNumber < 0)
           {
               T arrayEnd = arr[size - 1];
               for(int i = 0; i < size - 1; i++) {
                   arr[i] = arr[i + 1];
               }
               arr[size - 1] = arrayEnd;
               changesNumber++;
           }
           else
           {
               T arrayFront = arr[size - 1];
               for (int i = size - 1; i > 0; i--) {
                   arr[i] = arr[i - 1];
               }
               arr[0] = arrayFront;
               changesNumber--;
           }

       }
    }

    public T peak(int n) {
        return arr[n];
    }
}
