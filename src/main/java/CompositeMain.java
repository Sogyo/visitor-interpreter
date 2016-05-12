import composite.Component;
import composite.Sum;
import composite.Value;

public class CompositeMain {
  public static void main(String[] args) {
    Sum s = new Sum();
    s.add(new Value(1));
    s.add(new Value(5));

    Sum s2 = new Sum();
    s.add(new Value(12));
    s.add(new Value(13));
    s.add(new Value(14));
    s.add(s2);

    Component c = s;

    System.out.println("Sum: " + c.total());
  }
}
