package pipeline.impl;

import pipeline.*;

import java.util.Iterator;


public class PipelineBuilder<S> {

    private Producer<S> current;
    private PipelineBuilder(Producer<S> source) {
        current = source;
    }

    public static <S> PipelineBuilder<S> fromIterable(final Iterable<S> iterable) {
        Pipe<S> outgoing = new SynchronousPipe<>();
        Source<S> source = new Source<S>(outgoing) {
            private Iterator<S> iterator = iterable.iterator();

            @Override
            public boolean hasMore() {
                return iterator.hasNext();
            }

            @Override
            public S produce() {
                return iterator.next();
            }
        };
        return new PipelineBuilder<>(source);
    }

    public <I> PipelineBuilder<I> pipe(final Mapper<S, I> mapper) {
        Pipe<S> incoming = new SynchronousPipe<>();
        incoming.await(current);
        Pipe<I> outgoing = new SynchronousPipe<>();
        Producer<I> filter = new Filter<S, I>(incoming, outgoing) {
            @Override
            public Mapper<S, I> getMapper() {
                return mapper;
            }
        };
        return new PipelineBuilder<>(filter);
    }

    public void flush(final Sink<S> sink) {
        while (current.hasMore()) {
            sink.consume(current.produce());
        }
    }
}
