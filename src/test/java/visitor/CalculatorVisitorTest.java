package visitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CalculatorVisitorTest {
  private Map<String, visitor.Expression> env;

  @Before
  public void before() {
    this.env = new HashMap<>();
  }

  @Test
  public void testTwoPlusTwo() {
    Expression plus = new Plus(new Number(2), new Number(2));
    CalculatorVisitor calc = new CalculatorVisitor(env);
    plus.accept(calc);
    Assert.assertEquals(4, calc.Answer());
  }

  @Test
  public void testOneMinus_TwoPlusThree() {
    Expression a = new visitor.Number(1);
    Expression b = new visitor.Number(2);
    Expression c = new Variable("c");
    Expression plus = new Plus(b, c);
    Expression minus = new Minus(a, plus);

    env.put("c", new visitor.Number(3));
    CalculatorVisitor calc = new CalculatorVisitor(env);
    minus.accept(calc);
    Assert.assertEquals(-4, calc.Answer());
  }
}
