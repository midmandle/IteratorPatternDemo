public interface Aggregate {
    DemoExternalIterator getExternalIterator();

    InternalListIterator getInternalIterator();
}
