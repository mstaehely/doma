/*
 * Copyright 2017 Matthew Staehely
 * 
 * Extension of test cases for original doma framework as part of Assignment 4
 * in the UW CSE 490E course.
 * 
 * This adds a set of test cases from the missing Standard Options Accessor Test suite.
 *
 */
package org.seasar.doma.jdbc;

import junit.framework.TestCase;

public class SelectOptionsAccessorTest extends TestCase {
	
	/**
	 * Tests the zero argument ctor
	 */
	public void testSelectOptionsAccessorCtor() {
		SelectOptionsAccessor soa = new SelectOptionsAccessor();
		assertNotNull(soa);
	}
	
	/**
	 * Tests the setCountSize setter
	 */
	public void testSetCountSize() {
		SelectOptions options = SelectOptions.get();
		SelectOptionsAccessor.setCountSize(options, 1l);
		assertEquals(options.getCount(), 1l);
	}
	
	/**
	 * Tests the getWaitSeconds getter
	 */
	public void testGetWaitSeconds() {
		SelectOptions options = SelectOptions.get();
		options.waitSeconds = 1;
		assertEquals(SelectOptionsAccessor.getWaitSeconds(options), 1);
	}
}