public class ArrayDeque<E> implements DequeInterface<E> {

    private E[] theArray;
    private int size;
    private int firstIndex;
    private int lastIndex;
    private int capacity;
    private final int DEFAULT_CAPACITY = 100;


    public ArrayDeque(int arraySize){
        if(arraySize>DEFAULT_CAPACITY){
            arraySize=DEFAULT_CAPACITY;
        }
        this.theArray= (E[])new Object[arraySize];
        this.firstIndex=1;
        this.lastIndex=0;
        this.size=0;
        this.capacity = arraySize-1;
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

    public boolean isEmpty(){
        return this.size==0;
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

            if(size == capacity){
                throw new DequeFullException("Full");
            }
           theArray[firstIndex]=elem;
            firstIndex=(firstIndex+1)%capacity;
            size++;

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
        if(isEmpty()){
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
        System.out.println("Peeking at: " + theArray[firstIndex]);
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
            theArray[lastIndex]=elem;
            lastIndex = (lastIndex-1)%capacity;
            size++;
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
        return (E[])new Object[size];
        //(E[])new Object[arraySize];
    }

    /**
     * Fjerner alle elementene fra samlingen.
     */
    @Override
    public void clear() {
        for (E elem : theArray){
            elem = null;
        }
        size=0;
        firstIndex=0;
        lastIndex=0;

    }

    public void printDeque() throws DequeEmptyException{
    if(size==0){
        throw new DequeEmptyException("Empty!");
    }
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i]);
        }
    }
    public int getLast(){
        return lastIndex;
    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque(10);


        test.addFirst(10);
        test.addFirst(12);
        test.addFirst(123);
        test.addLast("SHWEIN");
        test.addFirst(13);

        test.printDeque();
        System.out.println(test.getLast());

    }
}
