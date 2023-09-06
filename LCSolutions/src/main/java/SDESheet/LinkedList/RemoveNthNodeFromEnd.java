package SDESheet.LinkedList;

public class RemoveNthNodeFromEnd {

    public static void removeNthNode(Node head){
        int k = 3;
        removeNthNode(head, k);
        display(head);
    }

    public static void removeNthNode(Node head, int k){
        Node start = new Node(-1);
        start.next = head;
        Node slow = start;
        Node fast = start;

        for (int i = 1; i<=k; i++){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        display(start.next);
    }

    public static void display(Node head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node ll = new Node(1);
        ll.next = new Node(2);
        ll.next.next = new Node(3);
        //ll.next.next.next = new Node(4);
        //ll.next.next.next.next = new Node(5);

        /*Node ll = new Node(7);
        ll.next = new Node(6);
        ll.next.next = new Node(9);
        ll.next.next.next = new Node(4);
        ll.next.next.next.next = new Node(13);
        ll.next.next.next.next.next = new Node(2);
        ll.next.next.next.next.next.next = new Node(8);*/

        removeNthNode(ll);
    }
}
