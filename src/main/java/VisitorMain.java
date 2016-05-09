import visitor.*;

import java.util.HashMap;
import java.util.Map;

public class VisitorMain {

  public static void main(String[] args) {
    Expression a = new visitor.Number(42);
    Expression b = new visitor.Number(5);
    Expression c = new Variable("c");
    Expression plus = new Plus(b, c);
    Expression minus = new Minus(a, plus);

    Map<String, Expression> env = new HashMap<>();
    env.put("c", new Plus(new visitor.Number(6), new visitor.Number(5)));
    CalculatorVisitor calc = new CalculatorVisitor(env);
    minus.accept(calc);
    System.out.println("The sum is = " + calc.Answer());
  }
}
