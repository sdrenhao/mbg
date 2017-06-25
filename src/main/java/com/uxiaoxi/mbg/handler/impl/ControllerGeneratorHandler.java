/**
 * DaoGeneratorHandler.java
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
public class ControllerGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory
            .getLogger(ControllerGeneratorHandler.class);
    
    private final static String NAME = "controller";

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/controller.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti)
            throws IOException {

        LOG.debug("controller generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        LOG.debug("开始生成controller");
        create(params, ti, map);

        LOG.debug("controller generator end.");
    }

    private void create(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params,ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private String getName(String camelName) {
        return camelName + "Controller.java";
    }

    private String getPath(String path, String basepackage) {
        return path + File.separator + CommonUtil.javaBasePath(basepackage) + File.separator + "web";
    }

    private String getFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getWebPath(), params.getBasePackage()) + File.separator
                + ti.getParams().getPackageName() + File.separator 
                + "controller" + File.separator
                + getName(ti.getCamelNameU());
    }

	@Override
	public String getName() {
		return NAME;
	}

}
