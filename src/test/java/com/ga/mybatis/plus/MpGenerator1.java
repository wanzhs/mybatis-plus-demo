package com.ga.mybatis.plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class MpGenerator1 {

    //    private static final String OUTPUTDIR = "D:\\project\\znyw\\mybatis-plus\\mybatis-plus-demo\\src\\main\\java";  //生成文件位置
    private static final String OUTPUTDIR = "D:\\wanzhs";  //生成文件位置
    private static final String AUTHOR = "wanzhs"; // 作者
    private static final String DATABASENAME = "db_oauth2"; // 数据库名称
//    private static final String[] TABLEPREFIX = {"t_", "test_", ""};  // 表的前缀
    private static final String[] TABLENAEM = {"base_user", "clientdetails",
            "oauth_access_token", "oauth_approvals", "oauth_client_details", "oauth_client_token",
            "oauth_code",
            "oauth_refresh_token"}; // 需要生成的表
    private static final String PARENT = "com.ga.bt.plus"; // 文件存放的父路径

    @Test
    public void getMpGenerator() {
        for (int i = 0; i < TABLENAEM.length; i++) {
            // 全局配置
            GlobalConfig gc = new GlobalConfig()
                    .setActiveRecord(true)  //是否支持 AR
                    .setAuthor(AUTHOR)
                    .setOutputDir(OUTPUTDIR)  // 生成路径
                    .setFileOverride(true)
                    .setIdType(IdType.AUTO)  //主键策略
                    .setServiceName("IM%sService") //service 名字
                    .setServiceImplName("M%sServiceImpl")
                    .setBaseResultMap(true)
                    .setEnableCache(false)// XML 二级缓存  为true时有问题
                    .setBaseColumnList(true);
            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
//            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("wanzhs");
            dsc.setPassword("123456");
            dsc.setUrl("jdbc:mysql://192.168.2.221:3306/" + DATABASENAME + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
            strategy.setEntityLombokModel(true);
//            strategy.setTablePrefix(TABLEPREFIX);// 此处可以修改为您的表前缀
            strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略 命名
            strategy.setInclude(TABLENAEM);  //生成表

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent(PARENT)
                    .setMapper("mapper")
                    .setEntity("entity")
                    .setService("service")
                    .setController("controller")
                    .setXml("mapper.xml");
            // 整合
            AutoGenerator ag = new AutoGenerator();
            ag.setGlobalConfig(gc).setDataSource(dsc).setPackageInfo(pc).setStrategy(strategy);
            ag.execute();
        }


    }

}
