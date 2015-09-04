package pipeline;

public interface Producer<T> {
     boolean hasMore();
     T produce();
}
