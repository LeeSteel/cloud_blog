package com.lgcy.blog.cloudblogparent.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

import java.io.IOException;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 第一个数据源
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/18 21:27
 * @Copyright: Copyright (c) 2019
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.lgcy.blog.cloudblogparent.*.dao", sqlSessionFactoryRef = "firstSqlSessionFactory", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class FirstMyBatisConfiguration extends MyBatisConfiguration
{
    
    private static Logger logger = LoggerFactory.getLogger(FirstMyBatisConfiguration.class);
    
    public FirstMyBatisConfiguration(MybatisPlusProperties properties,
            ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader,
            ObjectProvider<DatabaseIdProvider> databaseIdProvider,
            ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
            ApplicationContext applicationContext)
    {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider,
                applicationContext);
    }
    
    @Primary
    @Bean("firstDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDatasource()
    {
        return DruidDataSourceBuilder.create().build();
    }
    
    @Primary
    @Bean("firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Autowired @Qualifier("firstDatasource") DataSource dataSource)
            throws Exception
    {
        return sqlSessionFactory(dataSource);
    }
    
    @Primary
    @Bean("firstSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(
            @Autowired @Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        return sqlSessionTemplate(sqlSessionFactory);
    }
    
    @Override
    protected void applyConfiguration(MybatisSqlSessionFactoryBean factory)
    {
        super.applyConfiguration(factory);
        try
        {
            Resource[] resources = RESOURCE_RESOLVER.getResources("classpath:mapper/**/*.xml");
            factory.setMapperLocations(resources);
        }
        catch (IOException e)
        {
            logger.error("没有找到mybatis xml配置文件", e);
        }
    }
    
}
