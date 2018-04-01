package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {
    private String expression;
    private int pos;
    private Token inTime;
    private int constant;
    private String variable;
    private boolean overflow = false;

    public CommonExpression parse(String expression) {
        overflow = false;
        this.expression = expression;
        pos = 0;
        return bitwiseOr();
    }

    private enum Token {
        VAR, NUMBER, PLUS, MINUS,
        MUL, DIV, LB, RB, AND, XOR, OR, NOT, COUNT
    }

    private char getChar() {
        if (pos < expression.length()) {
            return expression.charAt(pos++);
        }
        return 'E'; //End of expression
    }

    private void getToken() {
        while (Character.isWhitespace(getChar())) {}
        pos--;
        char ch = getChar();
        if (Character.isDigit(ch)) {
            StringBuilder str = new StringBuilder();
            str.append(ch);
            while (Character.isDigit(ch = getChar())) {
                str.append(ch);
            }
            pos--;
            try {
                constant = Integer.parseInt(str.toString());
            } catch (NumberFormatException e) {
                overflow = true;
                constant = -1;
            }
            inTime = Token.NUMBER;
        } else {
            switch (ch) {
                case '-':
                    inTime = Token.MINUS;
                    break;
                case '+':
                    inTime = Token.PLUS;
                    break;
                case '*':
                    inTime = Token.MUL;
                    break;
                case '/':
                    inTime = Token.DIV;
                    break;
                case '(':
                    inTime = Token.LB;
                    break;
                case ')':
                    inTime = Token.RB;
                    break;
                case '&':
                    inTime = Token.AND;
                    break;
                case '^':
                    inTime = Token.XOR;
                    break;
                case '|':
                    inTime = Token.OR;
                    break;
                case '~':
                    inTime = Token.NOT;
                    break;
                case 'c':
                    StringBuilder str = new StringBuilder();
                    str.append(ch);
                    while (ch != 'E' && Character.isLetter(ch = getChar())) {
                        str.append(ch);
                    }
                    pos--;
                    inTime = Token.COUNT;
                    break;
                case 'x':
                case 'y':
                case 'z':
                    inTime = Token.VAR;
                    variable = Character.toString(ch);
                    break;
            }
        }

    }

    private CommonExpression primitive() {
        getToken();
        CommonExpression ans = new Const(1);
        switch (inTime) {
            case VAR:
                ans = new Variable(variable);
                getToken();
                break;
            case NUMBER:
                ans = new Const(constant);
                getToken();
                break;
            case MINUS:
                ans = new Subtract(new Const(0), primitive());
                if (overflow) {
                        ans = new Const(-2147483648);
                }
                overflow = false;
                break;
            case NOT:
                ans = new Not(primitive());
                break;
            case COUNT:
                ans = new Count(primitive());
                break;
            case LB:
                ans = bitwiseOr();
                getToken();
                break;
        }
        return ans;
    }

    private CommonExpression divMul() {
        CommonExpression newCur = primitive();
        while (true) {
            switch (inTime) {
                case DIV:
                    newCur = new Divide(newCur, primitive());
                    break;
                case MUL:
                    newCur = new Multiply(newCur, primitive());
                    break;
                default:
                    return newCur;
            }
        }
    }

    private CommonExpression subAdd() {
        CommonExpression newCur = divMul();
        while (true) {
            switch (inTime) {
                case MINUS:
                    newCur = new Subtract(newCur, divMul());
                    break;
                case PLUS:
                    newCur = new Add(newCur, divMul());
                    break;
                default:
                    return newCur;
            }
        }
    }

    private CommonExpression bitwiseAnd() {
        CommonExpression newCur = subAdd();
        while (true) {
            switch (inTime) {
                case AND:
                    newCur = new And(newCur, subAdd());
                    break;
                default:
                    return newCur;
            }
        }
    }

    private CommonExpression bitwiseXor() {
        CommonExpression newCur = bitwiseAnd();
        while (true) {
            switch (inTime) {
                case XOR:
                    newCur = new Xor(newCur, bitwiseAnd());
                    break;
                default:
                    return newCur;
            }
        }
    }

    private CommonExpression bitwiseOr() {
        CommonExpression newCur = bitwiseXor();
        while (true) {
            switch (inTime) {
                case OR:
                    newCur = new Or(newCur, bitwiseXor());
                    break;
                default:
                    return newCur;
            }
        }
    }

}
