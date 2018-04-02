package expression;

public class Log10 extends AbstractUnaryOperation {

    public Log10(CommonExpression argument) {
        super(argument);
    }

    private int log(int value) {
        int tmp = 0;
        while (value >= 10) {
            ++tmp;
            value/=10;
        }
        return tmp;
    }

    protected int calc(int value) {
        return log(value);
    }

    protected double calc(double value) {
        return (double) log((int)value);
    }
}
