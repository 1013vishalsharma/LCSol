package SDESheet.LinkedList_II;

class Node {

    int val;
    DLLNode next;

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

public class DetectCycleInLL {

    public static void display(DLLNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void detectCycle(DLLNode head){
        DLLNode slow = head.next;
        DLLNode fast = head.next.next;

        while(true){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                System.out.println("cycle found");
                break;
            }
            if(fast.next == null || fast.next.next == null){
                System.out.println(" no cycle present");
                break;
            }
        }
        slow.next = null;
        display(head);
    }

    public static void main(String[] args) {
        DLLNode head = new DLLNode(3);
        head.next = new DLLNode(2);
        head.next.next = new DLLNode(0);
        head.next.next.next = new DLLNode(-4);
        head.next.next.next.next = head.next;

        detectCycle(head);
    }
}
