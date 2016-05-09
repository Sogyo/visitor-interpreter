package visitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PrettyPrintVisitorTest {
  private Map<String, Expression> env;

  @Before
  public void before() {
    this.env = new HashMap<>();
  }

  @Test
  public void testTwoPlusTwo() {
    Expression plus = new Plus(new Number(2), new Number(2));
    PrettyPrintVisitor calc = new PrettyPrintVisitor(env);
    plus.accept(calc);
    Assert.assertEquals("(2 + 2)", calc.Prettify());
  }

  @Test
  public void testOneMinus_TwoPlusThree() {
    Expression a = new Number(1);
    Expression b = new Number(2);
    Expression c = new Variable("c");
    Expression plus = new Plus(b, c);
    Expression minus = new Minus(a, plus);

    env.put("c", new Number(3));
    PrettyPrintVisitor pp = new PrettyPrintVisitor(env);
    minus.accept(pp);
    Assert.assertEquals("(1 - (2 + 3))", pp.Prettify());
  }
}
