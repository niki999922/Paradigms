package expression;

public class Not extends AbstractUnaryOperation {
    public Not(CommonExpression argument) {
        super(argument);
    }

    protected int calc(int value) {
        return ~value;
    }

    protected double calc(double value) {
        return value;
    }
}


