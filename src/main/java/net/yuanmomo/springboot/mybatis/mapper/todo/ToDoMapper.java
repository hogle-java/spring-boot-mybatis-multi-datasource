package net.yuanmomo.springboot.mybatis.mapper.todo;

import java.util.List;
import net.yuanmomo.springboot.bean.ToDo;
import net.yuanmomo.springboot.bean.ToDoParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ToDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @SelectProvider(type=ToDoSqlProvider.class, method="countByExample")
    long countByExample(ToDoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @DeleteProvider(type=ToDoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ToDoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @Delete({
        "delete from todo.table_to_do",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @Insert({
        "insert into todo.table_to_do (to_do, remark)",
        "values (#{toDo,jdbcType=INTEGER}, #{remark,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ToDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @InsertProvider(type=ToDoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ToDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @SelectProvider(type=ToDoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_do", property="toDo", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.BIGINT)
    })
    List<ToDo> selectByExample(ToDoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, to_do, remark",
        "from todo.table_to_do",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_do", property="toDo", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.BIGINT)
    })
    ToDo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @UpdateProvider(type=ToDoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ToDo record, @Param("example") ToDoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @UpdateProvider(type=ToDoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ToDo record, @Param("example") ToDoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @UpdateProvider(type=ToDoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ToDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_to_do
     *
     * @mbg.generated
     */
    @Update({
        "update todo.table_to_do",
        "set to_do = #{toDo,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ToDo record);
}