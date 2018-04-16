package expression;

import expression.exceptions.EvaluatingException;

/**
 * @author Nikita Kochetkov M3134
 */

public abstract class AbstractMultyOperation implements CommonExpression {
    CommonExpression leftArgument, rightArgument;

    protected AbstractMultyOperation(CommonExpression leftArgument, CommonExpression rightArgument) {
        this.leftArgument = leftArgument;
        this.rightArgument = rightArgument;
    }

    public int evaluate(int x, int y, int z) throws EvaluatingException {
        return calc(leftArgument.evaluate(x,y,z),rightArgument.evaluate(x,y,z));
    }

    public int evaluate(int value) {
        return calc(leftArgument.evaluate(value), rightArgument.evaluate(value));
    }

    public double evaluate(double value) {
        return calc(leftArgument.evaluate(value), rightArgument.evaluate(value));
    }

    protected abstract int calc(int left, int right);

    protected abstract double calc(double left, double right);
}