package com.air_research.airwarningsystem;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class CodeGenerator {

    //包名
    private static final String BASE_PACKAGE = "com.air_research.airwarningsystem";
    //子包名
    private static final String SUB_PACKAGE = ".lanzhou";
    //模块名
    private static final String MODULE = "";
    //表名
    private static final String TABLES = "tb_lanzhou_pm25_imf,tb_lanzhou_pm10_imf," +
                                            "tb_lanzhou_so2_imf,tb_lanzhou_co_imf," +
                                            "tb_lanzhou_no2_imf,tb_lanzhou_o3_imf," +
                                            "tb_lanzhou_air_pollutants_concentration";
    //注释中的作者信息
    private static final String AUTHOR = "Wilson Zhang";

    @Value("${mybatis-plus.global-config.db-config.table-prefix}")
    private String tablePrefix;

    @Autowired
    private DataSourceProperties dataSource;

    @Test
    public void generator() {
        System.out.println("dataSource : " + dataSource);

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java/");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setSwagger2(true); // 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataSource.getUrl());
        System.out.println("dataSource.url = " + dataSource.getUrl());
        // dsc.setSchemaName("public");
        dsc.setDriverName(dataSource.getDriverClassName());
        System.out.println("dataSource.driverClassName = " + dataSource.getDriverClassName());
        dsc.setUsername(dataSource.getUsername());
        System.out.println("dataSource.userName = " + dataSource.getUsername());
        dsc.setPassword(dataSource.getPassword());
        System.out.println("dataSource.password = " + dataSource.getPassword());

        /*dsc.setUrl("jdbc:postgresql://localhost:5432/db_soil_info");
        dsc.setUsername("postgres");
        dsc.setPassword("123456");*/
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE);
        pc.setParent(BASE_PACKAGE + SUB_PACKAGE);
        mpg.setPackageInfo(pc);

        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };*/
        //mpg.setCfg(injectionConfig(FileType.ENTITY));

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//      strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//      strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//      strategy.setSuperEntityColumns("id");
        strategy.setInclude(TABLES.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
//      mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static InjectionConfig injectionConfig(FileType... fileTypeEnum) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                if (fileTypeEnum.length == 0) {
                    //无参情况下，先检查.java file是否存在：
                    //如果不存在，创建；如果存在，判断是否是entity.java：如果是，创建（覆盖）；否则，不创建。
                    checkDir(filePath);
                    File file = new File(filePath);
                    boolean exist = file.exists();
                    if (exist) {
                        if (FileType.ENTITY == fileType) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return true;
                } else {
                    //有参情况下，只创建传入的.java，无论存在都直接覆盖。
                    boolean isType = false;
                    for (int i = 0; i < fileTypeEnum.length; i++) {
                        if (fileTypeEnum[i] == fileType) {
                            isType = true;
                            break;
                        }
                    }
                    if (!isType) {
                        return false;
                    }
                    checkDir(filePath);
                    return true;
                }
            }
        });
        return injectionConfig;
    }
}

