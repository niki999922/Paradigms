package expression;

import expression.exceptions.EvaluatingException;
import expression.exceptions.IllegalOperationArgumentException;
import expression.exceptions.OverflowException;

public class CheckedPow extends AbstractCheckedMultyOperation {
    public CheckedPow(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) throws EvaluatingException {
        int answer = 1;
        try {
            while (right > 0) {
                if (right % 2 == 1) {
                    answer = new CheckedMultiply(new Const(answer), new Const(left)).evaluate(0,0,0);
                    right--;
                } else {
                    left = new CheckedMultiply(new Const(left), new Const(left)).evaluate(0,0,0);
                    right = right >> 1;
                }
            }
        } catch (OverflowException e) {
            throw new OverflowException("Multiply" + getStringOFArguments(left, right));
        }
        return answer;
    }

    public void checkArguments(int left, int right) throws EvaluatingException {
        if (right < 0 || (left == 0 && right == 0)) {
            throw new IllegalOperationArgumentException("Pow" + getStringOFArguments(left, right));
        }
    }

}