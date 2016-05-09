package visitor;

public class Variable implements Expression {
  public final String name;

  public Variable(String name) {
    this.name = name;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
