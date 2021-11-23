package A03;

public class BST {

    public class Node {
       
        public String data;
        public Node left;
        public Node right;

       
        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    
    public Node root;

    
    public BST() {
        this.root = null;
    }

   
    public void insert(String newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root,String newData) {
        
        if (root == null) {
            // Insert the new data, if root is null.
            root = new Node(newData);
           
            return root;
        }
        
        else if (root.data.compareTo(newData) >=0) {
           
            root.left = insert(root.left, newData);
        } else {
            
            root.right = insert(root.right, newData);
        }
        return root;
    }

   
    public boolean search(String data) {
        return search(this.root, data);
    }

    private boolean search(Node root,String data) {
        if (root == null) {
            return false;
        } else if (root.data.compareTo(data)==0) {
            return true;
        } else if (root.data.compareTo(data)>0) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    //Traversal
    public void Inorder() {
        Inorder(root);
        System.out.println();
    }

    public void Inorder(Node root) {
        if (root == null) {
            return;
        }
       Inorder(root.left);
        System.out.print(root.data + " ");
       
        Inorder(root.right);
    }

    public static void main(String[] args) {
       
        BST bst = new BST();
       
        bst.insert("c");
        bst.insert("b");
        bst.insert("a");
        bst.insert("aa");
      
        bst.Inorder();
        System.out.println(bst.search("r"));
        
    }
}