package SDESheet.LinkedList;

public class Merge2SortedLL {

    public static Node mergeTwoLists(Node list1, Node list2) {
        Node head = new Node(-1);
        Node dummy = head;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                list1 = mergeNodes(list1, dummy);

            } else {
                list2 = mergeNodes(list2, dummy);
            }
            dummy = dummy.next;
        }

        while(list1 != null){
            list1 = mergeNodes(list1, dummy);
            dummy = dummy.next;
        }

        while (list2 != null){
            list2 = mergeNodes(list2, dummy);
            dummy = dummy.next;
        }

        display(head);
        return head;
    }

    public static void display(Node head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static Node mergeNodes(Node list , Node dummy){
        Node prev = list;
        list = list.next;
        prev.next = null;
        dummy.next = prev;
        return list;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        mergeTwoLists(list1, list2);
    }
}
