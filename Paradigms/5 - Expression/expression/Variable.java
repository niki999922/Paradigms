package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Variable implements CommonExpression {
    private char name;

    public Variable(String name) {
        this.name = name.charAt(0);
    }

    public Variable(char name) {
        this.name = name;
    }

    public double evaluate(double value) {
        return value;
    }

    public int evaluate(int value) {
        return value;
    }

    public int evaluate(int x, int y, int z) {
        if (name == 'x') return x;
        if (name == 'y') return y;
        if (name == 'z') return z;
        return 0;
    }
}