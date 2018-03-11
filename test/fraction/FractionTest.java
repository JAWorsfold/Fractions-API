package fraction;

        import static org.junit.Assert.*;
        import org.junit.Before;
        import org.junit.Test;

public class FractionTest {

    // complete the tests and add more

    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;
    private Fraction f5;
    private Fraction f6;
    private Fraction f7;
    private Fraction f8;
    private Fraction f9;
    private Fraction f10;


    @Before
    public void setUp() {
        f1 = new FractionImpl(8, 12);
        f2 = new FractionImpl(1,2);
        f3 = new FractionImpl(105, -252);
        f4 = new FractionImpl(-8, 12);
        f5 = new FractionImpl(0, 6);
        f6 = new FractionImpl(0);
        f7 = new FractionImpl("2");
        f8 = new FractionImpl("-3");
        f9 = new FractionImpl("-2/4");

    }

    @Test
    public void testComputeGCD() {
        assertEquals(4, f1.getGCD());
        assertEquals(1, f2.getGCD());
        assertEquals(21, f3.getGCD());
        assertEquals(4, f4.getGCD());
        assertEquals(6, f5.getGCD());
        assertEquals(0, f6.getGCD());
        assertEquals(1, f7.getGCD());
        assertEquals(1, f8.getGCD());
        assertEquals(2, f9.getGCD());
    }

    @Test
    public void testNormalizeFraction() {
        assertEquals(new FractionImpl(2, 3), f1);
        assertEquals(new FractionImpl(1, 2), f2);
        assertEquals(new FractionImpl(-5, 12), f3);
        assertEquals(new FractionImpl(-2, 3), f4);
        assertEquals(new FractionImpl(0, 1), f5);
        assertEquals(new FractionImpl(0, 1), f6);
        assertEquals(new FractionImpl(2, 1), f7);
        assertEquals(new FractionImpl(-3, 1), f8);
        assertEquals(new FractionImpl(-1, 2), f9);
    }

    @Test(expected = NumberFormatException.class)
    public void testNonLegalInteger() {
        Fraction f = new FractionImpl("--");
        Fraction f1 = new FractionImpl("--/12");
    }

    @Test
    public void testAdd() {
        // Tests that are expected to succeed or fail
    }

    @Test
    public void testToString() {
        assertEquals("2/3", f1.toString());
        assertEquals("1/2", f2.toString());
        assertEquals("-5/12", f3.toString());
        assertEquals("-2/3", f4.toString());
        assertEquals("0", f5.toString());
        assertEquals("0", f6.toString());
        assertEquals("2", f7.toString());
        assertEquals("-3", f8.toString());
        assertEquals("-1/2", f9.toString());

    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Fraction f = new FractionImpl(3, 0);
        Fraction f1 = new FractionImpl("-5/0");

        //FractionImpl f = new FractionImpl("3/0");
    }
}