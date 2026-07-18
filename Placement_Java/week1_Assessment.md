# Java Placements - Week 1 By makesh
## topics covered 
###    **Notes** Build a custom Made Linkedlist and Perform a operations
---
```java
      
public class CustomLinkedList {

    // ======================== NODE CLASS ========================
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ======================== HEAD POINTER ========================
    Node head;
`````
```
        1. Middel Number of the linked List (By totoriues algorithm)
`````java

     
    public int findMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        Node slow = head;  // Tortoise
        Node fast = head;  // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move 1 step
            fast = fast.next.next;    // Move 2 steps
        }
        return slow.data;
    }
````


        2. Remove the elemen the linkedList (front / last / position)
```java

        // Remove from Front
    public void removeFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Remove from Last
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Remove from Specific Position (1-based index)
    public void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            removeFront();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
    }
````
```
        3. Adding the Node elements in the LinkedList(front / last / position)
````java

    // Add at Front
    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at Specific Position (1-based index)
    public void addAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addFront(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
`````

        4. delete the elements in the LinkedList(front / last / position)
````java

    public void deleteFront() { removeFront(); }
    public void deleteLast() { removeLast(); }
    public void deleteAtPosition(int position) { removeAtPosition(position); }
````
        5. find the Min and Max in the linkedlist
````java

    public void findMinMax() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int min = head.data;
        int max = head.data;
        Node temp = head.next;

        while (temp != null) {
            if (temp.data < min) min = temp.data;
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }
````

        6. Merge the sorted two linkedlist 
````java

    public static CustomLinkedList mergeSortedLists(CustomLinkedList list1, CustomLinkedList list2) {
        CustomLinkedList merged = new CustomLinkedList();
        Node p1 = list1.head;
        Node p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                merged.addLast(p1.data);
                p1 = p1.next;
            } else {
                merged.addLast(p2.data);
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            merged.addLast(p1.data);
            p1 = p1.next;
        }
        while (p2 != null) {
            merged.addLast(p2.data);
            p2 = p2.next;
        }
        return merged;
    }
````
    
        7. printing a linkedlist elements
````java 

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

````
8. Reverse the linked list by using the Null Node 
```` java
  public void reverse(){
    Node prev=null;
    Node curr=head;
    Node nextNode=null;
    while(curr!=null)
    {
        nextNode=curr.next;
        curr.next=prev;
        prev=curr;
        curr=nextNode;
    }
    head=prev;
    }
````
