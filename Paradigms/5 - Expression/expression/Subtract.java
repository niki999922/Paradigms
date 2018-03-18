package expression;

public class Subtract extends AbstractOperation{
    public Subtract(Example leftArgument, Example rightArgument) {
        super(leftArgument, rightArgument);
    }
    protected int calc(int value) {
        return leftArgument.evaluate(value) - rightArgument.evaluate(value);
    }
    protected double calc(double value) {
        return leftArgument.evaluate(value) - rightArgument.evaluate(value);
    }
}