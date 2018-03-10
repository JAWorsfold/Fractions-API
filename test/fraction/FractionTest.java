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
    //private FractionImpl ft1;
    //private FractionImpl ft2;
    //private FractionImpl ft3;

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

    //@Test
    //public void testNormalizeFraction() {
    //    // how will I compare? Any fraction I make will automatically be normalized...
    //    assertEquals(ft1, f1.normalizeFraction());
    //    assertEquals(ft2, f2.normalizeFraction());
    //    assertEquals(ft3, f3.normalizeFraction());
    //}

    @Test
    public void testAdd() {
        // Tests that are expected to succeed or fail
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // test that should throw an ArithmeticException
    }
}