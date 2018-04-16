package expression;

import expression.exceptions.OverflowException;

public class CheckedSubtract extends AbstractCheckedMultyOperation {
    public CheckedSubtract(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    public void checkArguments(int left, int right) throws OverflowException {
        if (left >= 0 && right < 0 && left - Integer.MAX_VALUE > right) {
            throw new OverflowException("Subtract" + getStringOFArguments(left, right));
        }
        if (left <= 0 && right > 0 && Integer.MIN_VALUE - left > -right) {
            throw new OverflowException("Subtract" + getStringOFArguments(left, right));
        }
    }

    protected int calc(int left, int right) {
        return left - right;
    }
}