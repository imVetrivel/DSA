package InterestingPrograms;

public class SinglyRotate {
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

	// rightRotate
	public void rightRotate()
	{
		Node temp = head;

		while(temp.next!=tail)
		{
			temp = temp.next;
		}

		temp.next = null;
		tail.next = head;
		head = tail;
		tail = temp;
	}

	public void print()
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args)
	{
		// Scanner ab = new Scanner(System.in);
		SinglyRotate s = new SinglyRotate();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		s.print();
		System.out.println();
		for(int i=0;i<2;i++)
		{
			s.rightRotate();
			s.print();
			System.out.println();
		}
		s.print();
		
	}
}
