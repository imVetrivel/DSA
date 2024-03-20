package InterestingPrograms;

public class SinglyReverse {

	 class Node{
		int n;
		Node next;
		Node(int n)
		{
			this.n = n;
			this.next = null;
		}
	}
	public Node head = null;
	public Node tail = null;

	public void add(int n)
	{
		Node newNode = new Node(n);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void printReverse(Node temp)
	{
		if(temp == null)
		{
			return;
		}
			printReverse(temp.next);
			System.out.print(temp.n+" ");
	}

	public void swapReverse()
	{
		Node prev = null;
        Node current = head;
        Node next = null;
		tail = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
		
	}

	public void print()
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.n+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args)
	{
		// Scanner ab = new Scanner(System.in);
		SinglyReverse s = new SinglyReverse();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		s.print();
		System.out.println();
		s.swapReverse();
		s.print();
		System.out.println();
		s.printReverse(s.head);
	}
	
}
