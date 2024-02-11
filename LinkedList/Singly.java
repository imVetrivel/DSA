package LinkedList;

public class Singly {

    class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    // insertion at first
    public void addfirst(int n) {
        Node temp = new Node(n);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    // insertion at middle
    public void addmid(int n, int pos) {
        Node newnode = new Node(n);
        Node prev = head;
        Node current = head;
        int count = 0;
        while (current != null && count <= pos - 1) {
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = newnode;
        newnode.next = current;
    }

    // insertion at last
    void add(int n) {
        Node temp = new Node(n);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    // deleteFirst Node
    public void deletefirst() {
        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    // deleteMiddle Node
    public void deletemid(int pos) {
        Node prev = head;
        Node current = head;
        int count = 0;
        while (current != null && count <= pos - 1) {
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = current.next;
        current.next = null;
    }

    // deleteLast Node
    public void deletelast() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Singly s = new Singly();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(50);
        s.add(60);
        s.addmid(40, 3);
        s.display();
        s.deletemid(3);
        s.display();
    }
}
