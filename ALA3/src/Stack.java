/**
 * Program name: ALA3
 * Uses classes and a stack
 *
 * @author Logan Kramer
 * Date: 2/6/20
 * @version 1.0
 */
public class Stack {
    private String[] elements;
    private int size;
    private int capacity;
    Stack(){
        elements = new String[20];
    }
    Stack(int cap){
        elements = new String[cap];
    }
    public boolean empty(){
        //if size is zero, return true, else return false
        return size == 0;
    }
    public String top(){
        return elements[size - 1];
    }
    public void push(String element){
        //add value and increment size
        elements[size] = element;
        size++;
    }
    public String pop(){
        //decrement size and return value
        return elements[--size];
    }
    public int size(){
        return size;
    }

}
