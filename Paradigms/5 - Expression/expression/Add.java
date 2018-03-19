package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Add extends AbstractOperation {
    Add(Example leftArgument, Example rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) {
        return left + right;
    }

    protected double calc(double left, double right) {
        return left + right;
    }
}