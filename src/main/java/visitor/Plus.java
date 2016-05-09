package visitor;

public class Plus implements Expression {
  public final Expression lhs;
  public final Expression rhs;

  public Plus(Expression left, Expression right) {
    lhs = left;
    rhs = right;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
