import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.ExpectedException;


/**
 * @author Peter Cappello
 */
public class StackTest {
    private StackInterface<Integer> instance = new DequeStack<>();

    public StackTest() {}

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Test of isEmpty method of class Stack.
     */
    @Test
    public void testIsEmptyTrue() {
        System.out.println("isEmpty");
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of isEmpty method of class Stack.
     */
    @Test
    public void testIsEmptyFalse() {
        System.out.println("isEmpty");
        instance.push(1);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        instance.push(1);
        assertEquals(new Integer(1), instance.pop());
    }

    /**
     * Test of remove method of class Stack.
     */
    @Test
    public void testPopException() {
        System.out.println("pop");
        exception.expect(EmptyQueueException.class);
        Integer peek = instance.pop();
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        instance.push(-17);
        assertEquals(instance.peek(), new Integer(-17));
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        instance.push(1);
        assertEquals(new Integer(1), instance.peek());
    }


}