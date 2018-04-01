package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Variable implements CommonExpression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public double evaluate(double value) {
        return value;
    }

    public int evaluate(int value) {
        return value;
    }

    public int evaluate(int x, int y, int z)
    {
        if (name.equals("x")) return x;
        if (name.equals("y")) return y;
        if (name.equals("z")) return z;
        return 0;
    }
}