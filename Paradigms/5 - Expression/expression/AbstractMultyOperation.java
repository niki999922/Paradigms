package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public abstract class AbstractMultyOperation extends AbstractOperation {
    CommonExpression leftArgument, rightArgument;

    AbstractMultyOperation(CommonExpression leftArgument, CommonExpression rightArgument) {
        this.leftArgument = leftArgument;
        this.rightArgument = rightArgument;
    }

    public int evaluate(int x, int y, int z){
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