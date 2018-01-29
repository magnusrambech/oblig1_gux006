/**
 * En samling som tillater innsetting og fjerning fra begge
 * sider av samlingen.
 */
public interface DequeInterface<E> {
    /**
     * Retunerer hvor mange elementer samlingen inneholder.
     *
     * @return Størrelsen på samlingen.
     */
    int size();
    /**
     * Legger til et element på begynnelsen av samlingen.
     *
     * @param elem Elementet som skal legges til.
     * @throws DequeFullException når det ikke er plass til
     * elementet.
     */
    void addFirst(E elem) throws DequeFullException;
    /**
     * Fjerner det første elementet fra samlingen og
     * returnerer det.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    E pullFirst() throws DequeEmptyException;
    /**
     * Retunerer det første elementet fra samlingen, men
     * fjerner det ikke.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    E peekFirst() throws DequeEmptyException;