
class PatientNode {

    int ssn;
    int age;
    String fullName;

    PatientNode prev;
    PatientNode next;

    // Constructor
    public PatientNode(int ssn, int age, String fullName) {
        this.ssn = ssn;
        this.age = age;
        this.fullName = fullName;
        this.prev = null;
        this.next = null;
    }
}

class PatientList {

    PatientNode head;

    // Add a node to the list
    public void addNode(int ssn, int age, String fullName) {
        PatientNode newNode = new PatientNode(ssn, age, fullName);
        if (head == null) {
            head = newNode;
        } else {
            PatientNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Print the list
    public void printList() {
        PatientNode current = head;
        while (current != null) {
            System.out.println("SSN: " + current.ssn + ", Age: " + current.age + ", Name: " + current.fullName);
            current = current.next;
        }
    }
}

public class TwoHealthCareProviders {

    public static PatientNode mergeSortedLists(PatientNode head1, PatientNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        PatientNode mergedHead = null, tail = null;

        while (head1 != null && head2 != null) {
            PatientNode smallerNode;
            if (head1.ssn <= head2.ssn) {
                smallerNode = head1;
                head1 = head1.next;
            } else {
                smallerNode = head2;
                head2 = head2.next;
            }

            // Add the smaller node to the merged list
            if (mergedHead == null) {
                mergedHead = smallerNode;
                tail = smallerNode;
            } else {
                tail.next = smallerNode;
                smallerNode.prev = tail;
                tail = tail.next;
            }
        }

        // Attach the remaining nodes
        if (head1 != null) {
            tail.next = head1;
            head1.prev = tail;
        } else if (head2 != null) {
            tail.next = head2;
            head2.prev = tail;
        }

        return mergedHead;
    }

    public static void main(String[] args) {
        // List 1
        PatientList HealthMergeInc = new PatientList();
        HealthMergeInc.addNode(101, 30, "Alice");
        HealthMergeInc.addNode(103, 25, "Bob");
        HealthMergeInc.addNode(107, 40, "Carol");

        // List 2
        PatientList CarePlus = new PatientList();
        CarePlus.addNode(102, 35, "David");
        CarePlus.addNode(104, 29, "Eve");
        CarePlus.addNode(108, 50, "Frank");

        System.out.println("HealthMergeInc 1:");
        HealthMergeInc.printList();

        System.out.println("\nCarePlus 2:");
        CarePlus.printList();

        // Merge the lists
        PatientNode mergedHead = mergeSortedLists(HealthMergeInc.head, CarePlus.head);

        // Print the merged list
        System.out.println("\nMerged List:");
        PatientNode current = mergedHead;
        while (current != null) {
            System.out.println("SSN: " + current.ssn + ", Age: " + current.age + ", Name: " + current.fullName);
            current = current.next;
        }
    }
}
