package pipeline;

public interface Mapper<S, T> {
    T apply(S input);
}

