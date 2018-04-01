package expression;

public class And extends AbstractMultyOperation {
    public And(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) {
        return left & right;
    }

    protected double calc(double left, double right) {
        return (double)((int)left & (int)right);
    }

}
