package expression;

public class Xor extends AbstractMultyOperation {
    public Xor(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) {
        return left ^ right;
    }

    protected double calc(double left, double right) {
        return (double)((int)left ^ (int)right);
    }
}


