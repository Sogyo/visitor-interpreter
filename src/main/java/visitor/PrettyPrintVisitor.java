package visitor;

import java.util.Map;
import java.util.Stack;

public class PrettyPrintVisitor implements Visitor {
  private Stack<String> stack;
  private Map<String, Expression> context;

  public PrettyPrintVisitor(Map<String, Expression> context) {
    this.context = context;
    stack = new Stack<>();
  }

  public String Prettify() {
    return stack.peek();
  }

  @Override
  public void visit(final Number number) {
    this.stack.push("" + number.number);
  }

  @Override
  public void visit(final Variable variable) {
    Expression e = context.get(variable.name);
    if (e == null) {
      this.stack.push("0");
    } else {
      e.accept(this);
    }
  }

  @Override
  public void visit(final Plus plus) {
    plus.lhs.accept(this);
    String lhs = stack.pop();

    plus.rhs.accept(this);
    String rhs = stack.pop();

    stack.push(String.format("(%s + %s)", lhs, rhs));
  }

  @Override
  public void visit(final Minus minus) {
    minus.lhs.accept(this);
    String lhs = stack.pop();

    minus.rhs.accept(this);
    String rhs = stack.pop();

    stack.push(String.format("(%s - %s)", lhs, rhs));
  }
}
