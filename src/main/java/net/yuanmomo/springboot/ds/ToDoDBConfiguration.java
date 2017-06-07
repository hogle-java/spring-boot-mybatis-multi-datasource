package net.yuanmomo.springboot.ds;

/**
 * Created by Hongbin.Yuan on 2017-06-07 16:58.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *  todo DataSource.
 */
@Configuration
@MapperScan(basePackages = "net.yuanmomo.springboot.mybatis.mapper.todo", sqlSessionFactoryRef = "todoSessionFactory")
public class ToDoDBConfiguration {
    private final MyBatisConfigurationSupport support;

    public ToDoDBConfiguration(MyBatisConfigurationSupport support) {
        this.support = support;
    }

    @Bean
    public DataSource todoDataSource() {
        return support.createDataSource("todo");
    }

    @Bean
    public SqlSessionFactory todoSessionFactory() throws Exception {
        DataSource dataSource = this.todoDataSource();
        System.out.println(dataSource);
        return support.build(dataSource);
    }

}
