package visitor;

import java.util.Map;
import java.util.Stack;

public class CalculatorVisitor implements Visitor {
  private Stack<Integer> stack;
  private Map<String, Expression> context;

  public CalculatorVisitor(Map<String, Expression> context) {
    this.context = context;
    stack = new Stack<>();
  }

  public int Answer() {
    return stack.peek();
  }

  @Override
  public void visit(final Number number) {
    this.stack.push(number.number);
  }

  @Override
  public void visit(final Variable variable) {
    Expression e = context.get(variable.name);
    if (e == null) {
      this.stack.push(0);
    } else {
      e.accept(this);
    }
  }

  @Override
  public void visit(final Plus plus) {
    plus.lhs.accept(this);
    int lhs = stack.pop();

    plus.rhs.accept(this);
    int rhs = stack.pop();

    stack.push(lhs + rhs);
  }

  @Override
  public void visit(final Minus minus) {
    minus.lhs.accept(this);
    int lhs = stack.pop();

    minus.rhs.accept(this);
    int rhs = stack.pop();

    stack.push(lhs - rhs);
  }
}
