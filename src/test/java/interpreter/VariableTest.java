package interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class VariableTest {
  private Map<String, Expression> env;

  @Before
  public void before() {
    this.env = new HashMap<>();
  }

  @Test
  public void testExistingVariable() {
    env.put("foo", new Number(1));
    Assert.assertEquals(1, new Variable("foo").interpret(env));
  }

  @Test
  public void testNonExistingVariable() {
    Assert.assertEquals(0, new Variable("foo").interpret(env));
  }
}
