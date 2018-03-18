package expression;

public class Variable implements Example {
    private String name;

    Variable(String name) {
        this.name = name;
    }

    public double evaluate(double value) {
        return value;
    }

    public int evaluate(int value) {
        return value;
    }
}