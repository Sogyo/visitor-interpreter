package composite;

public interface Composite extends Component {
  void add(Component node);
  void remove(Component node);
}
