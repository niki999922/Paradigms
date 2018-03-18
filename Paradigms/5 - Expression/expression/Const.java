package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Const implements Example {
    private int value_int;
    private double value_double;

    Const(int value) {
        this.value_int = value;
        this.value_double = value;
    }

    Const(double value) {
        this.value_double = value;
        this.value_double = value;
    }

    public double evaluate(double value) {
        return this.value_double;
    }

    public int evaluate(int value) {
        return this.value_int;
    }
}