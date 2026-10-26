//Imports 

public class Queue<E> {
    //Instance Variables
    private Node<E> head;
    private Node<E> tail;
    private int length;
    //----------------------------------------------------------------
    //Constructors
    public Queue() {
        this.length = 0;
    }
    //----------------------------------------------------------------
    //Methods
    public boolean offer(E nextElement) {
        Node<E> nextNode = new Node<>(nextElement);
        try{
            tail.setNextNode(nextNode);
            tail = nextNode;
        } catch (NullPointerException e) {
            head = nextNode;
            tail = head;
        }
        length++;
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public boolean dequeue() {
        try {
            this.head = head.getNextNode();
            length--;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
    //----------------------------------------------------------------    
        //Getters
        public Node<E> getHead() {
            return this.head;
        }
        public int getLength() {
            return this.length;
        }
        //Setters
        //toString
        @SuppressWarnings("unchecked")
        public String toString() {
            String returnString = "";
            Node<E> nextNode = this.head;
            while(nextNode != null) {
                returnString += String.format("[%s] ", nextNode.getElement());
                nextNode = nextNode.getNextNode();
            }
            return returnString;
        }
    //----------------------------------------------------------------    
}