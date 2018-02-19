import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    void size() {
        ArrayDeque testD = new ArrayDeque<String>();
        testD.add("Test1");
        testD.add("Test2");
        testD.add("Test3");
        assertEquals(3, testD.size());
    }

    @Test
    void isEmpty() {
        ArrayDeque testD = new ArrayDeque<String>();
        assertEquals(0, testD.size());
    }

    @Test
    void addFirst() {
        ArrayDeque testD = new ArrayDeque<String>();
        testD.addFirst("hei");
        assertEquals(testD.peekFirst(),"hei");
    }

    @Test
    void pullFirst() {
        ArrayDeque testD = new ArrayDeque<String>();
        testD.addFirst("test1");
        testD.addFirst("test2");
        assertEquals(testD.peekFirst(), "test2");
        testD.removeFirst();
        assertEquals("test1", testD.peekFirst());

    }

    @Test
    void peekFirst() {
        ArrayDeque testD = new ArrayDeque<Integer>();
        testD.addFirst(1);
        testD.addFirst(2);
        assertEquals(2, testD.peekFirst());
    }

    @Test
    void addLast() {
        ArrayDeque testD  = new ArrayDeque<String>();
        testD.addLast(2);
        testD.addLast(3);
        testD.addFirst(1);
        assertEquals(testD.peekLast(), 3);
    }

    @Test
    void pullLast() {
        ArrayDeque testD = new ArrayDeque<String>();
        testD.addFirst(1);
        testD.addFirst(2);
        testD.addFirst(3);
        testD.removeLast();
        assertEquals(2,testD.peekLast());

    }

    @Test
    void peekLast() {

    }

    @Test
    void contains() {
    }

    @Test
    void toArray() {
    }

    @Test
    void clear() {
    }

    @Test
    void printDeque() {
    }

    @Test
    void main() {
    }
}