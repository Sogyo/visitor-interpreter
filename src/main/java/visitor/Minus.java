package visitor;

public class Minus implements Expression {
  public final Expression lhs;
  public final Expression rhs;

  public Minus(Expression left, Expression right) {
    lhs = left;
    rhs = right;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
