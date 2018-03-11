package fraction;

        import static org.junit.Assert.*;
        import org.junit.Before;
        import org.junit.Test;

public class FractionTest {

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
        assertEquals(4, ((FractionImpl)f6).computeGCD(8, 12));
        assertEquals(1, ((FractionImpl)f6).computeGCD(1, 2));
        assertEquals(21, ((FractionImpl)f6).computeGCD(105, -252));
        assertEquals(4, ((FractionImpl)f6).computeGCD(-8, 12));
        assertEquals(6, ((FractionImpl)f6).computeGCD(0, 6));
        assertEquals(1, ((FractionImpl)f6).computeGCD(0, 1));
        assertEquals(1, ((FractionImpl)f6).computeGCD(2, 1));
        assertEquals(1, ((FractionImpl)f6).computeGCD(-3, 1));
        assertEquals(2, ((FractionImpl)f6).computeGCD(-2, 4));
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

    @Test
    public void testAdd() {
        assertEquals(new FractionImpl(7, 6), f1.add(f2));
        assertEquals(new FractionImpl(1, 6), f1.add(f9));
        assertEquals(new FractionImpl(1, 12), f2.add(f3));
        assertEquals(new FractionImpl(19, 12), f3.add(f7));
        assertEquals(new FractionImpl(-11, 3), f4.add(f8));
    }

    @Test
    public void testSubtract() {
        assertEquals(new FractionImpl(1, 6), f1.subtract(f2));
        assertEquals(new FractionImpl(7, 6), f1.subtract(f9));
        assertEquals(new FractionImpl(11, 12), f2.subtract(f3));
        assertEquals(new FractionImpl(-29, 12), f3.subtract(f7));
        assertEquals(new FractionImpl(7, 3), f4.subtract(f8));
    }

    @Test
    public void testMultiply() {
        assertEquals(new FractionImpl(1, 3), f1.multiply(f2));
        assertEquals(new FractionImpl(-1, 3), f1.multiply(f9));
        assertEquals(new FractionImpl(-5, 24), f2.multiply(f3));
        assertEquals(new FractionImpl(-5, 6), f3.multiply(f7));
        assertEquals(new FractionImpl(2, 1), f4.multiply(f8));
    }

    @Test
    public void testDivide() {
        assertEquals(new FractionImpl(4, 3), f1.divide(f2));
        assertEquals(new FractionImpl(-4, 3), f1.divide(f9));
        assertEquals(new FractionImpl(-6, 5), f2.divide(f3));
        assertEquals(new FractionImpl(-5, 24), f3.divide(f7));
        assertEquals(new FractionImpl(2, 9), f4.divide(f8));
    }

    @Test
    public void testAbs() {
        assertEquals(new FractionImpl(8, 12), f1.abs());
        assertEquals(new FractionImpl(1, 2), f2.abs());
        assertEquals(new FractionImpl(105, 252), f3.abs());
        assertEquals(new FractionImpl(8, 12), f4.abs());
        assertEquals(new FractionImpl(0, 1), f5.abs());
        assertEquals(new FractionImpl(0, 1), f6.abs());
        assertEquals(new FractionImpl(2, 1), f7.abs());
        assertEquals(new FractionImpl(3, 1), f8.abs());
        assertEquals(new FractionImpl(1, 2), f9.abs());
    }

    @Test
    public void testNegate() {
        assertEquals(new FractionImpl(-8, 12), f1.negate());
        assertEquals(new FractionImpl(-1, 2), f2.negate());
        assertEquals(new FractionImpl(105, 252), f3.negate());
        assertEquals(new FractionImpl(8, 12), f4.negate());
        assertEquals(new FractionImpl(-0, 1), f5.negate());
        assertEquals(new FractionImpl(-0, 1), f6.negate());
        assertEquals(new FractionImpl(-2, 1), f7.negate());
        assertEquals(new FractionImpl(3, 1), f8.negate());
        assertEquals(new FractionImpl(1, 2), f9.negate());
    }

    @Test
    public void testInverse() {
        assertEquals(new FractionImpl(12, 8), f1.inverse());
        assertEquals(new FractionImpl(2, 1), f2.inverse());
        assertEquals(new FractionImpl(-252, 105), f3.inverse());
        assertEquals(new FractionImpl(-12, 8), f4.inverse());
        assertEquals(new FractionImpl(1, 2), f7.inverse());
        assertEquals(new FractionImpl(-1, 3), f8.inverse());
        assertEquals(new FractionImpl(-2, 1), f9.inverse());
    }

    @Test
    public void testCompareTo() {
        assertEquals(1, f1.compareTo(f2));
        assertEquals(1, f1.compareTo(f9));
        assertEquals(1, f2.compareTo(f3));
        assertEquals(-1, f3.compareTo(f7));
        assertEquals(1, f4.compareTo(f8));
        assertEquals(0, f5.compareTo(f6));
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
        f5.inverse();
        f6.inverse();
    }

    @Test(expected = NumberFormatException.class)
    public void testNonLegalInteger() {
        Fraction f = new FractionImpl("--");
        Fraction f1 = new FractionImpl("--/12");
    }
}