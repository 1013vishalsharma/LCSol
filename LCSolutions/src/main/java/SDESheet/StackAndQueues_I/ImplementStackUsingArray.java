package SDESheet.StackAndQueues_I;

public class ImplementStackUsingArray {

    int top;
    int[] stack;
    public ImplementStackUsingArray(int maxSize) {
        stack = new int[maxSize];
        top = stack.length;
    }
    public void push(int x) {
        if(top > 0){
            top--;
            stack[top] = x;
            System.out.println("pushed element is: " + x);
        } else {
            System.out.println("Cannot add new ele, stack is full");
        }
    }

    public int pop() {
        if(top < stack.length){
            System.out.println("popped element is: " + stack[top]);
            int pop = stack[top];
            stack[top] = 0;
            top++;
            return pop;
        } else {
            System.out.println("Cannot remove ele, stack is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return top == stack.length;
    }

    public boolean isFull() {
        return top == 0;
    }

    public void increment(int k, int val) {
        if(isEmpty()){
            System.out.println("Cannot increment any value as stack is empty");
            return;
        }
        int len = stack.length-1;
        System.out.println("Incremented last " + k + " values by " + val);
        while(k != 0 && len >= top && !isEmpty()){
            stack[len] = stack[len] + val;
            System.out.print(stack[len] + " ");
            k--;
            len--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementStackUsingArray stack = new ImplementStackUsingArray(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isFull());
        stack.push(3);
        System.out.println(stack.isFull());
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        System.out.println(stack.isFull());
        stack.pop();
        stack.pop();
        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
        stack.increment(2, 200);
        stack.push(5);
        stack.push(6);
        stack .pop();
    }
}
