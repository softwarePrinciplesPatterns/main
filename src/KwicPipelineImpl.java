import java.util.ArrayList;
import java.util.List;

import pipeline.impl.PipelineBuilder;
import pipeline.kwic.*;

/**
 * Implementation of Keyword In Context (KWIC) using Pipe and Filter
 *
 */
public class KwicPipelineImpl {

    public static void execute() {
        List<String> sentences = new ArrayList<String>() {{
            add("The Day after Tomorrow");
            add("Fast and Furious");
            add("Man of Steel");
        }};
        List<String> wordsToIgnore = new ArrayList<String>() {{
            add("is"); add("the"); add("of"); add("and"); add("as"); add("a"); add("after");
        }};
        CircularShifter circularShifter = new CircularShifter(wordsToIgnore);
        SortedSentenceSink sortedSentences = new SortedSentenceSink();
        FirstWordCapitaliser capitaliser = new FirstWordCapitaliser();
        PipelineBuilder.fromIterable(sentences)
                .pipe(circularShifter)
                .pipe(capitaliser)
                .flush(sortedSentences);
        for (String sentence: sortedSentences) {
            System.out.println(sentence);
        }
    }

}
