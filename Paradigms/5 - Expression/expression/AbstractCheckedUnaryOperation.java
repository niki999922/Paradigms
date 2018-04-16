package expression;

import expression.exceptions.EvaluatingException;

public abstract class AbstractCheckedUnaryOperation implements CommonExpression {
    private final CommonExpression argument;

    protected String getStringOfArguments(int value) {
        return Integer.toString(value);
    }

    public AbstractCheckedUnaryOperation(CommonExpression argument) {
        this.argument = argument;
    }

    public double evaluate(double x) {
        throw new Error("Bad command");
    }

    public int evaluate(int x) {
        throw new Error("Bad command");
    }

    public int evaluate(int x, int y, int z) throws EvaluatingException {
        int value = argument.evaluate(x, y, z);
        check(value);
        return calc(value);
    }

    protected abstract int calc(int value) throws EvaluatingException;

    public abstract void check(int value) throws EvaluatingException;
}