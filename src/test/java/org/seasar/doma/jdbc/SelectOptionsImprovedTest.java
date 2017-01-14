/*
 * Copyright 2017 Matthew Staehely
 * 
 * Extension of test cases for original doma framework as part of Assignment 4
 * in the UW CSE 490E course.
 * 
 * This adds a set of test cases missing from the Standard Options Test suite.
 */

package org.seasar.doma.jdbc;

import junit.framework.TestCase;

public class SelectOptionsImprovedTest extends TestCase {


	/**
	 * Test the setter for SelectOptions' count field.
	 */
	public void testSetCountSize() {
		SelectOptions options = SelectOptions.get();
		assertTrue(SelectOptionsAccessor.isCount(options.count()));
	}
	
	/**
	 * Test the setter for SelectOptions' offset method.
	 */
	public void testOffset() {
		SelectOptions options = SelectOptions.get();
		assertEquals(1, SelectOptionsAccessor.getOffset(options.offset(1)));
	}
	
}