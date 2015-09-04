package pipeline;

public interface Consumer<T> {
    void consume(final T data);
}
