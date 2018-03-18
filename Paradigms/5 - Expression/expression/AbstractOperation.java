package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public abstract class AbstractOperation implements Example{
    Example leftArgument, rightArgument;

    AbstractOperation(Example leftArgument, Example rightArgument) {
        this.leftArgument = leftArgument;
        this.rightArgument = rightArgument;
    }

    public int evaluate(int value) {
        return calc(value);
    }

    public double evaluate(double value) {
        return calc(value);
    }

    protected abstract int calc(int value);
    protected abstract double calc(double value);
}