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
package org.seasar.doma.internal.jdbc.dialect;

import java.util.function.Function;

import junit.framework.TestCase;

import org.seasar.doma.internal.jdbc.mock.MockConfig;
import org.seasar.doma.internal.jdbc.sql.NodePreparedSqlBuilder;
import org.seasar.doma.internal.jdbc.sql.SqlParser;
import org.seasar.doma.jdbc.PreparedSql;
import org.seasar.doma.jdbc.SqlKind;
import org.seasar.doma.jdbc.SqlNode;

/**
 * @author taedium
 * 
 */
public class MysqlPagingTransformerTest extends TestCase {

    public void testOffsetLimit() throws Exception {
        String expected = "select * from emp order by emp.id limit 5, 10";
        MysqlPagingTransformer transformer = new MysqlPagingTransformer(5, 10);
        SqlParser parser = new SqlParser("select * from emp order by emp.id");
        SqlNode sqlNode = transformer.transform(parser.parse());
        NodePreparedSqlBuilder sqlBuilder = new NodePreparedSqlBuilder(
                new MockConfig(), SqlKind.SELECT, "dummyPath");
        PreparedSql sql = sqlBuilder.build(sqlNode, Function.identity());
        assertEquals(expected, sql.getRawSql());
    }

    public void testOffsetLimit_forUpdate() throws Exception {
        String expected = "select * from emp order by emp.id  limit 5, 10 for update";
        MysqlPagingTransformer transformer = new MysqlPagingTransformer(5, 10);
        SqlParser parser = new SqlParser(
                "select * from emp order by emp.id for update");
        SqlNode sqlNode = transformer.transform(parser.parse());
        NodePreparedSqlBuilder sqlBuilder = new NodePreparedSqlBuilder(
                new MockConfig(), SqlKind.SELECT, "dummyPath");
        PreparedSql sql = sqlBuilder.build(sqlNode, Function.identity());
        assertEquals(expected, sql.getRawSql());
    }

    public void testOffsetOnly() throws Exception {
        String expected = "select * from emp order by emp.id limit 5, 18446744073709551615";
        MysqlPagingTransformer transformer = new MysqlPagingTransformer(5, -1);
        SqlParser parser = new SqlParser("select * from emp order by emp.id");
        SqlNode sqlNode = transformer.transform(parser.parse());
        NodePreparedSqlBuilder sqlBuilder = new NodePreparedSqlBuilder(
                new MockConfig(), SqlKind.SELECT, "dummyPath");
        PreparedSql sql = sqlBuilder.build(sqlNode, Function.identity());
        assertEquals(expected, sql.getRawSql());
    }

    public void testLimitOnly() throws Exception {
        String expected = "select * from emp order by emp.id limit 0, 10";
        MysqlPagingTransformer transformer = new MysqlPagingTransformer(-1, 10);
        SqlParser parser = new SqlParser("select * from emp order by emp.id");
        SqlNode sqlNode = transformer.transform(parser.parse());
        NodePreparedSqlBuilder sqlBuilder = new NodePreparedSqlBuilder(
                new MockConfig(), SqlKind.SELECT, "dummyPath");
        PreparedSql sql = sqlBuilder.build(sqlNode, Function.identity());
        assertEquals(expected, sql.getRawSql());
    }
}
