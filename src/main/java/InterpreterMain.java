import interpreter.Expression;
import interpreter.Minus;
import interpreter.Plus;
import interpreter.Variable;

import java.util.HashMap;
import java.util.Map;

public class InterpreterMain {

  public static void main(String[] args) {
    Expression a = new interpreter.Number(42);
    Expression b = new interpreter.Number(5);
    Expression c = new Variable("c");
    Expression plus = new Plus(b, c);
    Expression minus = new Minus(a, plus);

    Map<String, Expression> env = new HashMap<>();
    env.put("c", new interpreter.Number(12));
    System.out.println("c: 12  \t-> " + minus.interpret(env));

    env.put("c", new interpreter.Number(-100));
    System.out.println("c: -100\t-> " + minus.interpret(env));
  }
}
