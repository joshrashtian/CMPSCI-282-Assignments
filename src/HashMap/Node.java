/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMap;
/**
 *
 * @author juneja_u
 */
public class Node {
    Student data;
    Node left;
    Node right;

    public Node(Student data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Student ID: " + data.id + "\n" + "Student Name: " + data.name;
    }
}
