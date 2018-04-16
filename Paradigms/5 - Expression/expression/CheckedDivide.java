package expression;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;

public class CheckedDivide extends AbstractCheckedMultyOperation {
    public CheckedDivide(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    public void checkArguments(int left, int right) throws DivisionByZeroException, OverflowException {
        if (right == 0) {
            throw new DivisionByZeroException("Divide" + getStringOFArguments(left, right));
        } else if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException("Divide" + getStringOFArguments(left, right));
        }
    }

    protected int calc(int left, int right) {
        return left / right;
    }
}