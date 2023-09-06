package SDESheet.LinkedList;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindIntersectionPointOfYLL {

    public static Node prev = null;
    public static Node getIntersectionNode(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(!set.contains(headB))
                headB = headB.next;
            else
                return headB;
        }
        return null;
    }

    public static void main(String[] args) {
        Node list1 = new Node(4);
        list1.next = new Node(1);
        list1.next.next = new Node(8);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(1);
        list2.next.next.next = list1.next.next;
        list2.next.next.next.next = list1.next.next.next;
        list2.next.next.next.next.next = list1.next.next.next.next;

        Node ans = getIntersectionNode(list1, list2);
        System.out.println(ans.val);
    }
}
