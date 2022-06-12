package cn.fuxme.infra.generator.engine;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sun.istack.internal.NotNull;

import java.io.File;
import java.util.Map;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/3/27
 **/
public class CustomTemplateEngine extends FreemarkerTemplateEngine {

    /**
     * 输出实体文件, 增加了 mapstruct 的 convert
     *
     * @param tableInfo 表信息
     * @param objectMap 渲染数据
     * @since 3.5.0
     */
    @Override
    public void outputEntity(@NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        String entityName = tableInfo.getEntityName();
        String entityPath = getPathInfo(OutputFile.entity);
        if (null == entityPath) {
            return;
        }

        // 生成 entity
        getTemplateFilePath(template -> template.getEntity(getConfigBuilder().getGlobalConfig().isKotlin())).ifPresent((entity) -> {
            String entityFile = String.format((entityPath + File.separator + "%s" + suffixJavaOrKt()), entityName);
            outputFile(new File(entityFile), objectMap, entity, getConfigBuilder().getStrategyConfig().entity().isFileOverride());
        });

        // 生成 convert
        String convertTemplatePath = "convert.java.ftl";
        String entityFile = String.format((entityPath.replace("entity", "convert") + File.separator + "%s" + suffixJavaOrKt()), entityName + "Convert");
        outputFile(new File(entityFile), objectMap, convertTemplatePath, getConfigBuilder().getStrategyConfig().entity().isFileOverride());


    }
}
