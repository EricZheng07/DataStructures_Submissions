//Imports

public class Stack<E> {
    //Instance Variables 
    private Node<E> head;
    private int size;

    //Constructors 
    public Stack() {
        this.size = 0;
    }

    //Methods
    public boolean push(E element) {
        Node<E> nextNode = new Node<E>(element);
        try {
            nextNode.setNextNode(head);
            head = nextNode;
        } catch (NullPointerException e) {
            head = nextNode;
        }
        size++;
        return true;
    } 
    @SuppressWarnings("unchecked")
    public boolean pop() {
        try {
            head = head.getNextNode();
            size--;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
        
        //Getters
        public Node<E> peek() {
            return head; 
        }
        public int getSize() {
            return size;
        }
        @SuppressWarnings("unchecked")
        public E peekAt(int index) {
            if(index >= size) return null;
            Node<E> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            return currentNode.getElement();
        }
        //Setters 
        
        //toString
        @SuppressWarnings("unchecked")
        public String toString() {
            if (size == 0) return "";
            String returnString = "[";
            Node<E> nextNode = this.head;
            while(nextNode != null) {
                returnString += String.format("%s", nextNode);
                if(nextNode.nextNode != null) returnString += ", "; else returnString +="]";
                nextNode = nextNode.getNextNode();
            }
            return returnString;
        }
}
