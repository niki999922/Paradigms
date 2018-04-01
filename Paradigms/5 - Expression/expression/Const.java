package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Const implements CommonExpression {
    private double var;

    public Const(int value) {
        this.var = value;
    }

    public Const(double value) {
        this.var = value;
    }

    public double evaluate(double value) {
        return this.var;
    }

    public int evaluate(int value) {
        return (int) this.var;
    }

    public int evaluate(int x, int y, int z) {
        return (int) this.var;
    }
}