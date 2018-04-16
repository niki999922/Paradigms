import expression.exceptions.*;

public class Test {
    public static void main(String[] args) {
        try  {
            System.out.println(new ExpressionParser().parse("log11").evaluate(1, 1, 1));
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
