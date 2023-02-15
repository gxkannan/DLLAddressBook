/**
 * Representing a Generic doubly linked Node with a previous Node and next Node.
 * @author Gaia Kannan
 * @version 1.0
 */
public class Node<E> {
    private Node<E> prev;
    private Node<E> next;
    private E data;

    /**
     * The default constructor.
     */
    public Node(){
    }

    /**
     * Constructs a Node with its data as a parameter.
     * @param data The Node's data.
     */
    public Node(E data){
        this.data = data;
    }

    /**
     * Returns the previous Node.
     * @return The previous Node.
     */
    public Node<E> getPrev(){
        return this.prev;
    }
    /**
     * Returns the next Node.
     * @return The next Node.
     */
    public Node<E> getNext(){
        return this.next;
    }

    /**
     * Returns this Node's data.
     * @return This Node's data.
     */
    public E getData(){
        return this.data;
    }

    /**
     * Sets the previous Node's data.
     * @param element The previous Node's new data.
     */
    public void setPrev(E element){
        this.prev = new Node<E>(element);
    }

    /**
     * Sets the previous Node.
     * @param node the new previous Node.
     */
    public void setPrev(Node<E> node){
        this.prev = node;
        //this.prev.next = this;
    }

    /**
     * Sets the next Node's data.
     * @param element The next Node's new data.
     */
    public void setNext(E element){
        this.next = new Node<E>(element);
    }

    /**
     * Sets the next Node.
     * @param node the new next Node.
     */
    public void setNext(Node<E> node){
        this.next = node;
        //this.next.prev = this;
    }

    /**
     * Sets this Node's data.
     * @param element This Node's new data.
     */
    public void setData(E element){
        this.data = element;
    }

    /**
     * Checks if this Node has a next Node.
     * @return 1 if there is a next Node, 0 if not.
     */
    public boolean hasNext(){
        return this.next != null;
    }

    /**
     * Checks if this Node has a previous Node.
     * @return 1 if there is a previous Node, 0 if not.
     */
    public boolean hasPrev(){
        return this.prev != null;
    }
}
