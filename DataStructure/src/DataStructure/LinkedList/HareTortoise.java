package DataStructure.LinkedList;
import DataStructure.LinkedList.LinkedList;
public class HareTortoise {
  public static void main(String[] arg)
  {
      LinkedList ll = new LinkedList();
      LinkedList.Node n1 = new LinkedList.Node(1);
      ll.head = n1;
      LinkedList.Node n2 = new LinkedList.Node(2);
      LinkedList.Node n3 = new LinkedList.Node(3);
      LinkedList.Node n4 = new LinkedList.Node(4);
      LinkedList.Node n5 = new LinkedList.Node(5);
      LinkedList.Node n6 = new LinkedList.Node(6);
      LinkedList.Node n7 = new LinkedList.Node(7);
      LinkedList.Node n8 = new LinkedList.Node(8);
      LinkedList.Node n9 = new LinkedList.Node(9);
      LinkedList.Node n10 = new LinkedList.Node(10);
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      n5.next = n6;
      n6.next = n7;
      n7.next = n8;
      n8.next = n9;
      n9.next = n10;
      n10.next = n4;
      new HareTortoise().foydCycle(n1);
  }

  public void foydCycle(LinkedList.Node node)
  {
      LinkedList.Node hare = node;
      LinkedList.Node tortoise = node;

      while(hare!=null)
      {
          hare = hare.next.next;
          tortoise = tortoise.next;
          if(hare == tortoise)
          {
              System.out.println("Loop Found");
              int startLen = startlength(node,hare,tortoise);
              System.out.println("total length: "+startLen);
              break;
          }
      }
      if(hare == null)
      {
          System.out.println("No Loops!!");
      }
  }

  public int startlength(LinkedList.Node head,LinkedList.Node hare,LinkedList.Node tortoise)
  {
      int s =0;
      hare = head;
      while(hare!=tortoise)
      {
          hare = hare.next;
          tortoise = tortoise.next;
          s++;
      }

      int loopSize = 1;
      hare = hare.next;
      while(hare!=tortoise)
      {
          hare = hare.next;
          loopSize++;
      }
      return s+loopSize;
  }
}

