import java.util.Scanner;

class Stack {
    // Two inbuilt queues
    static ListQueue q1 = new ListQueue();
    static ListQueue q2 = new ListQueue();

    // To maintain current number of
    // elements
    int curr_size;

    Stack()
    {
        curr_size = 0;
    }

    void push(int x)
    {
        curr_size++;

        // Push x first in empty q2
        q2.enqueue(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }

        // swap the names of two queues
        ListQueue q = q1;
        q1 = q2;
        q2 = q;
    }

    int pop()
    {
        // if no elements are there in q1
        if (q1.isEmpty())
            throw new Error("No elements");

        curr_size--;
        return q1.dequeue();
    }
}


public class Calculator {
    Stack stack = new Stack();
    private int tempOperand = 0;
    private int tempOperandNum = 1;
    String expression;

    Calculator(String expression) {
        this.expression = expression;
    }

    public void process(char val)
    {
        int res = val;
        int flag = 0;
        if(val == '+')
        {
            flag = 1 ;
            res = stack.pop() + stack.pop();
        }
        else if(val == '-')
        {
            flag =1 ;
            res = stack.pop() - stack.pop();
        }
        else if(val == '*')
        {
            flag =1 ;
            res = stack.pop() * stack.pop();
        }
        else if(val == '/')
        {
            flag =1 ;
            res = (stack.pop() / stack.pop());
        }
        else if (val == ' ')
        {
            this.stack.push(this.tempOperand);
            this.tempOperand = 0;
            this.tempOperandNum = 1;
        }
        else {  // digit of a number received
            this.tempOperand += (val-48) * this.tempOperandNum;
            this.tempOperandNum *= 10;
        }

        if(flag == 1)
            this.stack.push(res);
    }

    public void calculate() {
        char[] expr = this.expression.toCharArray();

        for(int j = expr.length-1 ; j>=0 ; j--)
        {
            process(expr[j]);
        }
        System.out.println("Result is : " + stack.pop());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        input += in.nextLine();

        new Calculator(input).calculate();

    }
}