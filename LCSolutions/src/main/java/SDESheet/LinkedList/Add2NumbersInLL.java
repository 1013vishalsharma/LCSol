package SDESheet.LinkedList;

public class Add2NumbersInLL {

    public static Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0, sum = 0;
        Node result = null;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = 0;
            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            result = addNode(sum, result);
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            sum = l1.val + carry;
            carry = 0;
            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            result = addNode(sum, result);
            l1 = l1.next;
        }

        while(l2 != null){
            sum = l2.val + carry;
            carry = 0;
            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            result = addNode(sum, result);
            l2 = l2.next;
        }
        if(carry != 0){
            result = addNode(carry, result);
        }

        display(result);
        return result;
    }

    private static Node addNode(int val, Node result){
        if(result == null){
            result = new Node(val);
        } else {
            Node n = result;
            while(n.next != null){
                n = n.next;
            }
            n.next = new Node(val);
        }
        return result;
    }

    private static void display(Node head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        //l1.next.next = new Node();

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        /*Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(9);
        l1.next.next.next.next = new Node(9);
        l1.next.next.next.next.next = new Node(9);
        l1.next.next.next.next.next.next = new Node(9);


        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);*/

        addTwoNumbers(l1, l2);
    }
}
