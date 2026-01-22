package com.hackerrank.algorithms.test;


import com.hackerrank.algorithms.strings.TwoStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTwoString {
    @Test
    void test1IsSubstringInBoth(){
        String[] test1 = {"oo", "ab"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("NO",result);
    }
    @Test
    void test2IsSubstringInBoth(){
        String[] test1 = {"123a", "1a2"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("YES",result);
    }
    @Test
    void test3IsSubstringInBoth(){
        String[] test1 = {"ooa", "ab"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("YES",result);
    }
    @Test
    void test4IsSubstringInBoth(){
        String[] test1 = {"ooA", "ab"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("NO",result);
    }
    @Test
    void test5IsSubstringInBoth(){
        String[] test1 = {"@@@", "ab@"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("NO",result);
    }
    @Test
    void test6IsSubstringInBoth(){
        String[] test1 = {"", "ab"};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("NO",result);
    }
    @Test
    void test7IsSubstringInBoth(){
        String[] test1 = {"", ""};
        String result = TwoStrings.isSubstringInBoth(test1);
        assertEquals("NO",result);
    }
}