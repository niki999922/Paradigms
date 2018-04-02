package expression;

public class Pow extends AbstractMultyOperation {

    public Pow(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    private int pow(int left, int right) {
        int tmp = 1;
        while (right > 0) {
            tmp *= left;
            --right;
        }
        return tmp;
    }

    protected int calc(int left, int right) {
        return pow(left, right);
    }

    protected double calc(double left, double right) {
        return (double) pow((int) left, (int) right);
    }
}
