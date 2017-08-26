package DataStructure.LinkedList;

public class loopFind {

    public static void main(String[] arg)
    {
        NewLinkedList ll = new NewLinkedList();
        NewLinkedList.Node n1 = new NewLinkedList.Node(10);
        NewLinkedList.Node n2 = new NewLinkedList.Node(11);
        NewLinkedList.Node n3 = new NewLinkedList.Node(12);
        NewLinkedList.Node n4 = new NewLinkedList.Node(13);
        NewLinkedList.Node n5 = new NewLinkedList.Node(14);
        NewLinkedList.Node n6 = new NewLinkedList.Node(15);

        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;
        n5.next = n6;
        ll.findLoop();
    }
}

class NewLinkedList{

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
