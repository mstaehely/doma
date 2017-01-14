/*
 * Copyright 2017 Matthew Staehely
 * 
 * Extension of test cases for original doma framework as part of Assignment 4
 * in the UW CSE 490E course.
 * 
 * This adds a set of test cases missing from the Standard Dialect Test suite.
 */

package org.seasar.doma.jdbc.dialect;

import org.seasar.doma.DomaNullPointerException;
import org.seasar.doma.expr.ExpressionFunctions;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlNode;
import org.seasar.doma.jdbc.dialect.StandardDialect.StandardJdbcMappingVisitor;
import org.seasar.doma.jdbc.dialect.StandardDialect.StandardSqlLogFormattingVisitor;

import junit.framework.TestCase;

public class StandardDialectImprovedTest extends TestCase {
	
	/**
	 * Testing for the single argument ctor requiring a mapping visitor.
	 */
	public void testCtorMappingVisitorArgument() {
		StandardJdbcMappingVisitor mapper = new StandardJdbcMappingVisitor();
		StandardDialect dia = new StandardDialect(mapper);
		assertTrue(dia instanceof StandardDialect);
	}
	
	/**
	 * Testing for the single argument ctor requring a sql formatting visitor.
	 */
	public void testCtorSqlFormattingVisitorArgument() {
		StandardSqlLogFormattingVisitor formatter = new StandardSqlLogFormattingVisitor();
		StandardDialect dia = new StandardDialect(formatter);
		assertTrue(dia instanceof StandardDialect);
	}
	
	/**
	 * Testing for the single argument ctor requiring an Expression Function.
	 */
	public void testCtorExpressionFunctions() {
		ExpressionFunctions func = new StandardDialect().getExpressionFunctions();
		StandardDialect dia = new StandardDialect(func);
		assertTrue(dia instanceof StandardDialect);
	}
	
	/**
	 * Branch test for null mapping visitor.
	 */
	public void testCtorNullMappingVisitor() {
		try {
			StandardJdbcMappingVisitor mapper = null;
			StandardDialect dia = new StandardDialect(mapper);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	/**
	 * Branch test for null formatting visitor.
	 */
	public void testCtorNullFormattingVisitor() {
		try {
			StandardSqlLogFormattingVisitor formatter = null;
			StandardDialect dia = new StandardDialect(formatter);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	/**
	 * Branch test for null expression functions.
	 */
	public void testCtorNullExpressionFunctions() {
		try {
			ExpressionFunctions func = null;
			StandardDialect dia = new StandardDialect(func);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	/**
	 * SQLNode transformSelectSqlNode branch test for null SQLNode argument. 
	 */
	public void testTransformSelectSqlNode() {
		SqlNode node = null;
		SelectOptions options = SelectOptions.get();
		assertNotNull(options);
		StandardDialect dia = new StandardDialect();
		try {
			dia.transformSelectSqlNode(node, options);
		} catch (Exception e) {
			assertTrue(e instanceof DomaNullPointerException);
		}
	}
	
	/**
	 * SQLNode transformSelectSqlNode branch test for null SelectOptions argument.
	 */
	public void testTransformSelectSelectOptions() {
		SqlNode node = null;
		SelectOptions options = null;
		StandardDialect dia = new StandardDialect();
	}
}