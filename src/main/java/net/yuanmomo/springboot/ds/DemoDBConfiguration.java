package net.yuanmomo.springboot.ds;

/**
 * Created by Hongbin.Yuan on 2017-06-07 16:58.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 *  demo DataSource.
 */
@Configuration
@MapperScan(basePackages = "net.yuanmomo.springboot.mybatis.mapper.demo", sqlSessionFactoryRef = "demoSessionFactory")
public class DemoDBConfiguration {
    private final MyBatisConfigurationSupport support;

    private DataSource dataSource;

    public DemoDBConfiguration(MyBatisConfigurationSupport support) {
        this.support = support;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        dataSource =  support.createDataSource("demo");
        return dataSource;
    }

    @Bean
    @Primary
    public SqlSessionFactory demoSessionFactory() throws Exception {
        SqlSessionFactory sqlSessionFactory = support.build(dataSource());
        System.out.println("################################ demo"+ dataSource);
        System.out.println("################################ demo"+ sqlSessionFactory);
        return sqlSessionFactory;
    }

    @Bean
    @Primary
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
