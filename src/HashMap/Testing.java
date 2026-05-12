package HashMap;

public class Testing {
    public static void main(String[] args) {
        Student joshua = new Student();
        joshua.name = "Josh";
        joshua.id = 3;

       HashMap Map = new HashMap(1);

       Map.insert(joshua);
      Map.display();

      System.out.println();

      Student tanzim = new Student();
      tanzim.name = "Tanzim";
      tanzim.id = 2;

      Map.insert(tanzim);
      Map.display();

      System.out.println();
      Student GettingBackOurTanzims = Map.search(tanzim);
      System.out.println(GettingBackOurTanzims.name);

      Map.delete(joshua);

      Map.display();
    }
}
