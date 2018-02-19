import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ArrayDeque<E> implements DequeInterface<E> {

    private E[] theArray;
    private int size;
    private int firstIndex;
    private int lastIndex;
    private int capacity;
    private final int DEFAULT_CAPACITY = 100;


    public ArrayDeque(int arraySize) {
        if (arraySize > DEFAULT_CAPACITY) {
            arraySize = DEFAULT_CAPACITY;
        }
        this.theArray = (E[]) new Object[arraySize];
        this.firstIndex = 0;
        this.lastIndex = 0;
        this.size = 0;
        capacity = arraySize;
    }

    /**
     * F
     * Retunerer hvor mange elementer samlingen inneholder.
     *
     * @return Størrelsen på samlingen.
     */
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Legger til et element på begynnelsen av samlingen.
     *
     * @param elem Elementet som skal legges til.
     * @throws DequeFullException når det ikke er plass til
     *                            elementet.
     */
    @Override
    public void addFirst(E elem) throws DequeFullException {

        if (size == capacity) {
            throw new DequeFullException("Full");
        }
        if (isEmpty()) {
            theArray[firstIndex] = elem;
        } else {
            firstIndex = (firstIndex - 1 + capacity) % capacity;
            theArray[firstIndex] = elem;

        }
        size++;
    }

    /**
     * Legger til et element på slutten av samlingen.
     *
     * @param elem Elementet som skal legges til.
     * @throws DequeFullException når det ikke er plass til
     *                            elementet.
     */
    @Override
    public void addLast(E elem) throws DequeFullException {
        if (size == capacity) {
            throw new DequeFullException("Deque is full!");
        } else {
            lastIndex = (lastIndex + 1) % capacity;
            theArray[lastIndex] = elem;
            size++;

        }

    }

    /**
     * Fjerner det første elementet fra samlingen og
     * returnerer det.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E pullFirst() throws DequeEmptyException {
        E objectToReturn = null;
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty!");
        } else {
            objectToReturn = theArray[firstIndex];
            theArray[firstIndex] = null;
            firstIndex = (firstIndex + 1) % capacity;
            size--;

        }
        return objectToReturn;
    }

    /**
     * Retunerer det første elementet fra samlingen, men
     * fjerner det ikke.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E peekFirst() throws DequeEmptyException {
        if (size == 0) {
            throw new DequeEmptyException("Deque is empty");
        }
        return theArray[firstIndex];
    }


    /**
     * Fjerner det siste elementet i samlingen og returnerer
     * det.
     *
     * @return Det siste elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E pullLast() throws DequeEmptyException {
        E objectToReturn = null;
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty!");
        } else {
            objectToReturn = theArray[lastIndex];
            theArray[lastIndex] = null;
            lastIndex = (lastIndex - 1 + capacity) % capacity;
            size--;

        }
        return objectToReturn;
    }

    /**
     * Retunerer det siste elementet i samlingen, men
     * fjerner det ikke.
     *
     * @return Det siste elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E peekLast() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty!");
        } else {
            return theArray[lastIndex];
        }
    }

    /**
     * Sjekker om et element er i samlingen.
     *
     * @param elem Elementet som kanskje er i samlingen.
     * @return retunerer true hvis elementet er i samlingen.
     */
    @Override
    public boolean contains(Object elem) {
        for (E element : theArray) {
            if (elem == element) {
                return true;
            } else if (elem.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retunerer en tabell med alle elementene i samlingen.
     *
     * @return En tabell med alle elementene i samlingen.
     */
    @Override
    public E[] toArray() {
        E[] arrayToReturn = (E[]) new Object[size];
        int index = 0;
        int start = firstIndex;
        for (int i = 0; i < theArray.length; i++) {
            if (theArray[(i + start) % capacity] != null) {
                arrayToReturn[index] = theArray[(i + start) % capacity];
                index++;
            }

        }
        return arrayToReturn;
    }

    /**
     * Fjerner alle elementene fra samlingen.
     */
    @Override
    public void clear() {
        for (E elem : theArray) {
            elem = null;
        }
        size = 0;
        firstIndex = 0;
        lastIndex = 0;

    }

    public void printDeque() throws DequeEmptyException {
        if (size == 0) {
            throw new DequeEmptyException("Empty!");
        }
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(i + ": " + theArray[i]);
        }
    }

    public void printCircular() {
        int start = firstIndex;
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[(i + start) % capacity]);
        }
    }

}
