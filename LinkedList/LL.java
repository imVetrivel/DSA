package LinkedList;

import java.util.*;

public class LL {
    Node root;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void add(int num) {
        Node new_node = new Node(num);
        if (root == null) {
            root = new_node;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public void display() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var list = new LL();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        list.display();

    }
}