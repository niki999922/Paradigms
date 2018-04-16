package expression;

import expression.exceptions.OverflowException;

public class CheckedAdd extends AbstractCheckedMultyOperation {
    public CheckedAdd(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    public void checkArguments(int left, int right) throws OverflowException {
        if (left > 0 && Integer.MAX_VALUE - left < right) {
            throw new OverflowException("Add" + getStringOFArguments(left, right));
        }
        if (left < 0 && Integer.MIN_VALUE - left > right) {
            throw new OverflowException("Add" + getStringOFArguments(left, right));
        }
    }

    protected int calc(int left, int right) {
        return left + right;
    }
}