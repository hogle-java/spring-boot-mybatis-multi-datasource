package net.yuanmomo.springboot.mybatis.mapper.todo;

import net.yuanmomo.springboot.bean.ToDo;
import net.yuanmomo.springboot.bean.ToDoParam;
import net.yuanmomo.springboot.bean.ToDoParam.Criteria;
import net.yuanmomo.springboot.bean.ToDoParam.Criterion;
import org.apache.ibatis.jdbc.SQL;
import java.util.List;
import java.util.Map;

public class ToDoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String countByExample(ToDoParam example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("todo.table_to_do");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String deleteByExample(ToDoParam example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("todo.table_to_do");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String insertSelective(ToDo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("todo.table_to_do");
        if (record.getToDo() != null) {
            sql.VALUES("to_do", "#{toDo,jdbcType=INTEGER}");
        }
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=BIGINT}");
        }
        if (record.getTestColumn() != null) {
            sql.VALUES("test_column", "#{testColumn,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String selectByExample(ToDoParam example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("to_do");
        sql.SELECT("remark");
        sql.SELECT("test_column");
        sql.FROM("todo.table_to_do");
        applyWhere(sql, example, false);
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        // add pagination for mysql with limit clause 
        StringBuilder sqlBuilder = new StringBuilder(sql.toString());
        if (example != null && (example.getStart() > -1 || example.getCount() > -1)) {
            sqlBuilder.append(" limit ");
            if (example.getStart() > -1 && example.getCount() > -1) {
                sqlBuilder.append(example.getStart()).append(",").append(example.getCount());
            } else if (example.getStart() > -1) {
                sqlBuilder.append(example.getStart());
            } else if (example.getCount() > -1) {
                sqlBuilder.append(example.getCount());
            }
        }
        return sqlBuilder.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ToDo record = (ToDo) parameter.get("record");
        ToDoParam example = (ToDoParam) parameter.get("example");
        SQL sql = new SQL();
        sql.UPDATE("todo.table_to_do");
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        if (record.getToDo() != null) {
            sql.SET("to_do = #{record.toDo,jdbcType=INTEGER}");
        }
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=BIGINT}");
        }
        if (record.getTestColumn() != null) {
            sql.SET("test_column = #{record.testColumn,jdbcType=VARCHAR}");
        }
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("todo.table_to_do");
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("to_do = #{record.toDo,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=BIGINT}");
        sql.SET("test_column = #{record.testColumn,jdbcType=VARCHAR}");
        ToDoParam example = (ToDoParam) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(ToDo record) {
        SQL sql = new SQL();
        sql.UPDATE("todo.table_to_do");
        if (record.getToDo() != null) {
            sql.SET("to_do = #{toDo,jdbcType=INTEGER}");
        }
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=BIGINT}");
        }
        if (record.getTestColumn() != null) {
            sql.SET("test_column = #{testColumn,jdbcType=VARCHAR}");
        }
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, ToDoParam example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    public String getOneByExample(ToDoParam example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("to_do");
        sql.SELECT("remark");
        sql.SELECT("test_column");
        sql.FROM("todo.table_to_do");
        applyWhere(sql, example, false);
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        StringBuilder sqlBuilder = new StringBuilder(sql.toString());
        sqlBuilder.append(" limit 1 ");
        return sqlBuilder.toString();
    }
}
