package expression;

import expression.exceptions.EvaluatingException;

public abstract class AbstractUnaryOperation implements CommonExpression {
    CommonExpression argument;

    public AbstractUnaryOperation(CommonExpression argument) {
        this.argument = argument;
    }


    protected abstract int calc(int value);

    protected abstract double calc(double value);

    public double evaluate(double x) {
        return calc(argument.evaluate(x));
    }

    public int evaluate(int x) {
        return calc(argument.evaluate(x));
    }

    public int evaluate(int x, int y, int z) throws EvaluatingException {
        return calc(argument.evaluate(x, y, z));
    }
}
