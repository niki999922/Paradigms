package expression;

public class Count extends AbstractUnaryOperation {
    public Count(CommonExpression argument) {
        super(argument);
    }

    protected int calc(int value) {
        return Integer.bitCount(value);
    }

    protected double calc(double value) {
        return value;
    }
}
