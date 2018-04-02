package expression;

public class Pow10 extends AbstractUnaryOperation {

    public Pow10(CommonExpression argument) {
        super(argument);
    }

    private int pow(int value) {
        int tmp = 1;
        while (value > 0) {
            tmp *= 10;
            --value;
        }
        return tmp;
    }

    protected int calc(int value) {
        return pow(value);
    }

    protected double calc(double value) {
        return (double) pow((int)value);
    }
}
