package pipeline;

public abstract class Source<T> implements Producer<T> {
    public Source(Pipe<T> outgoing) {
        this.outgoing = outgoing;
    }

    private Pipe<T> outgoing;
}
