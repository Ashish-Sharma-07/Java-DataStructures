package DataStructure.LinkedList.treeStructure;

class Node{
    int data;
    Node left;
    Node right;
    Node()
    {
        left = null;
        right = null;
    }

    Node(int data)
    {
        this();
        this.data = data;
    }
}

public class BinaryTree {

    Node root;
    BinaryTree()
    {
        root = new Node();
    }
    BinaryTree(int data)
    {
        root = new Node(data);
    }


}
