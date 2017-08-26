public class loopFind {

    public static void main(String[] arg)
    {
        LinkedList ll = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node(10);
        LinkedList.Node n2 = new LinkedList.Node(11);
        LinkedList.Node n3 = new LinkedList.Node(12);
        LinkedList.Node n4 = new LinkedList.Node(13);
        LinkedList.Node n5 = new LinkedList.Node(14);
        LinkedList.Node n6 = new LinkedList.Node(15);

        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;
        n5.next = n6;
        ll.findLoop();
    }
}

class LinkedList{

    Node head;
    static class Node{
        int data;
        Node next;
        boolean visited;
        Node(int data)
        {
            this.data = data;
            this.visited = false;
            this.next = null;
        }
    }

    void findLoop()
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.visited == true)
            {
                System.out.println("Loop Present");
                break;
            }
            else {
                temp.visited = true;
            }
            temp = temp.next;
        }
        if(temp==null) {
            System.out.println("No Loops!!");
        }
    }
}
