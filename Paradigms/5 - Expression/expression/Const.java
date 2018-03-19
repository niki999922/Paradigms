package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Const implements Example {
    private double var;

    Const(int value) {
        this.var = value;
    }

    Const(double value) {
        this.var = value;
    }

    public double evaluate(double value) {
        return this.var;
    }

    public int evaluate(int value) {
        return (int) this.var;
    }
}