package net.yuanmomo.springboot.ds;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Hongbin.Yuan on 2017-06-07 16:50.
 */
@Component
public class MyBatisConfigurationSupport {
    private final DataSourceProperties dataSourceProperties;
    private final MybatisProperties myBatisProperties;
    private final ResourceLoader resourceLoader;

    public MyBatisConfigurationSupport(
            DataSourceProperties dataSourceProperties,
            MybatisProperties myBatisProperties,
           ResourceLoader resourceLoader) {
        this.dataSourceProperties = dataSourceProperties;
        this.myBatisProperties = myBatisProperties;
        this.resourceLoader = resourceLoader;
    }

    public DataSource createDataSource(String instanceName) {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(dataSourceProperties.determineDriverClassName())
                .url(dataSourceProperties.determineUrl().replaceFirst("db_name", instanceName))
                .username(dataSourceProperties.determineUsername()).password(dataSourceProperties.determinePassword())
                .build();
        return dataSource;
    }

    public SqlSessionFactory build(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setVfs(SpringBootVFS.class);
        factoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        if (myBatisProperties.getConfiguration() != null) {
            BeanUtils.copyProperties(myBatisProperties.getConfiguration(), configuration);
        }
        // omit ...
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }
}
