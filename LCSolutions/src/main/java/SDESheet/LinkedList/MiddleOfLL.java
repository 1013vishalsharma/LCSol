package SDESheet.LinkedList;

class Node {

    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
public class MiddleOfLL {

    public static void middleOfLL(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);
    }

    public static void main(String[] args) {
        MiddleOfLL sol = new MiddleOfLL();
        Node ll = new Node(1);
        ll.next = new Node(2);
        ll.next.next = new Node(3);
        ll.next.next.next = new Node(4);
        ll.next.next.next.next = new Node(5);
        ll.next.next.next.next.next = new Node(6);

        middleOfLL(ll);
    }
}
