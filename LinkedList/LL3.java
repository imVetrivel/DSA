package LinkedList;

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

    static Node head, tail;

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

    public static Boolean delete(int val) {
        Node temp = head;
        Node prev = null;
        if (temp.data == val) {
            head = head.next;
            return true;
        }
        Node temp2 = head;
        while (temp != null && temp.data != val) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.print(val + " Not in List");
            return false;
        }
        prev.next = temp.next;

        return true;
    }

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
        int n = sc.nextInt();
        LL2 list = new LL2();
        for (int i = 0; i < n; i++) {
            // list.add(sc.nextInt());
            list.add(sc.nextInt());
        }
        int val = sc.nextInt();
        boolean b = delete(val);
        if (b) {
            display();
        }

    }
}
