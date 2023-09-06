package SDESheet.LinkedList_II;

public class CheckIfGivenLLIsPalindrome {

    public static boolean isPalindrome(DLLNode head) {
        DLLNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        DLLNode prev = null;
        DLLNode curr = slow.next;
        DLLNode fwd = null;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        slow.next = prev;

        DLLNode mid = slow.next;
        DLLNode start = head;
        while(mid != null){
            if(start.val != mid.val){
                return false;
            }
            start = start.next;
            mid = mid.next;
        }
        return true;
    }

    public static void display (DLLNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        /*Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);*/

        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(1);
        /*head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);*/



        System.out.println(isPalindrome(head));
    }
}
