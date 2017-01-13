/*
 * Copyright 2017 Matthew Staehely
 * 
 * Extension of test cases for original doma framework as part of Assignment 4
 * in the UW CSE 490E course.
 * 
 * This test class checks the functionality and exception handling of the 
 * MapKeyNamingType enum.
 */

package org.seasar.doma;

import junit.framework.TestCase;

public class MapKeyNamingTypeTest extends TestCase {
	
	
	/**
	 * Testing to ensure that the NONE enum flag properly throws
	 * a DomaNullPointerException if a null String is applied.
	 */
	public void testDoesNothingNull() {
		MapKeyNamingType naming = MapKeyNamingType.NONE;
		try {
			naming.apply(null);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	
	/**
	 * Testing to ensure that the NONE enum flag properly does nothing
	 * when a string is applied.
	 */
	public void testDoesNothingString() {
		MapKeyNamingType naming = MapKeyNamingType.NONE;
		assertEquals("Test String", naming.apply("Test String"));
	}
	
	
	/**
	 * Testing to ensure that the CAMEL_CASE enum flag properly throws
	 * a DomaNullPointerException when a null string is passed.
	 */
	public void testCamelCaseNull() {
		MapKeyNamingType naming = MapKeyNamingType.CAMEL_CASE;
		try {
			naming.apply(null);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
		
	
	/**
	 * Testing to ensure that the CAMEL_CASE enum flag properly changes
	 * a string to camel case, when the appropriate format is passed.
	 */
	public void testCamelCaseConvertProperly() {
		MapKeyNamingType naming = MapKeyNamingType.CAMEL_CASE;
		assertEquals("aaaBbb", naming.apply("AAA_BBB"));
	}
	
	
	/**
	 * Testing to ensure that the CAMEL_CASE enum flag properly does not
	 * change a string to camel case, when the appropriate format is not
	 * passed.
	 */
	public void testCamelCaseNoConversion() {
		MapKeyNamingType naming = MapKeyNamingType.CAMEL_CASE;
		assertEquals("aaabbb", naming.apply("AAABBB"));
	}
	
	
	/**
	 * Testing to ensure that the UPPER_CASE enum flag properly throws
	 * a DomaNullPointException when a null string is passed.
	 */
	public void testUpperCaseNull() {
		MapKeyNamingType naming = MapKeyNamingType.UPPER_CASE;
		try {
			naming.apply(null);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	
	/**
	 * Testing to ensure that the UPPER_CASE enum flag properly converts
	 * a string to upper case.
	 */
	public void testUpperCase() {
		MapKeyNamingType naming = MapKeyNamingType.UPPER_CASE;
		assertEquals("AAABBB", naming.apply("aaabbb"));
	}
	
	
	/**
	 * Testing to ensure that the LOWER_CASE enum flag properly throws
	 * a DomaNullPointException when a null string is passed.
	 */
	public void testLowerCaseNull() {
		MapKeyNamingType naming = MapKeyNamingType.LOWER_CASE;
		try {
			naming.apply(null);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	
	/**
	 * Testing to ensure that the LOWER_CASE enum flag properly converts
	 * a string to upper case.
	 */
	public void testLowerCase() {
		MapKeyNamingType naming = MapKeyNamingType.LOWER_CASE;
		assertEquals("aaabbb", naming.apply("AAABBB"));
	}
}