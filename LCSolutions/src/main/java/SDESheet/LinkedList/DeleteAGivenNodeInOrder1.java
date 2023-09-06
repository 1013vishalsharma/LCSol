package SDESheet.LinkedList;

public class DeleteAGivenNodeInOrder1 {

    public static void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);
        deleteNode(head.next);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
