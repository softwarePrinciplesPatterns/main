package pipeline;


public abstract class Filter<S, T> implements Consumer<S>, Producer<T> {

    public Filter(Pipe<S> incoming, Pipe<T> outgoing) {
        this.incoming = incoming;
        outgoing.await(this);
        incoming.yieldTo(this);
    }

    @Override
    public boolean hasMore() {
        return incoming.hasMore();
    }

    @Override
    public T produce() {
        incoming.yield();
        return getMapper().apply(data);
    }

    @Override
    public void consume(S data) {
        this.data = data;
    }

    public abstract Mapper<S, T> getMapper();

    private Pipe<S> incoming;
    private S data;
}
