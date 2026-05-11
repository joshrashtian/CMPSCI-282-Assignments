package OrderedArray;

public class Main {
    public static void main(String args[]) {
      OrderedArray Array1 = new OrderedArray(10);
      OrderedArray Array2 = new OrderedArray(10);

     for( int i = 0; i < 10; i++ ) {
         Array1.insert((int)(Math.random() * 100));
     }

     for( int i = 0; i < 10; i++ ) {
         Array2.insert((int)(Math.random() * 100));
     }

     System.out.println("Original Arrays:");
     Array1.display();
     Array2.display();

     OrderedArray MergedArrays = Array1.merge(Array2);
     MergedArrays.display();
    }
}