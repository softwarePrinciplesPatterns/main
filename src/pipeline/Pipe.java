package pipeline;

public abstract class Pipe<T> {
    public abstract boolean hasMore();
    public abstract void yield();

    public void await(Producer<T> producer) {
        this.producer = producer;
    }
    public void yieldTo(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    protected Producer<T> producer = null;
    protected Consumer<T> consumer = null;
}
