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

    public static void main(String[] args )
    {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        //Inserting At Beginning
        for(int i = 0;i<3;i++){
            System.out.println("Enter Element: ");
            ll.insertAtBeginning(sc.nextInt());}
        ll.traverseList();
        //Inserting At end
        for(int i = 0;i<3;i++){
            System.out.println("Enter Element: ");
            ll.insertAtEnd(sc.nextInt());}
        ll.traverseList();
        //Inserting After Data
        for(int i = 0;i<3;i++)
        {
            System.out.println("Enter Location Data and Insert Data: ");
            ll.insertAfterData(sc.nextInt(),sc.nextInt());
        }
        ll.traverseList();
    }
}
