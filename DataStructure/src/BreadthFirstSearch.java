import java.util.Stack;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(30);
        TreeNode n3 = new TreeNode(40);
        TreeNode n4 = new TreeNode(50);
        TreeNode n5 = new TreeNode(60);
        TreeNode n6 = new TreeNode(70);
        TreeNode n7 = new TreeNode(80);
        TreeNode n8 = new TreeNode(90);
        TreeNode n9 = new TreeNode(100);
        TreeNode n10 = new TreeNode(110);
        TreeNode n11 = new TreeNode(120);
        TreeNode n12 = new TreeNode(130);
        TreeNode n13 = new TreeNode(140);
        TreeNode n14 = new TreeNode(150);
        TreeNode n15 = new TreeNode(160);
        TreeNode n16 = new TreeNode(170);
        TreeNode n17 = new TreeNode(180);
        TreeNode n18 = new TreeNode(190);


        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        n2.setRight(n6);
        n3.setLeft(n7);
        n3.setRight(n8);
        n4.setLeft(n9);
        n4.setRight(n10);
        n5.setLeft(n11);
        n5.setRight(n12);
        n6.setLeft(n13);
        n6.setRight(n14);
        n7.setLeft(n15);
        n7.setRight(n16);
        n8.setLeft(n17);
        n8.setRight(n18);

        System.out.println("Breadth First Search: ");

        QueueClass queue = new QueueClass();
        TreeNode node = root;

        while(node!=null)
        {
            System.out.print(node.getData()+"\t");

            TreeNode temp1,temp2;
            temp1 = node.getLeft();
            temp2 = node.getRight();
            if(temp1!=null)
                queue.push(temp1);
            if(temp2!=null)
                queue.push(temp2);

            node = queue.pop();
        }

        System.out.println("\n Depth First Search: ");

        StackClass st= new StackClass();
        node = root;
        while(node!=null)
        {
            System.out.print(node.getData()+"\t");

            TreeNode temp1,temp2;
            temp1 = node.getLeft();
            temp2 = node.getRight();
            if(temp2!=null)
                st.push(temp2);
            if(temp1!=null)
                st.push(temp1);

            node = st.pop();
        }
    }

}

class QueueClass {

    class Queuer {
    private TreeNode node;
    private Queuer next;

        public Queuer(TreeNode node) {
            this.node = node;
            this.next = null;
        }
    }

    Queuer head;
    Queuer tail;

    void push(TreeNode node)
    {
        if(head == null)
        {
            head = new Queuer(node);
            tail = head;
        }
        else
        {
            tail.next = new Queuer(node);
            tail = tail.next;
        }
    }

    TreeNode pop()
    {

        TreeNode ret = null;
        if(head == null)
            return ret;
        else {
            ret = head.node;
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            return ret;
        }
    }
}

class StackClass {

    class Stack {
        private TreeNode node;
        private Stack next;

        public Stack(TreeNode node) {
            this.node = node;
            this.next = null;
        }
    }

    Stack head;

    void push(TreeNode node)
    {
        if(head == null)
        {
            head = new Stack(node);
        }
        else
        {
            Stack st = new Stack(node);
            st.next = head;
            head = st;
        }
    }

    TreeNode pop()
    {

        TreeNode ret = null;
        if(head == null)
            return ret;
        else {
            ret = head.node;
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
            return ret;
        }
    }
}


class TreeNode
{
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
