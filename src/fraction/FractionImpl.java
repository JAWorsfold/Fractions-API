package fraction;

import java.sql.SQLOutput;
import java.util.Objects;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;
    private int GCD;

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator representing the numerator before being normalized
     * @param denominator representing the demoninator before being normalized
     */
    public FractionImpl(int numerator, int denominator) {
        if (denominator == 0) { throw new ArithmeticException("Divide by zero"); }
        this.numerator = numerator;
        this.denominator = denominator;
        normalizeFraction();
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        if (fraction.length() < 3) {
            numerator = Integer.parseInt(fraction);
            denominator = 1;
        } else {
            String[] f = fraction.split("/");
            numerator = Integer.parseInt(f[0]);
            if (Integer.parseInt(f[1]) == 0) { throw new ArithmeticException("Divide by zero"); }
            else {
                denominator = Integer.parseInt(f[1]);
            }
        }
        normalizeFraction();
    }

    /**
     * @inheritDoc
     */
     @Override
     public int computeGCD() {
        int n = numerator;
        int d = denominator;
        int temp;
        while (d != 0) {
            temp = d;
            d = n % d;
            n = temp;
        }
        return Math.abs(n);
    }

    public int getGCD() {
         return GCD;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void normalizeFraction() {
        GCD = computeGCD();
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator == 0 && denominator > 1) {
            denominator = 1;
        } else {
            numerator = numerator / GCD;
            denominator = denominator / GCD;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(FractionImpl f) {
        int n = (this.numerator*f.denominator + this.denominator*f.numerator);
        int d = this.denominator*f.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(FractionImpl f) {
        int n = (this.numerator*f.denominator - this.denominator*f.numerator);
        int d = this.denominator*f.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(FractionImpl f) {
        int n = this.numerator*f.numerator;
        int d = this.denominator*f.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(FractionImpl f) {
        int n = this.numerator*f.denominator;
        int d = this.denominator*f.numerator;
        return new FractionImpl(n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        if (numerator < 0) {
            return new FractionImpl(Math.abs(numerator), denominator);
        } else {
            return new FractionImpl(numerator, denominator);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FractionImpl fraction = (FractionImpl) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }
}
