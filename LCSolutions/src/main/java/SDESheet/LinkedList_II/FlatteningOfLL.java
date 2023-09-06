package SDESheet.LinkedList_II;

class DLLNode {
    public int val;
    public DLLNode prev;
    public DLLNode next;
    public DLLNode child;

    public DLLNode(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }

    @Override
    public String toString() {
        return "DLLNode{" +
                "val=" + val +
                '}';
    }
};
public class FlatteningOfLL {

    public static DLLNode flat(DLLNode head){
        DLLNode node = head;
        flatten(node);
        return head;
    }
    public static DLLNode flatten(DLLNode node) {
        if(node != null){
            if(node.child != null){
                DLLNode temp = node.next;
                DLLNode n2 = flatten(node.child);
                node.next = n2;
                node.next.prev = node;
                node.child = null;
                while(node.next != null){
                    node = node.next;
                }
                if(temp != null) {
                    node.next = temp;
                    temp.prev = node;
                    node.next = flatten(node.next);
                }
                return n2.prev;
            } else {
                node.next = flatten(node.next);
            }
        }
        return node;
    }

    public static void display(DLLNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        /*DLLNode head = new DLLNode(1);
        DLLNode node1 = new DLLNode(2);
        DLLNode node2 = new DLLNode(3);
        DLLNode node3 = new DLLNode(4);
        DLLNode node4 = new DLLNode(5);

        head.next = node1;

        node1.prev = head;
        node1.next = node2;
        node2.prev = node1;

        node1.child = node3;
        node3.next = node4;
        node4.prev = node3;*/

        DLLNode head = new DLLNode(1);
        DLLNode node1 = new DLLNode(2);
        DLLNode node2 = new DLLNode(3);
        DLLNode node3 = new DLLNode(4);
        DLLNode node4 = new DLLNode(5);
        DLLNode node5 = new DLLNode(6);
        DLLNode node6 = new DLLNode(7);
        DLLNode node7 = new DLLNode(8);
        DLLNode node8 = new DLLNode(9);
        DLLNode node9 = new DLLNode(10);
        DLLNode node10 = new DLLNode(11);
        DLLNode node11 = new DLLNode(12);
        DLLNode node12 = new DLLNode(13);


        head.next = node1;

        node1.prev = head;
        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;
        node2.child = node6;

        node6.next = node7;

        node7.prev = node6;
        node7.next = node8;
        node7.child = node10;

        node10.next = node11;

        node11.prev = node10;

        node8.next = node9;

        node9.prev = node8;

        node3.next = node4;
        node3.prev = node2;

        node4.next = node5;
        node5.prev = node4;
        node4.prev = node3;
        node4.child = node12;



        DLLNode n = flat(head);
        display(n);
    }
}
