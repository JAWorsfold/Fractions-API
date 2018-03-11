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
    private FractionImpl f4;
    private FractionImpl f5;
    private FractionImpl ft1;
    private FractionImpl ft2;
    private FractionImpl ft3;
    private FractionImpl ft4;
    private FractionImpl ft5;


    @Before
    public void setUp() {
        f1 = new FractionImpl(8, 12);
        f2 = new FractionImpl(1,2);
        f3 = new FractionImpl(105, 252);
        f4 = new FractionImpl(-8, 12);
        f5 = new FractionImpl(0, 6);
        ft1 = new FractionImpl(8, 12);
        ft2 = new FractionImpl(1,2);
        ft3 = new FractionImpl(105, 252);
        ft4 = new FractionImpl(-8, 12);
        ft5 = new FractionImpl(0, 1);
    }


    @Test
    public void testComputeGCD() {
        assertEquals(4, f1.computeGCD());
        assertEquals(1, f2.computeGCD());
        assertEquals(21, f3.computeGCD());
        assertEquals(4, f4.computeGCD());
    }

    @Test
    public void testNormalizeFraction() {
        assertEquals(f1.numerator, f1.normalizeFraction());
        assertEquals(ft2, f2.normalizeFraction());
        assertEquals(ft3, f3.normalizeFraction());
    }

    @Test
    public void testAdd() {
        // Tests that are expected to succeed or fail
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        FractionImpl f = new FractionImpl(3, 0);
        //FractionImpl f = new FractionImpl("3/0");
        // test that should throw an ArithmeticException
    }
}