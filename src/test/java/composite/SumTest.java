package composite;

import org.junit.Assert;
import org.junit.Test;

public class SumTest {
  @Test
  public void testTwoPlusTwo() {
    Sum s = new Sum();
    s.add(new Value(1));
    s.add(new Value(5));

    Sum s2 = new Sum();
    s.add(new Value(12));
    s.add(new Value(13));
    s.add(new Value(14));
    s.add(s2);

    Component c = s;
    Assert.assertEquals(45, c.total());
  }
}
