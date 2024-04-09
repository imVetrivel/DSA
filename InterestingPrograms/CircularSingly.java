package InterestingPrograms;

public class CircularSingly {
	public Node head;
	public int size = 0;
    
	class Node{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}

	public void addNode(int n)
	{
		Node newNode = new Node(n);
		size++;
		if(head == null)
		{
		   head = newNode;
		   head.next = head;
		}
		else
		{
			Node temp = head;

			while(temp.next != head)
				temp = temp.next;

			temp.next = newNode;
			newNode.next = head;
		}
	}

	// to find the middle element
	public void FindMid()
	{
		if(head == null)
		return;

		Node fast = head;
		Node slow = head;

		if(size%2 == 0)
		{
		System.out.println("No Middle Element Found");
		return;
		}

		while(fast.next!=head)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.print(slow.data);
	}

	public void print()
	{
		if(head == null)
		return;

		Node temp = null;
		if(head.next != null)
		 temp = head.next;

		System.out.print(head.data+" ");

		while(temp!=head)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args)
	{
		CircularSingly c = new CircularSingly();

		c.addNode(1);
		c.addNode(2);
		c.addNode(3);
		c.addNode(4);
		c.addNode(5);
		c.addNode(6);
		c.addNode(7);

		c.print();
		System.out.println();
		c.FindMid();
	}
}
