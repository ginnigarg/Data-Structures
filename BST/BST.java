public class BST {

    Node root;

    BST(int data) {
        root = new Node(data);
    }

    Node search(Node root, int data) {
        if(root == null || root.data == data) {
            return root;
        } else if(root.data > data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    Node insert(Node root, int data) {
        if(root == null) {
            Node node = new Node(data);
            return node;
        }

        if(root.data > data) {
            root.left = insert(root.left, data);
        } else if(root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    int maximum(Node root) {
        if(root.right == null) {
            return root.data;
        }
        return maximum(root.right);
    }

    Node deleteNode(Node root, int data) {
        if(root.data == data) {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int maximumElement = maximum(root.left);
                root.data = maximumElement;
                deleteNode(root.left, maximumElement);
                return root;
            } 
        }
        if(root.data > data) {
            root.left = deleteNode(root.left, data);
        } else {
            root.right = deleteNode(root.right, data);
        }
        return root;
    }

    boolean isValidBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.data <= min || root.data >= max) {
            return false;
        }
        if(isValidBST(root.left, min, root.data)) {
            return isValidBST(root.right, root.data, max);
        }
        return false;
    }

    Node leastCommonAncestor(Node root, int first, int second) {
        if(root == null) {
            return null;
        }
        if(root.data == first || root.data == second) {
            return root;
        }
        Node left = leastCommomAncestor(root.left, first, second);
        Node right = leastCommonAncestor(root.right, first, second);
        if(left != null && right != null) return root;
        if(left != null) return left;
        else if(right != null) return right;
    }

    public static void main(String args[]) {
        BST tree = new BST(10);
        for(int i = 9; i > 0; i--) {
            tree.root = tree.insert(tree.root, i);
            tree.root = tree.insert(tree.root, i + 10);
        }
        for(int i = 0; i < 20; i++) {
            if(tree.search(tree.root, i) == null) {
                System.out.println(i + " not found");
            } else {
                System.out.println(i + " " + tree.search(tree.root, i).data);
            }
        }
        tree.deleteNode(tree.root, 10);
        for(int i = 0; i < 20; i++) {
            if(tree.search(tree.root, i) == null) {
                System.out.println(i + " not found");
            } else {
                System.out.println(i + " " + tree.search(tree.root, i).data);
            }
        }
        System.out.println("Is Valid BST : " + (tree.isValidBST(tree.root, INT_MIN, INT_MAX) ? "true" : "false"));
    }
}

class Node {
    int data;
    Node right;
    Node left;
    
    Node() {
        this.data = -99999;
        right = null;
        left = null;
    }

    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }

}
