package expression;

import expression.exceptions.OverflowException;

public class CheckedNegate extends AbstractCheckedUnaryOperation {
    public CheckedNegate(CommonExpression argument) {
        super(argument);
    }

    public void check(int value) throws OverflowException {
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException("Negate" + getStringOfArguments(value));
        }
    }

    protected int calc(int value) {
        return -value;
    }
}