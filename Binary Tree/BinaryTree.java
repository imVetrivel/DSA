import java.util.*;

public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int n) {
            data = n;
            left = null;
            right = null;
        }
    }

    Node root;

    public BinaryTree(int n) {
        root = new Node(n);
    }

    // insertion
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // inorder traversal
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public Node search(Node root, int n) {
        if (root == null || root.data == n) {
            return root;
        }
        if (n < root.data) {
            return search(root.left, n);
        } else {
            return search(root.right, n);
        }
    }

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        BinaryTree bst = new BinaryTree(10);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 50);
        bst.inorder(bst.root);

        if (bst.search(bst.root, 30) == null)
            System.out.println(" Not Found");
        else
            System.out.println("Found");
        ab.close();
    }
   
    // deletion
    public void delete(Node root,int n)
    {
        
    }
}