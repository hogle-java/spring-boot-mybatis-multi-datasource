package net.yuanmomo.springboot.mybatis.mapper;

import java.util.List;
import net.yuanmomo.springboot.bean.Demo;
import net.yuanmomo.springboot.bean.DemoParam;
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

public interface DemoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @SelectProvider(type=DemoSqlProvider.class, method="countByExample")
    long countByExample(DemoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @DeleteProvider(type=DemoSqlProvider.class, method="deleteByExample")
    int deleteByExample(DemoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @Delete({
        "delete from table_demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @Insert({
        "insert into table_demo (number, version)",
        "values (#{number,jdbcType=INTEGER}, #{version,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @SelectProvider(type=DemoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Demo> selectByExample(DemoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, number, version",
        "from table_demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    Demo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @UpdateProvider(type=DemoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @UpdateProvider(type=DemoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Demo record, @Param("example") DemoParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_demo
     *
     * @mbg.generated
     */
    @Update({
        "update table_demo",
        "set number = #{number,jdbcType=INTEGER},",
          "version = #{version,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Demo record);
}