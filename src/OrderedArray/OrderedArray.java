package OrderedArray;

/**
 *
 * @author juneja_u
 * @author joshua_rashtian
 */
public class OrderedArray {
    private int[] list;
    private int numOfItems;//to keep track of how many items

    public OrderedArray(int size){
        list = new int[size];
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }
    public boolean isFull(){
        return numOfItems == list.length;
    }
    public void insert(int item){
        if (isFull()) {
            System.out.println("Error: cannot insert, full array");
            return;
        }

        int i;

        for (i = numOfItems - 1; i >= 0 && list[i] > item; i--) {
            list[i + 1] = list[i];
        }


        list[i + 1] = item;
        numOfItems++;

    }
    public int search(int item){
        int low = 0;
        int high = numOfItems-1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(item == list[mid])
                return mid; // found
            else if(item < list[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1; // not found
    }
    public int delete(int item){
        int index = search(item);
        int temp;
        if(index == -1){
            System.out.println("Error: cannot delete");
            return -1;
        }
        else{
            temp = list[index];
            for(int i = index ; i < numOfItems -1 ; i++){
                list[i] = list[i + 1];
            }
        }
        numOfItems--;
        return temp;
    }
    public void display(){
        for(int i = 0 ; i < numOfItems ; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    public OrderedArray merge(OrderedArray originalArray) {
     OrderedArray mergedArray = new OrderedArray(this.numOfItems + originalArray.numOfItems);

    int i = 0;
    int j = 0;

    while(i < numOfItems && j < originalArray.numOfItems){

        if(list[i] < originalArray.list[j]){
            if(mergedArray.search(list[i]) == -1 ) {
                mergedArray.insert(this.list[i]);
            }
            i++;
        }

        else if(list[i] > originalArray.list[j]){
            if(mergedArray.search(originalArray.list[j]) == -1 ) {
                mergedArray.insert(originalArray.list[j]);
            }
            j++;
        }

        else {
            if(mergedArray.search(this.list[i]) == -1 ) {
                mergedArray.insert(this.list[i]);
            }
            i++;
            j++;
        }
    }

        while (i < this.numOfItems)
        {
            mergedArray.insert(this.list[i]);
            i++;
        }
        while (j < originalArray.numOfItems)
        {
            mergedArray.insert(originalArray.list[j]);
            j++;
        }
    return mergedArray;
    }
}
