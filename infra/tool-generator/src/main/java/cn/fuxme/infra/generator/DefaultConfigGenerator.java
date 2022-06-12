package cn.fuxme.infra.generator;

import cn.fuxme.infra.generator.engine.CustomTemplateEngine;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/3/27
 **/
//@Builder(access = AccessLevel.PUBLIC)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultConfigGenerator {

    // 数据源
    private String url;
    private String username;
    private String password;

    // 全局配置
    private String author;
    private String dir;

    // 包配置
    private String pkg;

    // 策略配置
    private List<String> includes;
    private List<String> excludes;
    private String tablePrefix;


    public void execute() {

        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author(author)
                            .outputDir(dir);
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent(pkg)
                            .entity("model.entity")
                            .other("model.convert");
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(includes)
                            .addExclude(excludes)
                            .addTablePrefix(tablePrefix);

                    builder.entityBuilder().superClass("cn.fuxme.infra.db.entity.BaseEntity")
                            .disableSerialVersionUID()
                            .logicDeleteColumnName("deleted")
                            .enableLombok();
                    builder.mapperBuilder();
                    builder.serviceBuilder();
                    builder.controllerBuilder().enableRestStyle();
                })
                // 注入配置
                .injectionConfig(builder -> {

                })
                // 模板
                .templateEngine(new CustomTemplateEngine())
                .execute();
    }

    public static class DefaultConfigGeneratorBuilder {
        // 数据源
        private String url = "jdbc:mysql://localhost:3306/cloud-mall";
        private String username = "root";
        private String password = "root";

        // 全局配置
        private String author = "wuhao";
        private String dir = "/Users/wuhao/code/java/cloud-mall/app/app-account/src/main/java";

        // 包配置
        private String pkg = "cn.fuxme.app.platform";

        // 策略配置
        private List<String> includes = new ArrayList<>();
        private List<String> excludes = new ArrayList<>();
        private String tablePrefix;

        public DefaultConfigGeneratorBuilder() {
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder url(String url) {
            this.url = url;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder username(String username) {
            this.username = username;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder password(String password) {
            this.password = password;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder author(String author) {
            this.author = author;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder dir(String dir) {
            this.dir = dir;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder pkg(String pkg) {
            this.pkg = pkg;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder includes(List<String> includes) {
            this.includes = includes;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder excludes(List<String> excludes) {
            this.excludes = excludes;
            return this;
        }

        public DefaultConfigGenerator.DefaultConfigGeneratorBuilder tablePrefix(String tablePrefix) {
            this.tablePrefix = tablePrefix;
            return this;
        }

        public DefaultConfigGenerator build() {
            return new DefaultConfigGenerator(this.url, this.username, this.password, this.author, this.dir, this.pkg, this.includes, this.excludes, this.tablePrefix);
        }

    }
}
