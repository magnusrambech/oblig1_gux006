public class ArrayDeque<E> implements DequeInterface<E> {

    private E[] theArray;
    private int size;
    private int firstIndex;
    private int lastIndex;
    private boolean initialized;
    private final int DEFAULT_CAPACITY = 10;


    public ArrayDeque(int size){
        theArray= (E[])new Object[size];
        firstIndex=0;
        lastIndex=0;
        size=0;
        initialized = true;
    }

    /**
     * Retunerer hvor mange elementer samlingen inneholder.
     *
     * @return Størrelsen på samlingen.
     */
    @Override
    public int size() {
        return size;
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
        if(initialized){
            if(size == DEFAULT_CAPACITY){
                throw new DequeFullException("Full");
            }
            else {
                theArray[lastIndex+1] = theArray[firstIndex];
                theArray[firstIndex] = elem;
                size++;
                lastIndex++;
            }
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
        if(size==0){
            throw new DequeEmptyException("Deque is empty!");
        }
        else {
            E objectToReturn = theArray[firstIndex];
            theArray[firstIndex] = null;
            firstIndex++;
            size--;
            return objectToReturn;
        }
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
        if(size==0){
            throw new DequeEmptyException("Deque is empty");
        }
        return theArray[firstIndex];
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
        if(size == DEFAULT_CAPACITY) {
            throw new DequeFullException("Deque is full!");
        }
        else {
            size++;
            lastIndex++;
            theArray[lastIndex] = elem;
        }
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
        if (size==0){
            throw new DequeEmptyException("Deque is empty!");
        }
        else {
            E objectToReturn = theArray[lastIndex];
            theArray[lastIndex]=null;
            lastIndex--;
            size--;
            return objectToReturn;
        }
    }

    /**
     *
     * Retunerer det siste elementet i samlingen, men
     * fjerner det ikke.
     *
     * @return Det siste elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E peekLast() throws DequeEmptyException {
        if(size==0){
            throw new DequeEmptyException("Deque is empty!");
        }
        else{
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
        return false;
    }

    /**
     * Retunerer en tabell med alle elementene i samlingen.
     *
     * @param a En tabell med samme type som E[].
     * @return En tabell med alle elementene i samlingen.
     */
    @Override
    public E[] toArray(E[] a) {
        return new E[0];
    }

    /**
     * Fjerner alle elementene fra samlingen.
     */
    @Override
    public void clear() {
        for (int i = firstIndex; i <= lastIndex; i++) {
            theArray[i]=null;
        }
        size=0;
        firstIndex=0;
        lastIndex=0;

    }
}
