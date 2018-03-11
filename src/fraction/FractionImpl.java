package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

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
        this.normalizeFraction();
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
        // Deal with a single number String like "3"
        // Deal with a String fraction like "3/4" - split based on the /
        // Must make the numerator minus... (should this be in normalize?

    }

    /**
     * Compute the <pre>Greatest Common Divisor (GCD)</pre>.
     * For instance, if the instance variables are <pre>(8, 12)</pre>, return the <pre>Integer</pre> <pre>4</pre>.
     *
     * @return GCD
     */
     int computeGCD() {
        int numerator = this.numerator;
        int denominator = this.denominator;
        int temporary;
        while (denominator != 0) {
            temporary = denominator;
            denominator = numerator % denominator;
            numerator = temporary;
        }
        return numerator;
    }

    // Not sure if this is necessary... It's included in the constructors for now
    // Changed my mind --- also need to normalise the numerator as the negative number...
    // Also - zero must be represented as 0/1... i.e. "0", "0/2", 0, 2 etc.
    /**
     * Normalize and return the <pre>Fraction</pre> using the GCD. If the denominator is given as a <pre>negative
     * integer</pre>, make the numerator negative instead. <pre>Zero</pre> should be represented as <pre>0/1</pre>.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     */
    void normalizeFraction() {
        if (this.denominator < 0) {
            this.denominator = +this.denominator;
            this.numerator = -this.numerator;
        }

        //this.numerator = this.numerator / this.computeGCD();
        //this.denominator = this.denominator / this.computeGCD();

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) { return null; }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
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
    public int hashCode() { return super.hashCode(); }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FractionImpl) {
            FractionImpl f = (FractionImpl) obj;
            return this.numerator == f.numerator && this.denominator == f.denominator;
        }
        return false;
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
        return null;
    }
}