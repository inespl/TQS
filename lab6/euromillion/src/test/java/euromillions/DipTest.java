/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    void testConstructorFromBadArrays() {
        // todo: instantiate a dip passing valid or invalid arrays
        // fail("constructor from bad arrays: test not implemented yet");

        // 5 == arrayOfNumbers.length && 2 == arrayOfStarts.length
        assertThrows(IllegalArgumentException.class,  () -> {
            new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1});
        });

        assertThrows(IllegalArgumentException.class,  () -> {
            new Dip(new int[]{10, 20, 30, 40}, new int[]{1, 2});
        });

    }

    @Test
    void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

}
