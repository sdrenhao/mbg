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
public class HtmlGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory
            .getLogger(HtmlGeneratorHandler.class);
    
    private final static String NAME = "html";

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/html.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti)
            throws IOException {

        LOG.debug("html generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成接口
        LOG.debug("开始生成html");
        create(params, ti, map);

        LOG.debug("html generator end.");
    }

    private void create(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params,ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private String getName(String camelName) {
        return camelName + ".html";
    }

    private String getPath(String path) {
        return path + File.separator + CommonUtil.htmlBasePath();
    }

    private String getFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getPath() + params.getRealPathMap().get(NAME)) + File.separator
                + params.getPackageName() + File.separator
                + getName(ti.getCamelNameL());
    }

	@Override
	public String getName() {
		return NAME;
	}
	
}
