package expression;

import expression.exceptions.OverflowException;

public class CheckedMultiply extends AbstractCheckedMultyOperation {
    public CheckedMultiply(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    public void checkArguments(int left, int right) throws OverflowException {
        if (left > 0 && right > 0 && Integer.MAX_VALUE / left < right) {
            throw new OverflowException("Multiply" + getStringOFArguments(left, right));
        } else if (left > 0 && right < 0 && Integer.MIN_VALUE / left > right) {
            throw new OverflowException("Multiply" + getStringOFArguments(left, right));
        } else if (left < 0 && right > 0 && Integer.MIN_VALUE / right > left) {
            throw new OverflowException("Multiply" + getStringOFArguments(left, right));
        } else if (left < 0 && right < 0 && Integer.MAX_VALUE / left > right) {
            throw new OverflowException("Multiply" + getStringOFArguments(left, right));
        }
    }

    protected int calc(int left, int right) {
        return left * right;
    }
}
