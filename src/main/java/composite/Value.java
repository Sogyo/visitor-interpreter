package composite;

public class Value implements Component {
  private final int value;

  public Value(int value) {
    this.value = value;
  }

  @Override
  public int total() {
    return this.value;
  }
}
