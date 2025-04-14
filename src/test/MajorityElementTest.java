package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MajorityElementTest {

    @Test
    public void testMajorityElementSimple() {
        assertEquals(5, MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 5, 5, 5}),
                "Phải trả về phần tử đa số 5.");
    }

    @Test
    public void testMajorityElementAllSame() {
        assertEquals(1, MajorityElement.majorityElement(new int[]{1, 1, 1, 1}),
                "Phải trả về phần tử đa số 1 khi tất cả các phần tử giống nhau.");
    }

    @Test
    public void testMajorityElementNoInitialMajor() {
        assertEquals(3, MajorityElement.majorityElement(new int[]{1, 1, 2, 3, 3, 3, 3}),
                "Phải trả về phần tử đa số 3 khi phần tử đa số không phải là phần tử đầu tiên.");
    }

    @Test
    public void testMajorityElementChangeMajority() {
        assertEquals(1, MajorityElement.majorityElement(new int[]{3, 1, 3, 1, 1}),
                "Phải trả về phần tử đa số 1 khi phần tử đa số thay đổi trong quá trình duyệt.");
    }
}
