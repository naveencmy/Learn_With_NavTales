
// ============================================================
// Custom LinkedList Implementation - Java Placements Week 1
// By Makesh - All 7 Topics Covered
// ============================================================

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

    // ============================================================
    // TOPIC 3: ADDING NODES (FRONT / LAST / POSITION)
    // ============================================================

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

    // ============================================================
    // TOPIC 2: REMOVE ELEMENTS (FRONT / LAST / POSITION)
    // ============================================================

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

    // ============================================================
    // TOPIC 4: DELETE ELEMENTS (FRONT / LAST / POSITION)
    // Same as Remove - included for completeness
    // ============================================================

    public void deleteFront() { removeFront(); }
    public void deleteLast() { removeLast(); }
    public void deleteAtPosition(int position) { removeAtPosition(position); }

    // ============================================================
    // TOPIC 1: FIND MIDDLE NUMBER (Tortoise & Hare Algorithm)
    // ============================================================

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

    // ============================================================
    // TOPIC 5: FIND MIN AND MAX
    // ============================================================

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

    // ============================================================
    // TOPIC 6: MERGE TWO SORTED LINKED LISTS
    // ============================================================

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

    // ============================================================
    // TOPIC 7: PRINT LINKED LIST
    // ============================================================

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
    //=============================================================
    // Reverse the LinkedList By using the Null Noode
    //=============================================================
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

    // ============================================================
    // MAIN METHOD - DEMONSTRATION
    // ============================================================

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  CUSTOM LINKED LIST - ALL OPERATIONS  ");
        System.out.println("========================================\n");

        CustomLinkedList list = new CustomLinkedList();

        // ---- ADDING ELEMENTS ----
        System.out.println("--- ADDING ELEMENTS ---");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFront(5);
        list.addAtPosition(15, 3);
        System.out.print("List after adding: ");
        list.printList();

        // ---- FIND MIDDLE ----
        System.out.println("\n--- FIND MIDDLE (Tortoise & Hare) ---");
        System.out.println("Middle element: " + list.findMiddle());

        // ---- MIN AND MAX ----
        System.out.println("\n--- FIND MIN & MAX ---");
        list.findMinMax();

        // ---- REMOVE ELEMENTS ----
        System.out.println("\n--- REMOVING ELEMENTS ---");
        list.removeFront();
        System.out.print("After removeFront(): ");
        list.printList();

        list.removeLast();
        System.out.print("After removeLast(): ");
        list.printList();

        list.removeAtPosition(2);
        System.out.print("After removeAtPosition(2): ");
        list.printList();

        // ---- MERGE TWO SORTED LISTS ----
        System.out.println("\n--- MERGE TWO SORTED LISTS ---");
        CustomLinkedList listA = new CustomLinkedList();
        listA.addLast(1);
        listA.addLast(3);
        listA.addLast(5);
        listA.addLast(7);

        CustomLinkedList listB = new CustomLinkedList();
        listB.addLast(2);
        listB.addLast(4);
        listB.addLast(6);
        listB.addLast(8);

        System.out.print("List A: ");
        listA.printList();
        System.out.print("List B: ");
        listB.printList();

        CustomLinkedList merged = mergeSortedLists(listA, listB);
        System.out.print("Merged List: ");
        merged.printList();

        System.out.print("----Reverse the Linked List:----\n");
        System.out.print("Revresed List: ");
        merged.reverse();
        merged.printList();

        System.out.println("\n========================================");
        System.out.println("       ALL OPERATIONS COMPLETED!        ");
        System.out.println("========================================");
    }
}
