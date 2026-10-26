//Imports

public class Node<E> {
    //Instance Variables
    protected  E element;
    @SuppressWarnings("rawtypes")
    protected Node nextNode;

    //Constructors
        public Node(E element) {
            this.element = element;
        }

    //Methods 
        //Getters 
            public E getElement() {
                return this.element;
            }
            @SuppressWarnings("rawtypes")
            public Node getNextNode() {
                return this.nextNode;
            }
        //Setters
            public void setNextNode(@SuppressWarnings("rawtypes") Node nextNode) {
            this.nextNode = nextNode;
        }
        
        //toString
        public String toString() {
            return this.element.toString();
        }
}
