package interpreter;

import java.util.Map;

public class Plus implements Expression {
  private Expression leftOperand;
  private Expression rightOperand;

  public Plus(Expression left, Expression right) {
    leftOperand = left;
    rightOperand = right;
  }

  public int interpret(Map<String, Expression> context) {
    return leftOperand.interpret(context) + rightOperand.interpret(context);
  }
}
