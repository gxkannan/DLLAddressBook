/**
 * Representing a sorted doubly linked list, implemented using Generic Node objects.
 * @author Gaia Kannan
 * @version 1.0
 */
public class SortedList<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * The default constructor.
     */
    public SortedList(){
    }

    /**
     * A constructor taking a comparator and a root node.
     * @param root The root node.
     */
    public SortedList(Node<E> root){
        this.root = root;
    }

    /**
     * Indert an element into the list, and keep it sorted.
     * @param element The element to be inserted.
     */
    public void insert(E element){
        Node<E> node = new Node(element);
        if(root == null) {
            this.root = new Node<E>(element);
        }
        else {
            Node<E> end = NodeAt(size());
            end.setNext(element);
            NodeAt(size()).setPrev(end);
            sort();
        }
    }

    /**
     * Delete an element from the list.
     * @param index
     */
    public void delete(int index){
        SortedList<E> newSortedList = new SortedList<>();
        set(index, null);
        int i = 0;
        Node curr = root;
        while (i <= size()){
            if (i == index){
                i++;
            }
            else{
                newSortedList.insert(get(i));
            }
            i++;
        }
        int j = 0;
        clear();
        while (j < newSortedList.size()){
            insert(newSortedList.get(j));
            j++;
        }
    }
    /**
     * Delete all elements from this list.
     */
    public void clear(){
        root = null;
    }

    /**
     * Set an element at a given index.
     * @param index Index of element to be set.
     * @param element Element to set at a given index.
     */
    public void set(int index, E element){
        NodeAt(index).setData(element);
    }
    /**
     * Return a reference to an item at a given index.
     * @param index The index of the item.
     * @return The item at the index.
     */
    public E get(int index){
        Node<E> node = NodeAt(index);
        return node.getData();
    }

    /**
     * Return the Node at a given index.
     * @param index The index of the Node.
     * @return The Node at the index.
     */
    public Node<E> NodeAt(int index){
        int i = 0;
        Node<E> temp = root;
        if (index != 0) {
            while (i < index && temp.hasNext()) {
                temp = temp.getNext();
                i++;
            }
        }
        return temp;
    }

    /**
     * Determine if the list is empty.
     * @return 1 if empty, 0 if not.
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Determine the number of elements in the list.
     * @return The number of elements.
     */
    public int size(){
        if(root == null){
            return 0;
        }
        int i = 1;
        Node<E> temp = root;
        while (temp.hasNext()){
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    /**
     * Converts the list to a string.
     * @return A formatted string listing the list values in order.
     */
    @Override
    public String toString(){
        int i = 0;
        String str = new String("");
        if (size() > 0) {
            while (i < size()) {
                str = str + get(i);
                if (i == size() - 1) {
                    return str;
                } else str = str + ", ";
                i++;
            }
        }
        else str = "null";
        return str;
    }

    /**
     * Evaluates if this list is equal to another.
     * @param o Object to be compared to.
     * @return 1 if equal, 0 if not.
     */
    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()){
            return false;
        }
        else {
            SortedList<E> list = (SortedList<E>) o;
            if (list.size() != this.size()) {
                return false;
            }
            if (list.root.getData() != this.root.getData()) {
                return false;
            }
            if (list.get(size()) != this.get(size())) {
                return false;
            } else {
                for (int i = 0; i < size(); i++) {
                    if (list.get(i) != this.get(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * Sorts the elements in the list.
     */
    public void sort(){
        for (int i = 0; i<size(); i++){
            for (int j = i + 1; j < size(); j++){
                if (get(j).compareTo(get(i)) < 0){
                    swap(NodeAt(j), NodeAt(i));
                }
            }
        }
    }

    /**
     * A helper method to swap two items.
     * @param n1 First item to be swapped.
     * @param n2 Second item to be swapped.
     */
    public void swap(Node<E> n1, Node<E> n2){
        E temp = n1.getData();
        n1.setData(n2.getData());
        n2.setData(temp);
    }
}
