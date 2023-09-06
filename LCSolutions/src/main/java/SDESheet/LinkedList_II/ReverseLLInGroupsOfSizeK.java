package SDESheet.LinkedList_II;

public class ReverseLLInGroupsOfSizeK {

    public static DLLNode reverseKGroup(DLLNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        DLLNode n1 = head;
        while (n1 != null){
            n1 = n1.next;
            len++;
        }

        DLLNode dummyHead = new DLLNode(-1);
        DLLNode finalHead = dummyHead;

        DLLNode curr = head;
        while(len >= k){
            DLLNode prev = null;
            DLLNode tail = curr;
            DLLNode fwd;
            int i = k;
            while(i != 0 && curr != null){
                fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
                i--;
                len--;
            }
            dummyHead.next = prev;
            dummyHead = tail;
        }
        if(len > 0){
            dummyHead.next = curr;
        }
        display(finalHead.next);
        return finalHead.next;
    }

    private static void display(DLLNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(2);
        /*head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);*/

        reverseKGroup(head, 2);
        System.out.println(7/2);
    }
}
