
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

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        n2.setRight(n6);
        n3.setLeft(n7);
        n3.setRight(n8);
        n4.setLeft(n9);

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
