import java.util.*;
import java.io.*;

public class InOrder {
  

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    tree.insert(8);
    tree.insert(9);
    postOrderTraversal(tree.root);
   }





}

class BinaryTree {
  Node root;

  BinaryTree() {
    root = null;
  }

  BinaryTree(int data) {
    Node node =  new Node(data);
    root = node;
  }

  void insert(int data) {
    Queue<Node> queue = new LinkedList<>();
    Node node = new Node(data);
    if(root == null) {
      root = node;
      return;
    }
    queue.add(root);
    while(queue.size() != 0) {
      if(queue.peek().left == null) {
        queue.peek().left = node;
        return;
      } else if(queue.peek().right == null) {
        queue.peek().right = node;
        return;
      } else {
        queue.add(queue.peek().left);
        queue.add(queue.peek().right);
        queue.remove();
      }
    }
  }

}


class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = right = null;
  }

  Node() {
    this.data = 0;
    left = right = null;
  }
}


