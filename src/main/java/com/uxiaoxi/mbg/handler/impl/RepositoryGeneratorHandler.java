/**
 * RepositoryGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxiaoxi.mbg.freemarker.ITemplateService;
import com.uxiaoxi.mbg.handler.IGeneratorHandler;
import com.uxiaoxi.mbg.handler.bean.GeneratorParams;
import com.uxiaoxi.mbg.handler.bean.TableInfo;
import com.uxiaoxi.mbg.utils.CommonUtil;

/**
 * @author renhao
 *
 *         2015年5月14日
 */
@Service
public class RepositoryGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory.getLogger(RepositoryGeneratorHandler.class);

    private final static String NAME = "repository";

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/repository.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti) throws IOException {

        LOG.debug("repository generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成实现类
        LOG.debug("开始生成repository");
        createImpl(params, ti, map);

        LOG.debug("dao generator end.");
    }



    private void createImpl(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getRepositoryName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

  

    private String getRepositoryName(String camelName) {
        return  "repository" + File.separator +camelName + "Repository.java";
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
