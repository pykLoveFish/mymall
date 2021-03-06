package com.pyk.mymall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();//MBG 执行过程中的警告信息
        boolean overwrite = false; //当生成的代码重复时，是否覆盖原代码

        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");//读取我们的 MBG 配置文件
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration cfg = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        //创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(cfg,callback,warnings);
        myBatisGenerator.generate(null);//执行生成代码

        for(String warning:warnings){
            System.out.println(warning);
        }


    }
}
