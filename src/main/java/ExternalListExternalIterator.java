public class ExternalListExternalIterator implements DemoExternalIterator {

    private ListAggregate listAggregate;
    private Integer index = 0;
    private Object currentItem;

    public ExternalListExternalIterator(ListAggregate listAggregate) {
        this.listAggregate = listAggregate;
    }

    @Override
    public void next() {
        currentItem = listAggregate.getItem(index);
        index += 1;
    }

    @Override
    public boolean isDone() {
        return index == ListAggregate.size();
    }

    @Override
    public Object currentItem() {
        return currentItem;
    }
}
