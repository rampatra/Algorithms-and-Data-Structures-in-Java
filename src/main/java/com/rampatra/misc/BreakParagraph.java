package com.rampatra.misc;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/22/15
 * @time: 10:02 AM
 */
public class BreakParagraph {
    public static void main(String[] args) {
        String paragraph =
                "Line boundary analysis determines where a text " +
                        "string can be broken when line-wrapping. The " +
                        "mechanism correctly handles punctuation and " +
                        "hyphenated words. Mr.Ram is a good boy. Actual line breaking needs to " +
                        "also consider the available line width and is " +
                        "handled by higher-level software. ";

        BreakIterator iterator =
                BreakIterator.getSentenceInstance(Locale.US);

        int sentences = count(iterator, paragraph);
        System.out.println("Number of sentences: " + sentences);
    }

    private static int count(BreakIterator bi, String source) {
        int counter = 0;
        bi.setText(source);

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = source.substring(firstIndex, lastIndex);
                System.out.println("sentence = " + sentence);
                counter++;
            }
        }
        return counter;
    }
}
