package interpreter;

import java.util.Map;

public class Variable implements Expression {
  private String name;

  public Variable(String name) {
    this.name = name;
  }

  public int interpret(Map<String, Expression> context) {
    Expression e = context.get(name);
    if (e == null) {
      return 0;
    } else {
      return context.get(name).interpret(context);
    }
  }
}
