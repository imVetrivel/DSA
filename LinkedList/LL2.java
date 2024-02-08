import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LL2 {

    static Node head, tail; // by default initialized to null

    public static void add(int data) {
        Node temp = new Node(data);
        temp.next = null;

        if (head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    public static void insert(int value, int position) {
        Node new_node = new Node(value);
        if (position == 1) {
            new_node.next = head;
            head = new_node;
            display();
        }
        int count = 1;
        if (position > 0) {
            Node temp = head;
            int c = 0;
            while (temp.next != null) {
                count++;
                if (count == position) {
                    new_node.next = temp.next;
                    temp.next = new_node;
                    display();
                    return;
                }
                temp = temp.next;
            }
            if (count + 1 == position) {
                tail.next = new_node;
                tail = tail.next;
                display();
            }
            if (count + 1 < position) {
                System.out.print("Invalid position " + position);
            }
        }

    }

    // Method to print the LinkedList.
    public static void display() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val;
        LL2 list = new LL2();
        // add 4 nodes
        add(10);
        add(20);
        add(30);
        add(40);
        // insert at position
        int pos = sc.nextInt(); // position to insert
        val = sc.nextInt(); // value to insert
        insert(val, pos);

        // call this function only for valid positions...add logic for the same
        // display();
    }
}
