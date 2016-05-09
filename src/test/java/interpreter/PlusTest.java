package interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PlusTest {
  private Map<String, Expression> env;

  @Before
  public void before() {
    this.env = new HashMap<>();
  }

  @Test
  public void testTwoPlusTwo() {
    Expression plus = new Plus(new Number(2), new Number(2));
    Assert.assertEquals(4, plus.interpret(env));
  }

  @Test
  public void testTwoPlusMinusFifty() {
    env.put("abc", new Number(-50));
    Expression plus = new Plus(new Number(2), new Variable("abc"));
    Assert.assertEquals(-48, plus.interpret(env));
  }
}
