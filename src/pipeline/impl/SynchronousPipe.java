package pipeline.impl;

import pipeline.Pipe;

public class SynchronousPipe<T> extends Pipe<T> {

    @Override
    public boolean hasMore() {
        return producer.hasMore();
    }

    @Override
    public void yield() {
        if (hasMore()) {
            consumer.consume(producer.produce());
        }
    }
}
