
public class ECommerceOrderSystem {

    public static void main(String[] args) {
        // Create some orders
        Order order1 = new Order(1, "Alice", "Laptop, Mouse");
        Order order2 = new Order(2, "Bob", "Phone, Charger");
        Order order3 = new Order(3, "Charlie", "Tablet, Case");

        // Create the linked list and add orders
        SinglyLinkedList ordersList = new SinglyLinkedList();
        ordersList.append(order1);
        ordersList.append(order2);
        ordersList.append(order3);

        // Display the list of orders
        System.out.println("Original Order List:");
        ordersList.display();

        // Reverse the list
        ordersList.reverse();

        // Display the reversed list of orders
        System.out.println("\nReversed Order List:");
        ordersList.display();
    }
}

class Order {

    private int orderId;
    private String customerName;
    private String orderDetails;

    public Order(int orderId, String customerName, String orderDetails) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Order Details: " + orderDetails;
    }
}

class Node {

    Order data;
    Node next;

    public Node(Order data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    private Node head;

    public void append(Order order) {
        Node newNode = new Node(order);
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

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }
        head = prev;
    }

}
