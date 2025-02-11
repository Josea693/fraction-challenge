public class Fraction {
    
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        setNumerator(num);
        setDenominator(denom);
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int number) {
        this(number, 1);
    }

    // --------------------------------------------- gets and sets
    public void setNumerator(int num) {
        numerator = num;
    }
    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denom) {
        if (denom == 0) {
            denom = 1;
        }
        denominator = denom;
    }
    public int getDenominator() {
        return denominator;
    }

    // ---------------------------------------------- public methods
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

    public double toDecimal() {
        return (double) getNumerator() / getDenominator();
    }

    // 1/4 + 2/3
    // 2/5 + 4
    public Fraction add(Fraction fractionToAdd) {
        int a, b, c, d;
        Fraction sum;

        a = getNumerator();
        b = getDenominator();
        c = fractionToAdd.getNumerator();
        d = fractionToAdd.getDenominator();

        int newNumerator = (a * d) + (c * b);
        int newDenominator = b * d;

        sum = new Fraction(newNumerator, newDenominator);
        return sum.simplify();
    }

    public Fraction add(int number) {
        Fraction myFraction = new Fraction(number, 1);
        Fraction sum = add(myFraction);
        return sum;
    }

    public Fraction simplify (){
        int a = getNumerator();
        int b = getDenominator(); 
        Fraction simplification = null;
        for (int i=a; i>1; i--){
            if (a % i == 0 && b % i == 0){
                a = a / i;
                b = b / i;
                simplification = new Fraction (a, b);
                break;
            }
        }
        if (simplification == null);{
            simplification = new Fraction(a, b);
        }
        return simplification;
        
    }

}