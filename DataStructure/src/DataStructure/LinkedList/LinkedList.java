package DataStructure.LinkedList;

import java.util.Scanner;

public class LinkedList {

     Node head; //Head Of LinkList
    /*Node Creation*/
    public static class Node{
        /*Inner Class to maintain Encapsulation*/
        int data;//To store Integer Data
        Node next; //To Store Next Node Data initially Null

        Node(int data)
        {
            this.data = data;
            this.next = null;//set to null
        }
    }
//Traversing Link list
    public void traverseList()
    {
        Node temp = head;
        if(temp == null)
        {
            System.out.println("List Is Empty!!");
        }

        else
        {
            while(temp!=null)
            {
                System.out.println("Node: "+ temp.data);
                temp = temp.next;
            }
        }
    }

    //Inserting Node At Beginning
    public void insertAtBeginning(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Inserting Node At End
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        Node temp = head;
        if(head==null)
        {
            insertAtBeginning(data);
        }
        else
        {
            newNode.next = null;
            while(temp.next!=null)
            {
                temp = temp.next;//moving till end of list
            }
            temp.next = newNode;
        }
    }

    //Insert After a given Data
    public void insertAfterData(int afterData,int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        if(temp==null)
        {
            System.out.println("No Element In The List!!");
        }
        else
        {   while((temp!=null)&&(temp.data!=afterData))
            {
                temp = temp.next;
            }
            if(temp==null)
            {
                System.out.println("Element Not Found In The List!!");
            }
            else
            {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    //delete the first occurence of data in the list
    public void deleteElement(int data)
    {
        Node deleteNode = head;
        Node temp = deleteNode;
        if(head == null)
        {
            System.out.println("List Is Empty");
        }
        else if((head.data == data) && (head.next==null))
        {
            head = null;
        }
        else if((head.data == data) && (head.next!=null))
        {
            head = head.next;
        }
        else
        {
            while((deleteNode!=null)&&(deleteNode.data!=data))
            {
                temp=deleteNode;
                deleteNode = deleteNode.next;
            }
            if(deleteNode==null)
            {
                System.out.println("No Element In the List");
            }
            else
            {
                temp.next = deleteNode.next;
            }
        }
    }

    public void traverseReverse(Node node)
    {
        if(node == null)
            return;
        traverseReverse(node.next);
        System.out.println( node.data+" ");
    }

    public int lengthLinkedList(Node node)
    {
        if(node == null)
            return 0;
        return (1+ lengthLinkedList(node.next));
    }

    /*Get Node*/
    public Node getNode(int data, Node node) {
        if (node.next.data == data)
            return node;
        else if (node == null)
            return null;
        else
            return getNode(data,node.next);
    }

    /*
    *
    */

    public static void main(String[] args ) {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        //Inserting At Beginning
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Element: ");
            ll.insertAtBeginning(sc.nextInt());
        }
        ll.traverseList();
        //Inserting At end
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Element: ");
            ll.insertAtEnd(sc.nextInt());
        }
        ll.traverseList();
        //Inserting After Data
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Location Data and Insert Data: ");
            ll.insertAfterData(sc.nextInt(), sc.nextInt());
        }
        ll.traverseList();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the Element To Be Deleted");
            ll.deleteElement(sc.nextInt());
        }
        ll.traverseList();

        System.out.println("Traverse Reverse");
        ll.traverseReverse(ll.head);

        System.out.println("length of list is: " + ll.lengthLinkedList(ll.head));

        System.out.println("Swapping Nodes Without swapping data");
        System.out.println("Enter 1st Node: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        ll.swapNodes(x,y);
        ll.traverseList();
    }

    public void swapNodes(int x, int y) {
     Node px,py,cx,cy;
     cx=head;
     cy=head;
     px=null;
     py=null;

     if(x==y)
     {
         return;
     }

     while(cx.data!=x)
     {
         px = cx;
         cx = cx.next;
     }

     if(cx==null)
     {
         System.out.println("No Element Name "+x);
         return ;
     }

     while(cy.data!=y)
     {
         py = cy;
         cy = cy.next;
     }
     if(cy==null)
     {
         System.out.println("No Element Name "+y);
         return ;
     }
     if(py==null)
     {
         head = cx;
     }
     else
        py.next = cx;
     if(px == null)
     {
         head = cy;
     }
     else
         px.next = cy;

     Node temp = cx.next;
     cx.next = cy.next;
     cy.next = temp;

    }
}
