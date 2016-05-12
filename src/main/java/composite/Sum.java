package composite;

import java.util.ArrayList;
import java.util.List;

public class Sum implements Composite {
  private List<Component> values;

  public Sum() {
    this.values = new ArrayList<>();
  }

  @Override
  public void add(final Component node) {
    this.values.add(node);
  }

  @Override
  public void remove(final Component node) {
    this.values.remove(node);
  }

  @Override
  public int total() {
    int sum = 0;
    for (Component c: this.values) {
      sum += c.total();
    }
    return sum;
  }
}
