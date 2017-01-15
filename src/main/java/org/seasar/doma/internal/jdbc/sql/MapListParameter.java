/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.jdbc.sql;

import static org.seasar.doma.internal.util.AssertionUtil.assertNotNull;

import java.util.List;
import java.util.Map;

import org.seasar.doma.MapKeyNamingType;
import org.seasar.doma.internal.jdbc.command.MapProvider;
import org.seasar.doma.jdbc.query.Query;

/**
 * @author taedium
 * 
 */
public class MapListParameter extends
        AbstractListParameter<Map<String, Object>> {

    protected final MapKeyNamingType mapKeyNamingType;

    public MapListParameter(MapKeyNamingType mapKeyNamingType,
            List<Map<String, Object>> list, String name) {
        super(list, name);
        assertNotNull(mapKeyNamingType);
        this.mapKeyNamingType = mapKeyNamingType;
    }


    /**
     * @param query the Query object to create the MapProvider
     * 
     * @return the MapProvider created, or null if the query provider
     * 			does not have a configuration, indicating it was not
     * 			properly prepared.
     */
    @Override
    public MapProvider createObjectProvider(Query query) {
    	if (query.getConfig() != null) {
    		return new MapProvider(query, mapKeyNamingType);
    	}
    	return null;
    }

}
