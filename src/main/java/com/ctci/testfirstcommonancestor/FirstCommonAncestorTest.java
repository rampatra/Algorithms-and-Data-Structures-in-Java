package com.swe102x.mytest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.swe102x.myclass.FirstCommonAncestor;
import com.swe102x.myclass.FirstCommonAncestor.TreeNode;

class FirstCommonAncestorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
		FirstCommonAncestor ancestor;
		FirstCommonAncestor.TreeNode root;
	@BeforeEach
	void setUp() throws Exception {
		
		ancestor = new FirstCommonAncestor();
		root = ancestor.new TreeNode(4);
		ancestor.addNode(root);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindFCA() {
		//test case
		assertEquals(root, ancestor.findFCA(root, root.getLeft().getLeft().getLeft(), root.getRight().getRight()));
	}
	
}
