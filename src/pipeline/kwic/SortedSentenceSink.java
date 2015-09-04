package pipeline.kwic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import pipeline.Sink;

public class SortedSentenceSink extends Sink<Iterable<String>> implements Iterable<String> {
    private PriorityQueue<String> sortedSentences = new PriorityQueue<>();

    @Override
    public void consume(Iterable<String> data) {
        for (String sentence: data) {
            sortedSentences.offer(sentence);
        }
    }

    @Override
    public Iterator<String> iterator() {
        final List<String> sorted = new ArrayList<String>() {{
            PriorityQueue<String> backup = new PriorityQueue<>();
            while (!sortedSentences.isEmpty()) {
                backup.offer(sortedSentences.peek());
                add(sortedSentences.poll());
            }
            sortedSentences = backup;
        }};
        return sorted.iterator();
    }
}
