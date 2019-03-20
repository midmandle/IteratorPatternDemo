public interface DemoExternalIterator<T> {
    void next();
    boolean isDone();

    T currentItem();
}
