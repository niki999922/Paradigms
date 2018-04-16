package expression;

public class Negate extends AbstractUnaryOperation {
    public Negate(CommonExpression argument) {
        super(argument);
    }

    protected int calc(int value) {
        return ~value;
    }

    protected double calc(double value) {
        return value;
    }
}


