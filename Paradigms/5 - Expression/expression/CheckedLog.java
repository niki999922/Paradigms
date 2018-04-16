package expression;

import expression.exceptions.EvaluatingException;
import expression.exceptions.IllegalOperationArgumentException;
import expression.exceptions.OverflowException;

public class CheckedLog extends AbstractCheckedMultyOperation {
    public CheckedLog(CommonExpression leftArgument, CommonExpression rightArgument) {
        super(leftArgument, rightArgument);
    }

    protected int calc(int left, int right) throws EvaluatingException{
        int answer = 0;
        try {
            while (left / right != 0) {
                answer++;
                left = new CheckedDivide(new Const(left), new Const(right)).evaluate(0,0,0);
            }
        } catch (EvaluatingException e) {
            throw new OverflowException("Log" + getStringOFArguments(left, right));
        }
        return answer;
    }

    public void checkArguments(int left, int right) throws IllegalOperationArgumentException {
        if (right == 1 || right <= 0 || left <= 0) {
            throw new IllegalOperationArgumentException("Log" + getStringOFArguments(left, right));
        }
    }
}