package expression;

public class Log extends AbstractMultyOperation {

    public Log(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) {
        return log(left, right);
    }

    protected double calc(double left, double right) {
        return (double) log((int) left, (int) right);
    }
    //left !=0 ловим exception
    private int log(int left, int right) {
        int tmp = 0;
        while (left > 1) {
            ++tmp;
            left /= right;
        }
        return tmp;
    }
}
