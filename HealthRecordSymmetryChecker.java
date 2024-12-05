
class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList {

    Node head;

    // Append a new node to the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display the list (for debugging purposes)
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class HealthRecordSymmetryChecker {

    // Helper function to reverse a list and return the new head
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Function to check if the list is symmetric
    public static boolean isHealthRecordSymmetric(Node head) {
        if (head == null || head.next == null) {
            return true; // Empty or single-node list is symmetric
        }

        // Step 1: Find the middle of the list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalfStart = reverseList(slow);

        // Step 3: Compare the first and second halves
        Node firstHalfStart = head;
        Node secondHalfCopy = secondHalfStart; // To restore later if needed
        boolean isSymmetric = true;

        while (secondHalfStart != null) {
            if (firstHalfStart.value != secondHalfStart.value) {
                isSymmetric = false;
                break;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        // Step 4: Restore the second half of the list (optional)
        reverseList(secondHalfCopy);

        return isSymmetric;
    }

    public static void main(String[] args) {
        // Test Case 1: Symmetric list
        SinglyLinkedList healthRecord1 = new SinglyLinkedList();
        for (int value : new int[]{1, 2, 3, 2, 1}) {
            healthRecord1.append(value);
        }
        System.out.print("Health Record 1: ");
        healthRecord1.display();
        System.out.println("Symmetric? " + isHealthRecordSymmetric(healthRecord1.head));

        // Test Case 2: Non-symmetric list
        SinglyLinkedList healthRecord2 = new SinglyLinkedList();
        for (int value : new int[]{1, 2, 3, 4, 5}) {
            healthRecord2.append(value);
        }
        System.out.print("Health Record 2: ");
        healthRecord2.display();
        System.out.println("Symmetric? " + isHealthRecordSymmetric(healthRecord2.head));

        // Test Case 3: Single-node list
        SinglyLinkedList healthRecord3 = new SinglyLinkedList();
        healthRecord3.append(1);
        System.out.print("Health Record 3: ");
        healthRecord3.display();
        System.out.println("Symmetric? " + isHealthRecordSymmetric(healthRecord3.head));

        // Test Case 4: Empty list
        SinglyLinkedList healthRecord4 = new SinglyLinkedList();
        System.out.print("Health Record 4: ");
        healthRecord4.display();
        System.out.println("Symmetric? " + isHealthRecordSymmetric(healthRecord4.head));
    }
}
