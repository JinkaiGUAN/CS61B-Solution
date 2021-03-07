import javax.lang.model.type.ReferenceType;

/**
 * @author: Peter
 * @data: 06/03/2021
 * @description: This deque must use arrays as the core data structure.
 */
public class ArrayDeque<ReferenceType> {
    private static int initialCapacity = 8; // Initial size of the array.
    private static int eFactor = 2; // Expanding factor
    private static int mCapacity = 16; // The minimum capacity for contraction resizing
    private static double mRatio = 0.25; // The minimum usage ratio before contraction
    private static int cFactor = 2; // Contracting factor
    private int capacity; // The length of the array.
    private int size;
    private ReferenceType[] items;
    private int nextFirst;
    private int nextLast;

    /**If your front pointer is at position zero, and you `addFirst`, the front pointer should loop back around to
     * the end of the array. So, the new front item in the deque will be the last item in the underlying array.
     */
    public ArrayDeque() {
        capacity = initialCapacity;
        items = (ReferenceType[]) new Object[initialCapacity];
        nextFirst = capacity - 1;
        nextLast = 0;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        capacity = other.getCapacity();
        items = (ReferenceType[]) new Object[capacity];
        nextFirst = capacity - 1;
        nextLast = 0;
        size = 0;

        for (int i = 0; i < other.size(); i ++) {
            addLast((ReferenceType) other.get(i));
        }
    }


    /**Resize the original array when the capacity should be increased.*/
    public void resize(int newCapacity) {
        ReferenceType[] newItems = (ReferenceType[]) new Object[newCapacity];

        int currentFirst = onePlus(nextFirst);
        int currentLast = oneMinus(nextLast);

        if (currentFirst < currentLast) {
            int copyLength = currentLast - currentFirst + 1;
            System.arraycopy(items, currentFirst, newItems, 0, copyLength);
            nextFirst = newCapacity - 1;
            nextLast = copyLength;
        } else {
            int lengthLast = nextLast;
            int lengthFirst = capacity - currentFirst;
            int newCurrentFirst = newCapacity - lengthFirst;
            System.arraycopy(items, currentFirst, newItems, newCurrentFirst, lengthFirst);
            System.arraycopy(items, 0, newItems, 0, lengthLast);
            nextFirst = newCurrentFirst - 1;
        }
        capacity = newCapacity;
        items = newItems;
    }


    /**Checks the array capacity, if necessary, change update the capacity*/
    public void expand() {
        if (size == capacity) {
            int newCapacity = capacity * eFactor;
            resize(newCapacity);
        }
    }

    /**Checks if it is necessary to contract the size. This is because sometimes, expanding large memory could
     * lead to memory waste if you do not get so many items.
     */
    public void contract() {
        double ratio = (double) size / capacity;
        if (ratio <= mRatio && capacity >= mCapacity) {
            int newCapacity = capacity / cFactor;
            resize(newCapacity);
        }
    }


    /**Decreases index according to circular structure.*/
    private int oneMinus(int index) {
        if (index == 0) {
            return capacity - 1;
        } else {
            return index - 1 ;
        }
    }


    /**Adds an item of type ReferenceType to the front of the deque.*/
    public void addFirst(ReferenceType item) {
        items[nextFirst] = item;
        nextFirst = oneMinus(nextFirst);
        size += 1;

        expand();
    }


    /**Increases index according to circular structure.*/
    private int onePlus(int index) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }


    /**Adds an item of type ReferenceType to the back of the deque.*/
    public void addLast(ReferenceType item) {
        items[nextLast] = item;
        nextLast = onePlus(nextLast);
        size += 1;

        expand();
    }

    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size() == 0;
    }

    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /**Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        if (isEmpty()) {
            return;
        } else {
            int currentIndex = onePlus(nextFirst); // point to the beginning of the array
            while (currentIndex != nextLast) {
                System.out.print(items[currentIndex] + " ");
                currentIndex = onePlus(currentIndex); // update the pointing index
            }
        }
        System.out.println();
    }

    /**Removes and returns the item at the front of the deque. If no such item exits, return null.*/
    public ReferenceType removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int firstIndex = onePlus(nextFirst);
        ReferenceType temp = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = onePlus(nextFirst);
        size -= 1;

        contract();

        return temp;
    }

    /**Removes and returns the item at the front of the deque. If no such item exits, return null.*/
    public ReferenceType removeLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIndex = oneMinus(nextLast);
        ReferenceType temp = items[lastIndex];
        items[lastIndex] = null;
        nextLast = oneMinus(nextLast);
        size -= 1;

        contract();

        return temp;
    }

    /**Gets the item and return the item at the given index.*/
    public ReferenceType get(int index) {
        if (index >= size()) {
            return null;
        }
        int currentIndex = nextFirst + 1 + index;
        if (currentIndex >= capacity) {
            currentIndex -= capacity;
        }
        return items[currentIndex];
    }


    /**Gets the capacity of the array.*/
    public int getCapacity() {
        return capacity;
    }
}
