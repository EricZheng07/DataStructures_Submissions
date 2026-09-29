public class HwParts{

//-------------------------------------------------------------------------------------------------------
    //Part 4 Stack class
    public static class Stack {
        //Instance variables
            private int stackHeight = 100;
            private int[] stack = new int[stackHeight];
            private int head = 0;
        //Methods
            public void push(int val) {
                if(head < stackHeight)
                    stack[head++] = val;
            }
            public int pop() {
                if(head == 0)
                    return 0;
                return stack[--head];
            }
            public int peek() {
                if (!isEmpty())
                    return stack[head-1];
                return 0;
            }
            public boolean isEmpty(){
                return head == 0;
            }

    }
//-------------------------------------------------------------------------------------------------------
    //Part 10 queue class
    public static class Queue {
         //Instance variables
            private int queueHeight = 100;
            private int[] queue = new int[queueHeight];
            private int head = 0;
            private int nextCell = 0;
            private boolean looped = false;
        //Methods
            public void enqueue(int val) {
                if(nextCell == queueHeight) {
                    looped = true;
                    nextCell = 0;
                }
                if(nextCell < queueHeight)
                    if(!looped)
                        queue[nextCell++] = val;
                    else if(nextCell > head)
                        queue[nextCell++] = val;
            }
            public int dequeue() {
                if(head == queueHeight) {
                    head = 0;
                    looped = false;
                }
                if(!looped)
                    if(head==nextCell)
                        return 0;
                return queue[head++];
            }
            public int peek() {
                if (!isEmpty())
                    return queue[head];
                return 0;
            }
            public boolean isEmpty(){
                return !looped && head == nextCell;
            }
    }

//-------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        //Part 1
            /*
            NAME: Eric Zheng
            LANGUAGE: JAVA
            IDE: Visual Studio Code 
            */

        //Part 2
            /*
            1. ADT stands for Abstract Data Type 
            2. Abstract Data Types are models that define a preset of rule designed to govern the behavior of something
            3. The difference between ADT's and its implementaions are that while ADT's define a set of rules, its implementations are
            what creates useable applications/ its implementations give meaning to the code. 
            4. Yes, two programers can create 2 different implementaions of the same ADT as the rules can be altered to 
            the use case for each programer's situation 
            5. As long as the Stack follows the rule such as the last item in is the first item out, dispite one stack 
            built around an array and the other an array list, both are still stacks. 
            */

        //Part 3
        Stack stackExample = new Stack();
        stackExample.push(15);
        stackExample.push(25);
        stackExample.pop();

        //Part 4
        /*
        Implemented in the static class "Stack"
        */

        //Part 5
        //Build Stack
        Stack stack5 = new Stack();
        stack5.push(15);
        stack5.push(25);
        stack5.push(35);
        stack5.push(45);
        stack5.push(55);

        //Part 6
        //Test stack from part 5
        System.out.printf("Peek: %d\n",stack5.peek());
        System.out.printf("Popped: %d\n",stack5.pop());
        System.out.printf("Popped: %d\n",stack5.pop());
        System.out.printf("Peek: %d\n",stack5.peek());
        System.out.printf("Is Empty? %b\n",stack5.isEmpty());

        //Part 7
        //FULL STACK DEMO
        Stack stack7 = new Stack();
        System.out.printf("\nAdding:\n15\n25\n35\n45\n55\n");
        stack7.push(15);
        stack7.push(25);
        stack7.push(35);
        stack7.push(45);
        stack7.push(55);
        System.out.printf("Top item:\n%d\n",stack7.peek());
        System.out.printf("Removing:\n%d\n",stack7.pop());
        System.out.printf("Removing:\n%d\n",stack7.pop());
        System.out.printf("New Top:\n%d\n",stack7.peek());
        System.out.printf("Is Stack Empty?\n%b\n",stack7.isEmpty());

        //Part 8
        /*
        6. LIFO means Last in First out and represents a ruleset that an ADT follows 
        7. 55 gets removed before 15 because a stack follows a last in first out rule set. 55 was added last 
        so it was the first to be removed. 
        8. If D was last added onto the stack, calling pop() will remove D first
        9. Stacks are useful in any case when the first thing you fetch is the last thing you want to let go; for 
        example if you want to reverse something, you can use a call stack with recursion to print out 
        your items backwards. 
        */

        //Part 9 
        //Yes 

        //Part 10
        //Implemented above 

        //Part 11
        Queue queue11 = new Queue();
        queue11.enqueue(15);
        queue11.enqueue(25);
        queue11.enqueue(35);
        queue11.enqueue(45);
        queue11.enqueue(55);
        
        //Part 12
        Queue queue12 = new Queue();
        queue12.enqueue(15);
        queue12.enqueue(25);
        queue12.enqueue(35);
        queue12.enqueue(45);
        queue12.enqueue(55);
        System.out.println(queue12.peek());
        System.out.println(queue12.dequeue());
        System.out.println(queue12.dequeue());
        System.out.println(queue12.peek());
        System.out.println(queue12.isEmpty());

        //Part 13
        Queue queue13 = new Queue();
        System.out.printf("\nQUEUE DEMONSTRATION\nAdding:\n15\n25\n35\n45\n55\n");
        queue13.enqueue(15);
        queue13.enqueue(25);
        queue13.enqueue(35);
        queue13.enqueue(45);
        queue13.enqueue(55);
        System.out.printf("Front item:\n%d\n",queue13.peek());
        System.out.printf("Removing:\n%d\n",queue13.dequeue());
        System.out.printf("Removing:\n%d\n",queue13.dequeue());
        System.out.printf("New Front:\n%d\n",queue13.peek());
        System.out.printf("Is Queue Empty?\n%b\n",queue13.isEmpty());

        //Part 14
        /*
        10. FIFO means first in first out.
        11. 15 was removed before 55 in this case becasue it was under a queue data structure, thus
        the first item (15) is the first to go out.
        12. The first customer should go first in a queue, therefor Alex will leave the queue first.
        13. A real world example where queue is useful is in any case where priority should be first 
        come first serve such as a printing station. The print jobs will build a queue and when the 
        prints are relesed, the first person who entered the queue will have their stuff processed first.
        */

        //Part 15
        /*
        Senario 1: Stack because the most recent action (last in) gets released first (first out).

        Senario 2: Queue becasue the first document (first in) gets out first (first out).

        Senario 3: Stack becuase the most recent page visited (last in) gets released first (first out).

        Senario 4: Queue because the first customer in line (first in) gets talked to first (first out).

        Senario 5: 5 plates stacked best represents a Stack becasue you will often reach for the first 
        plate ontop (the last one put on) and use it first (first out).
        */

        //Part 16
        /*
        <STACK>
        14. pop() returns the most recent element, that being 18
        15. peek also returns the most recent element, that being 22
        <QUEUE>
        16. dequeue returns the first element, that being 7
        17. since dequeue has been called once, peek returns the next/ second element, 
        that being 12

        //Part 17
         /*
            |     Feature     |     Stack     |     Queue     |
            |-------------------------------------------------|
            | Rule            | yes           | yes           |
            | Add opp         | yes           | yes           |
            | Remove opp      | yes           | yes           |
            | View next       | yes           | yes           |
            | Rmv First       | no            | yes           |
            |-------------------------------------------------|		        

        */

        //Part 18
        /*
        18. The Stack is the ADT
        19. The implementaion is the way you code the rules
        20. If you keep the stack rule set but change from an array to an array list, the ADT did not change,
        only the implementaion did as the ADT is still a stack. 
        */


        //Part 19
            //Yes


    }

}