/**
 * RepositoryGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.uxiaoxi.mbg.freemarker.ITemplateService;
import com.uxiaoxi.mbg.handler.IGeneratorHandler;
import com.uxiaoxi.mbg.handler.bean.FiledsMapper;
import com.uxiaoxi.mbg.handler.bean.GeneratorParams;
import com.uxiaoxi.mbg.handler.bean.TableField;
import com.uxiaoxi.mbg.handler.bean.TableInfo;
import com.uxiaoxi.mbg.utils.CommonUtil;

/**
 * @author renhao
 *
 *         2015年5月14日
 */
@Service
public class EntityGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory.getLogger(EntityGeneratorHandler.class);

    private final static String NAME = "entity";

    @Autowired
    private ITemplateService templateService;

    private static final String INTERFACE_TEMPLATE_NAME = "generator/entity.ftl";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void generator(GeneratorParams params, TableInfo ti) throws IOException {

        LOG.debug("entity generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);
        
        String sql = "SHOW FULL FIELDS FROM " + ti.getTableName();
        List<TableField> list = jdbcTemplate.query(sql, new FiledsMapper());
        map.put("tableFieldList", list);

        // 生成接口
        LOG.debug("开始生成entity");
        createInterface(params, ti, map);

        LOG.debug("dao generator end.");
    }

    private void createInterface(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(INTERFACE_TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getEntityName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private String getEntityName(String camelName) {
        return "entity" + File.separator +camelName + ".java";
    }


    private String getPath(String path, String basepackage) {
        return path + File.separator + CommonUtil.javaBasePath(basepackage);
    }

    private String getFileName(GeneratorParams params, TableInfo ti, String name) {
        return getPath(params.getDaoPath(), params.getBasePackage()) + File.separator + ti.getParams().getPackageName()
                + File.separator + name;
    }

    @Override
    public String getName() {
        return NAME;
    }


}
