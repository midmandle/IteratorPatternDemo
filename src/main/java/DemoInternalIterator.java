import java.util.function.Function;

public interface DemoInternalIterator {
    ListAggregate iterate(Function<String, String> operation);

}
