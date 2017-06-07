package net.yuanmomo.springboot.ds;

/**
 * Created by Hongbin.Yuan on 2017-06-07 16:58.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 *  todo DataSource.
 */
@Configuration
@MapperScan(basePackages = "net.yuanmomo.springboot.mybatis.mapper.todo", sqlSessionFactoryRef = "todoSessionFactory")
public class ToDoDBConfiguration {
    private final MyBatisConfigurationSupport support;
    private DataSource dataSource;

    public ToDoDBConfiguration(MyBatisConfigurationSupport support) {
        this.support = support;
    }

    @Bean
    public DataSource todoDataSource() {
        dataSource = support.createDataSource("todo");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory todoSessionFactory() throws Exception {
        SqlSessionFactory sqlSessionFactory = support.build(todoDataSource());
        System.out.println("################################ todo"+ dataSource);
        System.out.println("################################ todo"+ sqlSessionFactory);
        return sqlSessionFactory;
    }

    @Bean
    public PlatformTransactionManager todoTxManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
