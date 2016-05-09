package visitor;

public interface Expression {
  void accept(Visitor visitor);
}
