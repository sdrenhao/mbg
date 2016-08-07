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
public class ServiceGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory.getLogger(ServiceGeneratorHandler.class);

    private final static String NAME = "service";

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/service_impl.ftl";

    private static final String INTERFACE_TEMPLATE_NAME = "generator/service_interface.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti) throws IOException {
        
        LOG.debug("service generator exec.");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成接口
        LOG.debug("开始生成service接口");
        createInterface(params,ti, map);
        // 生成实现类
        LOG.debug("开始生成service实现类");
        createImpl(params,ti, map);
        
        LOG.debug("service generator end.");
    }

    private void createInterface(GeneratorParams params,TableInfo ti, Map<String, Object> map)
            throws IOException {
        String fileString = templateService.getHtmlText(INTERFACE_TEMPLATE_NAME, map);
        File file = new File(getFileName(params,ti,getInterfaceName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private void createImpl(GeneratorParams params,TableInfo ti, Map<String, Object> map)
            throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params,ti,getImplName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private String getInterfaceName(String camelName) {
        return "I" + camelName + "Service.java";
    }

    private String getImplName(String camelName) {
        return "impl" + File.separator + camelName + "ServiceImpl.java";
    }

    private String getPath(String path, String basepackage) {
        return path + File.separator + CommonUtil.javaBasePath(basepackage) + File.separator + "biz";
    }
    
    private String getFileName(GeneratorParams params, TableInfo ti,String name) {
        return getPath(params.getPath(), params.getBasePackage()) + File.separator
                + params.getPackageName() + File.separator
                + name;
    }

	@Override
	public String getName() {
		return NAME;
	}
    
}
