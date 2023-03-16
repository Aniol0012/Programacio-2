package Tema_2.src;

public class Problem2_7 {

    private int numerator;
    private int denominator;

    public Problem2_7(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Problem2_7 add(Problem2_7 other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Problem2_7(newNumerator, newDenominator);
    }

    public static Problem2_7 add(Problem2_7 r1, Problem2_7 r2) {
        return r1.add(r2);
    }

    public Problem2_7 subtract(Problem2_7 other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Problem2_7(newNumerator, newDenominator);
    }

    public static Problem2_7 subtract(Problem2_7 r1, Problem2_7 r2) {
        return r1.subtract(r2);
    }

    public Problem2_7 multiply(Problem2_7 other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Problem2_7(newNumerator, newDenominator);
    }

    public static Problem2_7 multiply(Problem2_7 r1, Problem2_7 r2) {
        return r1.multiply(r2);
    }

    public Problem2_7 divide(Problem2_7 other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Problem2_7(newNumerator, newDenominator);
    }

    public static Problem2_7 divide(Problem2_7 r1, Problem2_7 r2) {
        return r1.divide(r2);
    }

    public String toString() {
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        }
        return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
    }

    // Some tests
    public static void main(String[] args) {
        Problem2_7 r1 = new Problem2_7(4, -8);
        Problem2_7 r2 = new Problem2_7(1, 2);
        System.out.println("r1 = " + r1.toString());
        System.out.println("r2 = " + r2.toString());
        System.out.println("r1 + r2 = " + r1.add(r2).toString());
        System.out.println("r1 - r2 = " + r1.subtract(r2).toString());
        System.out.println("r1 * r2 = " + r1.multiply(r2).toString());
        System.out.println("r1 / r2 = " + r1.divide(r2).toString());
        System.out.println("r1 + r2 (static) = " + Problem2_7.add(r1, r2).toString());
        System.out.println("r1 - r2 (static) = " + Problem2_7.subtract(r1, r2).toString());
    }
}