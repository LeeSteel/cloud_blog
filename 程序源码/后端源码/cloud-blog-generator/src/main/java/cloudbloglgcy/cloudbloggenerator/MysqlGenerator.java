package cloudbloglgcy.cloudbloggenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator {

    public static final String PATH = "F:/cloud-blog-generator/";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(PATH);
        gc.setFileOverride(true);
        gc.setAuthor("李钢 2580704698@qq.com");
         // gc.setAuthor("翦全吉彬 jianqjb@thinkive.com");
        gc.setOpen(false);
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/cloud_blog_plat?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT&&characterEncoding=GBK&allowMultiQueries=true");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.lgcy.blog.cloudblog.modules");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //mapper
        focList.add(new FileOutConfig("/templates_test/mapper2.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_JAVA;
            }
        });
        //mapper.xml
        focList.add(new FileOutConfig("/templates_test/mapper2.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getMapperName()   + StringPool.DOT_XML;
            }
        });
        //entity
        focList.add(new FileOutConfig("/templates_test/entity2.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        //service
        focList.add(new FileOutConfig("/templates_test/service2.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        //serviceImpl
        focList.add(new FileOutConfig("/templates_test/serviceImpl2.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        //controller
        focList.add(new FileOutConfig("/templates_test/controller2.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return PATH + pc.getModuleName()
                        + "/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        /**
         * 数据库表映射到实体的命名策略
         */
        strategy.setNaming(NamingStrategy.underline_to_camel);
        /**
         * 实体是否生成 serialVersionUID
         */
        strategy.setEntitySerialVersionUID(true);
        /**
         * 数据库表字段映射到实体的命名策略
         * <p>未指定按照 naming 执行</p>
         */
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        /**
         * 自定义继承的Entity类全称，带包名
         */
        strategy.setSuperEntityClass("com.lgcy.blog.cloudblog.common.BaseEntity");
        /**
         * 【实体】是否为lombok模型（默认 false）<br>
         * <a href="https://projectlombok.org/">document</a>
         */
        strategy.setEntityLombokModel(true);
        /**
         * 自定义继承的Controller类全称，带包名
         */
        strategy.setSuperControllerClass("com.lgcy.blog.cloudblog.common.BaseController");
        /**
         * 需要包含的表名，允许正则表达式（与exclude二选一配置）
         */
        strategy.setInclude(scanner("表名"));
        strategy.setSuperEntityColumns("id");
        /**
         * 驼峰转连字符
         * <pre>
         *      <code>@RequestMapping("/managerUserActionHistory")</code> -> <code>@RequestMapping("/manager-user-action-history")</code>
         * </pre>
         */
        strategy.setControllerMappingHyphenStyle(true);
        /**
         * 表前缀
         */
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
