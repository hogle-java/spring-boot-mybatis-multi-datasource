package net.yuanmomo.springboot.ds;

/**
 * Created by Hongbin.Yuan on 2017-06-07 16:58.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 *  demo DataSource.
 */
@Configuration
@MapperScan(basePackages = "net.yuanmomo.springboot.mybatis.mapper.demo", sqlSessionFactoryRef = "demoSessionFactory")
public class DemoDBConfiguration {
    private final MyBatisConfigurationSupport support;

    public DemoDBConfiguration(MyBatisConfigurationSupport support) {
        this.support = support;
    }

    @Bean
    public DataSource demoDataSource() {
        return support.createDataSource("demo");
    }

    @Bean
    @Primary
    public SqlSessionFactory demoSessionFactory() throws Exception {
        DataSource dataSource = this.demoDataSource();
        System.out.println(dataSource);
        return support.build(dataSource);
    }

}
