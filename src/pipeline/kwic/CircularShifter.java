package pipeline.kwic;

import java.util.*;

import pipeline.Mapper;

public class CircularShifter implements Mapper<String, Iterable<String>> {
    private static String delim = "\\s+";

    private Set<String> ignoredWords;

    public CircularShifter(List<String> ignoredWords) {
        this.ignoredWords = new HashSet<>();
        for(String word: ignoredWords) {
            this.ignoredWords.add(word.toUpperCase());
        }
    }

    private Deque<String> splitString(final String sentence) {
        List<String> words = Arrays.asList(sentence.split(delim));
        return new ArrayDeque<>(words);
    }

    private int cycle(Deque<String> sentence) {
        int cycle = 0;
        String first;
        do  {
            cycle += 1;
            first = sentence.pollFirst();
            sentence.addLast(first);
            first = sentence.peekFirst();
        } while (ignoredWords.contains(first.toUpperCase()));
        return cycle;
    }

    private String combineString(final Deque<String> words) {
        StringBuilder result = new StringBuilder();
        Iterator<String> iter = words.iterator();
        while (iter.hasNext()) {
           result.append(iter.next());
            if (iter.hasNext()) result.append(" ");
        }
        return result.toString();
    }

    @Override
    public Iterable<String> apply(String input) {
        Deque<String> words = splitString(input);
        List<String> output = new ArrayList<>();
        for (int i = 0; i <= words.size() - 1;) {
            while (ignoredWords.contains(words.peekFirst())) {
                String first = words.peekFirst();
                words.pollFirst();
                words.addLast(first);
                i += 1;
            }
            output.add(combineString(words));
            i += cycle(words);
        }
        return output;
    }
}
