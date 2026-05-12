/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMap;

/**
 *
 * @author juneja_u
 */
public class Student {
    int id;
    String name;

    public Student(){
        id = 0;
        name = " ";
    }
    public Student(int id , String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return "id: " + id + " name:" +name;
    }
}
