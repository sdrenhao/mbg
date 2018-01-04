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
public class DaoGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory.getLogger(DaoGeneratorHandler.class);

    private final static String NAME = "dao";

    @Autowired
    private ITemplateService templateService;

    private static final String DAO_EMPLATE_NAME = "generator/dao.ftl";
    
    private static final String DAOIMPL_TEMPLATE_NAME = "generator/dao_impl.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti) throws IOException {

        LOG.debug("dao generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成接口
        LOG.debug("开始生成dao");
        createDao(params, ti, map);
        
        // 生成实现类
        LOG.debug("开始生成daoimpl");
        createDaoImpl(params, ti, map);

        LOG.debug("dao generator end.");
    }



    private void createDao(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(DAO_EMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getDaoName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }


    private void createDaoImpl(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(DAOIMPL_TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getDaoImplName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }
    

    private String getDaoName(String camelName) {
        return  "dao" + File.separator +camelName + "Dao.java";
    }
    

    private String getDaoImplName(String camelName) {
        return  "dao" + File.separator + "impl" + File.separator +camelName + "DaoImpl.java";
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
