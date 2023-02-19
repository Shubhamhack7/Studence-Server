package com.tiwari.studence.bquery.database.module;

import java.util.List;

import com.google.common.collect.Lists;
import com.tiwari.studence.util.Strings;

// not a singleton class
@SuppressWarnings("rawtypes")
public class BQuery {

  private String m_query;

  // Constructor---------------------------------------------------------------------------------------

  private BQuery() {
    m_query = "";
  }

  private BQuery(Object query) {
    m_query = makeString(query);
  }

  // FactoryMethod--------------------------------------------------------------------------------------

  public static BQuery builder() {
    return new BQuery();
  }

  public static BQuery builder(Object query) {
    return new BQuery(query);
  }

  // Query----------------------------------------------------------------------------------------------

  public BQuery WITH(BQuery... queries) {
    return WITH(Lists.newArrayList(queries));
  }

  public BQuery WITH(List<BQuery> queries) {
    m_query = String.format("%s WITH %s", m_query, makeString(queries, ", "));
    return this;
  }

  public BQuery SELECT(Object... columns) {
    return SELECT(Lists.newArrayList(columns));
  }

  public BQuery SELECT(List columns) {
    m_query = String.format("%s SELECT %s", m_query, makeString(columns, ", "));
    return this;
  }

  public BQuery SELECT_DISTINCT(Object... columns) {
    return SELECT_DISTINCT(Lists.newArrayList(columns));
  }

  public BQuery SELECT_DISTINCT(List columns) {
    m_query = String.format("%s SELECT DISTINCT %s", m_query, makeString(columns, ", "));
    return this;
  }

  public BQuery FROM(Object from) {
    m_query = String.format("%s FROM %s", m_query, makeString(from));
    return this;
  }

  public BQuery WHERE(BQuery condition) {
    m_query = String.format("%s WHERE %s", m_query, makeString(condition));
    return this;
  }

  public BQuery EXISTS(BQuery query) {
    m_query = String.format("%s EXISTS (%s)", m_query, makeString(query));
    return this;
  }

  public BQuery NOT_EXISTS(BQuery query) {
    m_query = String.format("%s NOT EXISTS (%s)", m_query, makeString(query));
    return this;
  }

  public BQuery AS(Object alias) {
    m_query = String.format("%s AS %s", m_query, makeString(alias));
    return this;
  }

  public BQuery JOIN(Object... data) {
    return JOIN(Lists.newArrayList(data));
  }

  public BQuery JOIN(List data) {
    m_query = makeString(this, data, " JOIN ");
    return this;
  }

  public BQuery CROSS_JOIN(Object... data) {
    return CROSS_JOIN(Lists.newArrayList(data));
  }

  public BQuery CROSS_JOIN(List data) {
    m_query = makeString(this, data, " CROSS JOIN ");
    return this;
  }

  public BQuery FULL_JOIN(Object... data) {
    return FULL_JOIN(Lists.newArrayList(data));
  }

  public BQuery FULL_JOIN(List data) {
    m_query = makeString(this, data, " FULL JOIN ");
    return this;
  }

  public BQuery LEFT_JOIN(Object... data) {
    return LEFT_JOIN(Lists.newArrayList(data));
  }

  public BQuery LEFT_JOIN(List data) {
    m_query = makeString(this, data, " LEFT JOIN ");
    return this;
  }

  public BQuery RIGHT_JOIN(Object... data) {
    return RIGHT_JOIN(Lists.newArrayList(data));
  }

  public BQuery RIGHT_JOIN(List data) {
    m_query = makeString(this, data, " RIGHT JOIN ");
    return this;
  }

  public BQuery USING(Object... columns) {
    return USING(Lists.newArrayList(columns));
  }

  public BQuery USING(List columns) {
    m_query = String.format("%s USING (%s)", m_query, makeString(columns, ", "));
    return this;
  }

  public BQuery ON(BQuery condition) {
    m_query = String.format("%s ON %s", m_query, makeString(condition));
    return this;
  }

  public BQuery UNION_ALL(BQuery... data) {
    return UNION_ALL(Lists.newArrayList(data));
  }

  public BQuery UNION_ALL(List<BQuery> data) {
    m_query = makeString(this, data, " UNION ALL ");
    return this;
  }

  public BQuery UNION_DISTINCT(BQuery... data) {
    return UNION_DISTINCT(Lists.newArrayList(data));
  }

  public BQuery UNION_DISTINCT(List<BQuery> data) {
    m_query = makeString(this, data, " UNION DISTINCT ");
    return this;
  }

  public BQuery IN_S(Object... values) {
    return IN_S(Lists.newArrayList(values));
  }

  public BQuery IN_S(List values) {
    m_query = String.format("%s IN ('%s')", m_query, makeString(values, "', '"));
    return this;
  }

  public BQuery IN(Object... values) {
    return IN(Lists.newArrayList(values));
  }

  public BQuery IN(List values) {
    m_query = String.format("%s IN (%s)", m_query, makeString(values, ", "));
    return this;
  }

  public BQuery IN_UNNEST(BQuery array) {
    m_query = String.format("%s IN UNNEST(%s)", m_query, makeString(array));
    return this;
  }

  public BQuery IS(String value) {
    m_query = String.format("%s IS %s", m_query, value);
    return this;
  }

  public BQuery IS_NOT(String value) {
    m_query = String.format("%s IS NOT %s", m_query, value);
    return this;
  }

  public BQuery NOT() {
    m_query = String.format("%s NOT", m_query);
    return this;
  }

  public BQuery AND(Object... values) {
    return AND(Lists.newArrayList(values));
  }

  public BQuery AND(List values) {
    m_query = makeString(this, values, " AND ");
    return this;
  }

  public BQuery OR(Object... values) {
    return OR(Lists.newArrayList(values));
  }

  public BQuery OR(List values) {
    m_query = makeString(this, values, " OR ");
    return this;
  }

  public BQuery BETWEEN_S(Object start, Object end) {
    m_query = String.format("%s BETWEEN '%s' AND '%s'", m_query, makeString(start),
            makeString(end));
    return this;
  }

  public BQuery BETWEEN(Object start, Object end) {
    m_query = String.format("%s BETWEEN %s AND %s", m_query, makeString(start), makeString(end));
    return this;
  }

  public BQuery GROUP_BY(Object... expressions) {
    return GROUP_BY(Lists.newArrayList(expressions));
  }

  public BQuery GROUP_BY(List expressions) {
    m_query = String.format("%s GROUP BY %s", m_query, makeString(expressions, ", "));
    return this;
  }

  public BQuery GROUP_BY_ROLLUP(Object... expressions) {
    return GROUP_BY_ROLLUP(Lists.newArrayList(expressions));
  }

  public BQuery GROUP_BY_ROLLUP(List expressions) {
    m_query = String.format("%s GROUP BY ROLLUP (%s)", m_query, makeString(expressions, ", "));
    return this;
  }

  public BQuery OVER(BQuery expression) {
    m_query = String.format("%s OVER (%s)", m_query, makeString(expression));
    return this;
  }

  public BQuery HAVING(BQuery condition) {
    m_query = String.format("%s HAVING %s", m_query, makeString(condition));
    return this;
  }

  public BQuery PARTITION_BY(Object... expressions) {
    return PARTITION_BY(Lists.newArrayList(expressions));
  }

  public BQuery PARTITION_BY(List expressions) {
    m_query = String.format("%s PARTITION BY %s", m_query, makeString(expressions, ", "));
    return this;
  }

  public BQuery ORDER_BY(BQuery... expressions) {
    return ORDER_BY(Lists.newArrayList(expressions));
  }

  public BQuery ORDER_BY(List<BQuery> expressions) {
    m_query = String.format("%s ORDER BY %s", m_query, makeString(expressions, ", "));
    return this;
  }

  public BQuery ASC(Object... expressions) {
    return ASC(Lists.newArrayList(expressions));
  }

  public BQuery ASC(List expressions) {
    List<String> orderList = Lists.newArrayList();
    for (String exp : makeString(expressions)) {
      orderList.add(String.format("%s ASC", exp));
    }
    m_query = String.format("%s %s", m_query, makeString(orderList, ", "));
    return this;
  }

  public BQuery DESC(Object... expressions) {
    return DESC(Lists.newArrayList(expressions));
  }

  public BQuery DESC(List expressions) {
    List<String> orderList = Lists.newArrayList();
    for (String exp : makeString(expressions)) {
      orderList.add(String.format("%s DESC", exp));
    }
    m_query = String.format("%s %s", m_query, makeString(orderList, ", "));
    return this;
  }

  public BQuery LIMIT(int limit) {
    if (limit > 0) {
      m_query = String.format("%s LIMIT %d", m_query, limit);
    }
    return this;
  }

  public BQuery CASE() {
    m_query = String.format("%s CASE", m_query);
    return this;
  }

  public BQuery CASE(Object expression) {
    m_query = String.format("%s CASE %s", m_query, makeString(expression));
    return this;
  }

  public BQuery WHEN_S(Object expression) {
    m_query = String.format("%s WHEN '%s'", m_query, makeString(expression));
    return this;
  }

  public BQuery WHEN(Object expression) {
    m_query = String.format("%s WHEN %s", m_query, makeString(expression));
    return this;
  }

  public BQuery THEN_S(Object expression) {
    m_query = String.format("%s THEN '%s'", m_query, makeString(expression));
    return this;
  }

  public BQuery THEN(Object expression) {
    m_query = String.format("%s THEN %s", m_query, makeString(expression));
    return this;
  }

  public BQuery ELSE_S(Object expression) {
    m_query = String.format("%s ELSE '%s'", m_query, makeString(expression));
    return this;
  }

  public BQuery ELSE(Object expression) {
    m_query = String.format("%s ELSE %s", m_query, makeString(expression));
    return this;
  }

  public BQuery END() {
    m_query = String.format("%s END", m_query);
    return this;
  }

  public BQuery UNNEST(BQuery array) {
    m_query = String.format("%s UNNEST(%s)", m_query, makeString(array));
    return this;
  }

  public BQuery WITH_OFFSET() {
    m_query = String.format("%s WITH OFFSET", m_query);
    return this;
  }

  public BQuery STRUCT(Object... values) {
    return STRUCT(Lists.newArrayList(values));
  }

  public BQuery STRUCT(List values) {
    m_query = String.format("%s STRUCT(%s)", m_query, makeString(values, ", "));
    return this;
  }

  public BQuery ARRAY(Object... values) {
    return ARRAY(Lists.newArrayList(values));
  }

  public BQuery ARRAY(List values) {
    m_query = String.format("%s ARRAY[%s]", m_query, makeString(values, ", "));
    return this;
  }

  // Builder--------------------------------------------------------------------------------------

  public String build() {
    return String.format("%s;", buildPartial());
  }

  public String buildPartial() {
    return m_query.trim();
  }

  // Helper----------------------------------------------------------------------------------------

  public BQuery append(Object value) {
    m_query = String.format("%s %s", m_query, makeString(value));
    return this;
  }

  public BQuery parenthesis() {
    m_query = String.format("(%s)", buildPartial());
    return this;
  }

  public BQuery singleQuoted() {
    m_query = String.format("'%s'", buildPartial());
    return this;
  }

  public BQuery backTicked() {
    m_query = String.format("`%s`", buildPartial());
    return this;
  }

  // Formatter--------------------------------------------------------------------------------------

  public BQuery format(Object... args) {
    Object[] argsArray = new Object[args.length];
    for (int i = 0; i < args.length; ++i) {
      if (args[i] instanceof BQuery) {
        argsArray[i] = ((BQuery) args[i]).buildPartial();
      } else {
        argsArray[i] = args[i];
      }
    }
    m_query = String.format(m_query, argsArray);
    return this;
  }

  @Override
  public String toString() {
    return m_query;
  }

  // Private-----------------------------------------------------------------------------------------

  private String makeString(Object obj) {
    if (obj instanceof BQuery) {
      return ((BQuery) obj).buildPartial();
    }
    return obj.toString();
  }

  private List<String> makeString(List objs) {
    List<Object> correctedList = Lists.newArrayList();
    for (Object obj : objs) {
      if (obj instanceof List) {
        correctedList.addAll((List) obj);
      } else {
        correctedList.add(obj);
      }
    }
    List<String> list = Lists.newArrayList();
    for (Object obj : correctedList) {
      String str = makeString(obj);
      if (Strings.notEmpty(str)) {
        list.add(str);
      }
    }
    return list;
  }

  private String makeString(List objs, String join) {
    return Strings.join(makeString(objs), join);
  }

  private String makeString(Object obj, List objs, String join) {
    List<Object> list = Lists.newArrayList();
    list.add(obj);
    list.addAll(objs);
    return makeString(list, join);
  }

}