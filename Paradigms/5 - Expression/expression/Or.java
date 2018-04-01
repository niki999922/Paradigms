package expression;

public class Or extends AbstractMultyOperation {
    public Or(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) {
        return left | right;
    }

    protected double calc(double left, double right) {
        return (double)((int)left | (int)right);
    }
}

