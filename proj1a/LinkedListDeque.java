/**
 * @param <ReferenceType>: It is the reference type of the list, like, String or Integer.
 */
public class LinkedListDeque<ReferenceType>{
    /**Create the inner block of the item, which includes the previous and next
     * point, and an item.
     */
    public class BlockNode {
        public BlockNode prev;
        public ReferenceType item;
        public BlockNode next;

        public BlockNode(BlockNode pre, ReferenceType i, BlockNode n) {
            prev = pre;
            item = i;
            next = n;
        }
    }

    /*Variables, The first item (if it is exits) is at sentinel.next.*/
    // private BlockNode sentinel;
    private BlockNode sentFront;
    private BlockNode sentBack;
    private int size;


    /**Constructor function. At the first time, we would not consider when the list is null.*/
    public LinkedListDeque() {
        sentFront = new BlockNode(null, null, null);
        sentBack = new BlockNode(sentFront, null, null);
        sentFront.next = sentBack;
        size = 0;
    }

    public LinkedListDeque(ReferenceType x) {
        sentFront = new BlockNode(null, null, null);
        sentFront.next = new BlockNode(null, x, null);
        sentBack = new BlockNode(sentFront.next, null, null);
        size = 1;
    }


    /** Deep copy of other.*/
    public LinkedListDeque(LinkedListDeque<ReferenceType> other) {
        sentFront = new BlockNode(null, null, null);
        sentBack = new BlockNode(sentFront, null, null);
        sentFront.next = sentBack;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /**Adds an item of type ReferenceType to the front of the deque.*/
    public void addFirst(ReferenceType item) {
        sentFront.next = new BlockNode(sentFront, item, sentFront.next);
        sentFront.next.next.prev = sentFront.next;
        size += 1;
    }

    public ReferenceType getFirst() {
        return sentFront.next.item;
    }

    /**Adds an item of type ReferenceType to the back of the deque.*/
    public void addLast(ReferenceType item) {
        sentBack.prev = new BlockNode(sentBack.prev, item, sentBack);
        sentBack.prev.prev.next = sentBack.prev;
        size += 1;
    }

    public ReferenceType getLast() {
        return sentBack.prev.item;
    }


    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size() == 0;
    }

    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /**Prints the items in the deque from the list to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        BlockNode p = sentFront.next;
        while(p != sentBack){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**Removes and returns the item at the front of the deque. If no such item,
     * exits, return null.
     */
    public ReferenceType removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            ReferenceType temp = sentFront.next.item;
            sentFront.next = sentFront.next.next;
            sentFront.next.prev = sentFront;
            size -= 1;
            return temp;
        }
    }

    /**Removes and returns the item at the back of the deque. If no such item,
     * exits, return null.
     */
    public ReferenceType removeLast() {
        if (size() == 0) {
            return null;
        } else {
            ReferenceType temp = sentBack.prev.item;
            sentBack.prev = sentBack.prev.prev;
            sentBack.prev.next = sentBack;
            size -= 1;
            return temp;
        }
    }

    /** Gets the item at the given index.*/
    public ReferenceType get(int index) {
        if (index > size()) {
            return null;
        }
        BlockNode p = sentFront;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.next.item;
    }

    public ReferenceType getRecursiveHelper(BlockNode current, int ind) {
        if (ind == 0) {
            return current.item;
        }
        ind -= 1;
        return getRecursiveHelper(current.next, ind);
    }

    /** Same as get, but use recursive.*/
    public ReferenceType getRecursive(int index) {
        if (index > size()) {
            return null;
        }
        return getRecursiveHelper(sentFront.next, index);
    }

}
