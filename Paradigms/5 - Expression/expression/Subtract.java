package expression;

/**
 * @author Nikita Kochetkov M3134
 */

public class Subtract extends AbstractMultyOperation {
    public Subtract(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }
    protected int calc(int left,int right) {
        return left - right;
    }
    protected double calc(double left,double right) {
        return left - right;
    }
}