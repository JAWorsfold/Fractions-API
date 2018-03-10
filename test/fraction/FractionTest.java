package fraction;

        import fraction.FractionImpl;
        import fraction.Fraction;
        import static org.junit.Assert.*;
        import org.junit.Before;
        import org.junit.Test;

public class FractionTest {

    // complete the tests and add more
    private FractionImpl f1;
    private FractionImpl f2;
    private FractionImpl f3;



    @Before
    public void setUp() {
        f1 = new FractionImpl(8, 12);
        f2 = new FractionImpl(1,2);
        f2 = new FractionImpl(105, 252);
    }


    @Test
    public void testComputeGCD() {
        assertEquals(4, f1.computeGCD());
        assertEquals(21, f2.computeGCD());
        assertEquals(1, f3.computeGCD());
    }

    @Test
    public void testAdd() {
        // Tests that are expected to succeed or fail
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // test that should throw an ArithmeticException
    }
}