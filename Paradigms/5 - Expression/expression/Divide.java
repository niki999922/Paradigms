package expression;

public class Divide extends AbstractOperation {
    Divide(Example leftArgument, Example rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected double calc(double value) {
        return leftArgument.evaluate(value) / rightArgument.evaluate(value);
    }

    protected int calc(int value) {
        return leftArgument.evaluate(value) / rightArgument.evaluate(value);
    }
}
