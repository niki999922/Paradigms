package expression.exceptions;

import expression.TripleExpression;

public class CheckedNegate implements TripleExpression {
    @Override
    public int evaluate(int x, int y, int z) {
        return 0;
    }
}
