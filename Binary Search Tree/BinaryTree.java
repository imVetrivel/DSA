import java.util.*;
public class BinaryTree {
    
    Node root;
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
     
    // level order
    public ArrayList<ArrayList<Integer>> levelorder(Node root){
        ArrayList<ArrayList<Integer>>m=new ArrayList<>();
        if (root == null)
       return m; 
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer>li=new ArrayList<>();
            int s=q.size();
            for(int i=0;i<s;i++){
                Node x=q.poll();
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
                li.add(x.data);
            }
            m.add(li);
            
        }
        return m;
       
    }

    //  preorder
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // postorder
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    //  search
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
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 40);
        // bst.insert(bst.root, 40);
        bst.insert(bst.root, 50);
       
        System.out.println("level order");
        System.out.println(bst.levelorder(bst.root));
        ab.close();
    }
   
    // deletion
    public Node delete(Node root,int n)
    {
        if(root.data==n){

            if(root.left==null && root.right==null)
            {
                return null;
            }
           else if(root.left==null && root.right!=null)
            {
                return root.right;
            }
           else if(root.left!=null && root.right==null)
            {
                return root.left;
            }
            else{
                Node temp=root.right;
                while(temp.left!=null)
                temp=temp.left;
                root.data=temp.data;
                root.right=delete(root.right, temp.data);
            }
        }
        if(n < root.data)
        root.left=delete(root.left,n);
        else
        root.right=delete(root.right,n);
        return root;
    }
}