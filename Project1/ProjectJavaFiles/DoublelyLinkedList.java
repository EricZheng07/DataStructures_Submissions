//Imports 

public class DoublelyLinkedList<E> {
    //Static Class
    public static class DoubleNode<E> extends Node<E> {
        //Static Class Instance Variables 
        protected DoubleNode<E> previousNode;
        protected DoubleNode<E> nextNode;

        //Static Class Constructors
        private DoubleNode(E element) {
            super(element);
        } 
    }
    
    //Instance Variables
    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    //Constructor 
    public DoublelyLinkedList() {
        this.size = 0; 
    }
    
    //Methods 
    public boolean prepend(E element) {
        DoubleNode<E> newNode = new DoubleNode<E>(element);
        try {
            newNode.previousNode = head.previousNode; 
            head.previousNode = newNode;
            newNode.nextNode = head;
            newNode.previousNode.nextNode = newNode;
            head = newNode;
            size++;
            return true;
        } catch (NullPointerException e) {
            if(size == 0) {
                head = newNode;
                tail = newNode;
            } else if(size == 1) {
                head.previousNode = newNode;
                head.nextNode = newNode;
                newNode.nextNode = head;
                newNode.previousNode = head;
                head = newNode;
            } else {
                System.err.println("Unaccounted NullPointerException");
            }
            size++;
            return true;
        }
    }
    public boolean append(E element) {
        DoubleNode<E> newNode = new DoubleNode<E>(element);
        try {
            newNode.previousNode = tail; 
            newNode.nextNode = tail.nextNode;
            tail.nextNode.previousNode = newNode;
            tail.nextNode = newNode;
            tail = newNode;
            size++;
            return true;
        } catch (NullPointerException e) {
            if(size == 0) {
                head = newNode;
                tail = newNode;
            } else if(size == 1) {
                newNode.previousNode = tail;
                newNode.nextNode = tail;
                tail.nextNode = newNode;
                tail.previousNode = newNode;
                tail = newNode;
            } else {
                System.err.println("Unaccounted NullPointerException");
            }
            size++;
            return true;
        }
    }
    public boolean removeHead() {
        try {
            if(size == 1) {
                head = null; 
                tail = null;
            } else {
                head = head.nextNode;
                head.previousNode = tail;
                tail.nextNode = head;
            }
            size--;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }   
    public boolean removeTail() {
        try {
            if(size == 1) {
                head = null; 
                tail = null;
            } else {
                tail = tail.previousNode;
                tail.nextNode = head;
                head.nextNode = tail;
            }
            size--;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    } 
    public boolean removeAt(int index) {
        //edge cases
        if (index >= size) return false;
        if (index == 0) {
            removeHead();
            return true;
        }
        if (index == size-1) {
            removeTail();
            return true;
        }
        //primary cases 
        DoubleNode<E> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        currentNode.previousNode.nextNode = currentNode.nextNode;
        currentNode.nextNode.previousNode = currentNode.previousNode;
        size--;
        return true;
    }
    public int indexOf(E element) {
        int elementIndex = 0;
        DoubleNode<E> currentNode = head;
        while (elementIndex < size) {
            if (currentNode.getElement().equals(element)) return elementIndex;
            currentNode = currentNode.nextNode;
            elementIndex++;
        }    
        return -1;
    }
    public E get(int index) {
        if(index >= size || index < 0) return null;
        DoubleNode<E> currentNode = head;
        for(int i = 0; i != index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.getElement();
    }
    public boolean conatins(E element) {
        return indexOf(element) != -1;
    }
    public void clear() {
        head=null;
        tail=null;
        size = 0;
    }
        //Getters
        public int getSize() { 
            return this.size;
        }
        public E getHeadElement() {
            return this.head.getElement();
        }
        public E getTailElement() {
            return this.tail.getElement();
        }
        public DoubleNode<E> getHead() {
            return this.head;
        }
        //Setters

        //toString
        public String toString() {
            if (size == 0) return "[]";
            String returnString = "[";
            DoubleNode<E> nextNode = this.head;
            int elementCounter = 0;
            while(elementCounter < size){
                returnString += String.format("%s", nextNode);
                if(elementCounter != size -1) returnString += ", "; else returnString +="]";
                nextNode = nextNode.nextNode;
                elementCounter++;
            }
            return returnString;
        }
}
