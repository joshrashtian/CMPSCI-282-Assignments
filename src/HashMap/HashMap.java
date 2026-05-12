package HashMap;

/**
 *
 * @author juneja_u
 */
public class HashMap {
    BST[] table;

    public HashMap(int size){
        table = new BST[size];
        for(int i = 0; i < size; i++) {
            table[i] = new BST();
        }
    }
    public int hash(int id){
        return id%table.length;
    }
    public void insert(Student s){
        int index = hash(s.id);
        table[index].insert(s);
    }
    public void delete(Student s){
        int index = hash(s.id);
        table[index].delete(s);
    }
    public Student search(Student s){
        int index = hash(s.id);
        return table[index].search(s);
    }
    public void display(){
        for(int i = 0 ; i < table.length ; i++){
            if(table[i] != null)
                table[i].print();
        }
    }
}
