package visitor;

public interface Visitor {
  void visit(Number number);
  void visit(Variable variable);
  void visit(Plus plus);
  void visit(Minus minus);
}
