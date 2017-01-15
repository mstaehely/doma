/*
 * Copyright 2017 Matthew Staehely
 * 
 * Extension to doma framework test suite, based on errors discovered by Randoop
 */

package org.seasar.doma.internal.jdbc.sql;

import org.seasar.doma.MapKeyNamingType;
import org.seasar.doma.internal.jdbc.command.MapProvider;
import org.seasar.doma.jdbc.query.CountQuery;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapListParameterTest extends TestCase {
	
	/**
	 * Tests to ensure that a bad CountQuery will return a null map provider,
	 * rather than crash out entirely.
	 */
	public void testNullMapProviderOnBadCountQuery() {
		MapKeyNamingType mknt = MapKeyNamingType.UPPER_CASE;
		List<Map<String, Object>> arr = new ArrayList<Map<String, Object>>();
		MapListParameter mlp = new MapListParameter(mknt, arr, "");
		CountQuery cq = new CountQuery();
		MapProvider mp = mlp.createObjectProvider(cq);
		assertNull(mp);
	}
}