package visitor;

public class Number implements Expression {
  public final int number;

  public Number(int number) {
    this.number = number;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
