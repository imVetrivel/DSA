package LinkedList;
import java.util.*;
public class Singlly {

    class Node {
        int data;
        Node next;
        Node(int n)
        {
            data=n;
            next=null;
        }
    }
    public Node head=null;
    public Node tail=null;

    void add(int n)
    {
        Node temp=new Node(n);
        if(head==null)
        {
            head=temp;
            tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }

    // display
    public void display(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        // Scanner ab=new Scanner(System.in);
        // int a=
        Singlly s=new Singlly();
        s.add(10);
        s.add(20);
        s.add(30);
        s.display();
    }
}
