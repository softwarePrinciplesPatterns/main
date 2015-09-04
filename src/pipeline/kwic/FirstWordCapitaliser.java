package pipeline.kwic;

import pipeline.Mapper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FirstWordCapitaliser implements Mapper<Iterable<String>, Iterable<String>> {
    @Override
    public Iterable<String> apply(final Iterable<String> input) {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    private Iterator<String> inputIterator = input.iterator();

                    @Override
                    public boolean hasNext() {
                        return inputIterator.hasNext();
                    }

                    @Override
                    public String next() {
                        String current = inputIterator.next();
                        List<String> words = Arrays.asList(current.split("\\s"));
                        words.set(0, words.get(0).toUpperCase());
                        StringBuilder result = new StringBuilder();
                        Iterator<String> iter = words.iterator();
                        while (iter.hasNext()) {
                            result.append(iter.next());
                            if (iter.hasNext()) result.append(" ");
                        }
                        return result.toString();
                    }

                    @Override
                    public void remove() {
                        inputIterator.remove();
                    }
                };
            }
        };
    }
}
