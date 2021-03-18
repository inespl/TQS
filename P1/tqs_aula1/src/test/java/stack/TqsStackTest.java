package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest<T> {

    ITqsStack stack = new ITqsStack();
    ITqsStack stack3elems = new ITqsStack();
    ITqsStack boundStack = new ITqsStack(3);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stack3elems.push("One");
        stack3elems.push("Two");
        stack3elems.push("Three");

        boundStack.push("One");
        boundStack.push("Two");
        boundStack.push("Three");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testPush() {
        stack3elems.push("Four");
        assertEquals( 4, stack3elems.size() );
    }

    // a)
    @DisplayName("A stack is empty on construction")
    @Test
    void testIsEmpty() {
        assertTrue( stack.isEmpty() );
    }

    // b)
    @DisplayName("A stack has 0 on construction")
    @Test
    void testSizeEmpty() {
        assertEquals( 0, stack.size() );
    }

    // c)
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    void testSizeAfterPushes() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals( 3, stack.size() );
    }

    // d)
    @DisplayName("If one pushes x then pops, the value popped is x")
    @Test
    void testPop() {
        stack3elems.push("Four");
        assertEquals( "Four", stack3elems.pop() );
        assertEquals( 3, stack3elems.size() );
    }

    // e)
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    void testPeek() {
        stack3elems.push("Four");
        assertEquals( "Four", stack3elems.peek() );
        assertEquals( 4, stack3elems.size() );
    }

    // f)
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    void testSizeAfterPops() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals( 0, stack.size() );
    }

    // g)
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException [You should test for the Exception occurrence]")
    @Test
    void testPopEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> { stack.pop(); });
    }

    // h)
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void testPeekEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> { stack.peek(); });
    }

    // i)
    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    @Test
    void testPushFullStack() {
        assertThrows(IllegalStateException.class, () -> { boundStack.push("Four"); });
    }
}
