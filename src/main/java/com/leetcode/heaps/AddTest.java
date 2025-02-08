package ASS3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTest {

	@Test
	void test() {
		TopKFrequentElements T = new TopKFrequentElements();
		assertEquals("[]", T.topKFrequent(new int[] {}, 1).toString());
		assertEquals("[2, 1]", T.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2).toString());
		assertEquals("[0]", T.topKFrequent(new int[] { 3, 0, 1, 0 }, 1).toString());
		assertEquals("[1]", T.topKFrequent(new int[] { 1 }, 1).toString());
		assertEquals("[1, 2]", T.topKFrequent(new int[] { 1, 2 }, 2).toString());
		assertEquals("[2, -1]", T.topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2).toString());
		assertEquals("[1, -1, 2]", T.topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 1 }, 3).toString());
	}

}
