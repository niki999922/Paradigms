package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Add extends AbstractOperation {
    Add(Example leftArgument, Example rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int value) {
        return leftArgument.evaluate(value) + rightArgument.evaluate(value);
    }

    protected double calc(double value) {
        return leftArgument.evaluate(value) + rightArgument.evaluate(value);
    }
}