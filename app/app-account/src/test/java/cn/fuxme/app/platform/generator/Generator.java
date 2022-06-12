package cn.fuxme.app.platform.generator;

import cn.fuxme.infra.generator.DefaultConfigGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/1/28
 **/
public class Generator {

    @Test
    public void genCode() {
        List<String> excludes = new ArrayList<>();
        excludes.add("platform_user");

        DefaultConfigGenerator generator = new DefaultConfigGenerator.DefaultConfigGeneratorBuilder()
                .dir("/Users/wuhao/code/java/cloud-mall/app/app-account/src/main/java")
                .pkg("cn.fuxme.app.platform")
                .tablePrefix("platform_")
                .excludes(excludes)
                .build();
        generator.execute();

    }
}
