import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InternalListIterator implements DemoInternalIterator {

    private final ListAggregate listAggregate;

    public InternalListIterator(ListAggregate listAggregate) {
        this.listAggregate = listAggregate;
    }

    @Override
    public ListAggregate iterate(Function<String, String> operation) {
        List<String> processedItems = new ArrayList<>();
        for (String item :
                listAggregate.toList()) {
            processedItems.add(operation.apply(item));
        }
        return new ListAggregate(processedItems);
    }
}
