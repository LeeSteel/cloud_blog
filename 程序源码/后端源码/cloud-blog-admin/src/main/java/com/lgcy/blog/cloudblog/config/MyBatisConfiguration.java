package com.lgcy.blog.cloudblog.config;

import java.util.List;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: mybatis 配置
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/18 21:27
 * @Copyright: Copyright (c) 2019
 */
@Slf4j
public class MyBatisConfiguration
{
    
    protected static final ResourcePatternResolver RESOURCE_RESOLVER = new PathMatchingResourcePatternResolver();
    
    private final MybatisPlusProperties            properties;
    
    private final Interceptor[]                    interceptors;
    
    private final ResourceLoader                   resourceLoader;
    
    private final DatabaseIdProvider               databaseIdProvider;
    
    private final List<ConfigurationCustomizer>    configurationCustomizers;
    
    private final ApplicationContext               applicationContext;
    
    public MyBatisConfiguration(MybatisPlusProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
            ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
            ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
            ApplicationContext applicationContext)
    {
        this.properties = properties;
        this.interceptors = interceptorsProvider.getIfAvailable();
        this.resourceLoader = resourceLoader;
        this.databaseIdProvider = databaseIdProvider.getIfAvailable();
        this.configurationCustomizers = configurationCustomizersProvider.getIfAvailable();
        this.applicationContext = applicationContext;
    }
    
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
    {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if ( StringUtils.hasText(this.properties.getConfigLocation()) )
        {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        applyConfiguration(factory);
        if ( this.properties.getConfigurationProperties() != null )
        {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if ( !ObjectUtils.isEmpty(this.interceptors) )
        {
            factory.setPlugins(this.interceptors);
        }
        if ( this.databaseIdProvider != null )
        {
            factory.setDatabaseIdProvider(this.databaseIdProvider);
        }
        if ( StringUtils.hasLength(this.properties.getTypeAliasesPackage()) )
        {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        // TODO 鑷畾涔夋灇涓惧寘
        if ( StringUtils.hasLength(this.properties.getTypeEnumsPackage()) )
        {
            factory.setTypeEnumsPackage(this.properties.getTypeEnumsPackage());
        }
        if ( this.properties.getTypeAliasesSuperType() != null )
        {
            factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
        }
        if ( StringUtils.hasLength(this.properties.getTypeHandlersPackage()) )
        {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if ( !ObjectUtils.isEmpty(this.properties.resolveMapperLocations()) )
        {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }

        GlobalConfig globalConfig = this.properties.getGlobalConfig();

        if ( this.applicationContext.getBeanNamesForType(MetaObjectHandler.class, false, false).length > 0 )
        {
            MetaObjectHandler metaObjectHandler = this.applicationContext.getBean(MetaObjectHandler.class);
            globalConfig.setMetaObjectHandler(metaObjectHandler);
        }

        if ( this.applicationContext.getBeanNamesForType(IKeyGenerator.class, false, false).length > 0 )
        {
            IKeyGenerator keyGenerator = this.applicationContext.getBean(IKeyGenerator.class);
            globalConfig.getDbConfig().setKeyGenerator(keyGenerator);
        }

        if ( this.applicationContext.getBeanNamesForType(ISqlInjector.class, false, false).length > 0 )
        {
            ISqlInjector iSqlInjector = this.applicationContext.getBean(ISqlInjector.class);
            globalConfig.setSqlInjector(iSqlInjector);
        }
        factory.setGlobalConfig(globalConfig);
        return factory.getObject();
    }
    
    protected void applyConfiguration(MybatisSqlSessionFactoryBean factory)
    {
        MybatisConfiguration configuration = this.properties.getConfiguration();
        if ( configuration == null && !StringUtils.hasText(this.properties.getConfigLocation()) )
        {
            configuration = new MybatisConfiguration();
        }
        if ( configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers) )
        {
            for (ConfigurationCustomizer customizer : this.configurationCustomizers)
            {
                customizer.customize(configuration);
            }
        }
        factory.setConfiguration(configuration);
    }
    
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
    {
        ExecutorType executorType = this.properties.getExecutorType();
        if ( executorType != null )
        {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        }
        else
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }
}
