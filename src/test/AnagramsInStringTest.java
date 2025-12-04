package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class AnagramsInStringTest {

    @Test
    public void testFindAllAnagramsInTextWithMultipleAnagrams() {
        String text = "cbaebabacd";
        String pattern = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        assertEquals(expected, AnagramsInString.findAllAnagramsInText(text, pattern),
                "Phải trả về các vị trí bắt đầu của tất cả các anagram của chuỗi mẫu trong văn bản.");
    }

    @Test
    public void testFindAllAnagramsInTextWithNoAnagrams() {
        String text = "abcdefg";
        String pattern = "xyz";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, AnagramsInString.findAllAnagramsInText(text, pattern),
                "Phải trả về danh sách trống khi không tìm thấy anagram nào.");
    }

    @Test
    public void testFindAllAnagramsInTextWhenPatternLargerThanText() {
        String text = "ab";
        String pattern = "abc";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, AnagramsInString.findAllAnagramsInText(text, pattern),
                "Phải trả về danh sách trống khi chuỗi mẫu lớn hơn văn bản.");
    }

    @Test
    public void testFindAllAnagramsInTextWithExactMatch() {
        String text = "abab";
        String pattern = "abab";
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, AnagramsInString.findAllAnagramsInText(text, pattern),
                "Phải trả về vị trí bắt đầu khi chuỗi mẫu khớp hoàn hảo với văn bản.");
    }

    @Test
    public void testFindAllAnagramsInTextNaiveWithMultipleAnagrams() {
        String text = "cbaebabacd";
        String pattern = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        assertEquals(expected, AnagramsInString.findAllAnagramsInTextNaive(text, pattern),
                "Phải trả về các vị trí bắt đầu của tất cả các anagram của chuỗi mẫu trong văn bản.");
    }

    @Test
    public void testFindAllAnagramsInTextNaiveWithNoAnagrams() {
        String text = "abcdefg";
        String pattern = "xyz";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, AnagramsInString.findAllAnagramsInTextNaive(text, pattern),
                "Phải trả về danh sách trống khi không tìm thấy anagram nào.");
    }

    @Test
    public void testFindAllAnagramsInTextNaiveWhenPatternLargerThanText() {
        String text = "ab";
        String pattern = "abc";
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, AnagramsInString.findAllAnagramsInTextNaive(text, pattern),
                "Phải trả về danh sách trống khi chuỗi mẫu lớn hơn văn bản.");
    }

    @Test
    public void testFindAllAnagramsInTextNaiveWithExactMatch() {
        String text = "abab";
        String pattern = "abab";
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, AnagramsInString.findAllAnagramsInTextNaive(text, pattern),
                "Phải trả về vị trí bắt đầu khi chuỗi mẫu khớp hoàn hảo với văn bản.");
    }
}
