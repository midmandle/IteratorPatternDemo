import java.util.ArrayList;
import java.util.List;

public class ListAggregate implements Aggregate {
    private static List<String> list = new ArrayList<>();

    public ListAggregate(List<String> list) {
        this.list = list;
    }

    @Override
    public ExternalListExternalIterator getExternalIterator() {
        return new ExternalListExternalIterator(this);
    }

    @Override
    public InternalListIterator getInternalIterator() {
        return new InternalListIterator(this);
    }

    public static Integer size() {
        return list.size();
    }

    public Object getItem(Integer index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public List<String> toList() {
        return list;
    }
}
