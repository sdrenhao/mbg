/**
 * DaoGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class ApiGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory
            .getLogger(ApiGeneratorHandler.class);
    
    private final static String NAME = "api";

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/api.ftl";
    
    private static final String FORMBEAN_TEMPLATE_NAME = "generator/formbean.ftl";
    
    private static final String VO_TEMPLATE_NAME = "generator/vo.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti)
            throws IOException {

        LOG.debug("controller generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        LOG.debug("开始生成controller");
        create(params, ti, map);
        
//        LOG.debug("开始生成formbean");
//        createFormBean(params, ti, map);
//
//        LOG.debug("开始生成vo");
//        createVO(params, ti, map);
        
        LOG.debug("controller generator end.");
    }

    /**
     * 
     * 生成controller
     * @param params
     * @param ti
     * @param map
     * @throws IOException
     */
    private void create(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params,ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }
    
    
    
    /**
     * 
     * 生成formbean
     * @param params
     * @param ti
     * @param map
     * @throws IOException
     */
    private void createFormBean(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(FORMBEAN_TEMPLATE_NAME, map);
        File file = new File(getFormBeanFileName(params,ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }
    
    
    /**
     * 
     * 生成vo
     * @param params
     * @param ti
     * @param map
     * @throws IOException
     */
    private void createVO(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(VO_TEMPLATE_NAME, map);
        File file = new File(getVOFileName(params,ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }
    
    

    /**
     * 
     * 生成controller的名称
     * @param camelName
     * @return
     */
    private String getName(String camelName) {
        return camelName + "Controller.java";
    }
    
    
    /**
     * 
     * 生成formBean的名称
     * 
     * @param camelName
     * @param params
     * @return
     */
    private List<String> getFormBeanName(String camelName,  GeneratorParams params) {
    	
    	List<String> list = new ArrayList<String>();
    	for(String req : params.getReqPathList()) {
    		list.add(camelName + CommonUtil.camelName(req,false) + "FormBean.java");
    	}
    	
        return list;
    }
    
    /**
     * 
     * 生成VO的名称
     * @param camelName
     * @param params
     * @return
     */
    private  List<String> getVOName(String camelName, GeneratorParams params) {
    	
    	List<String> list = new ArrayList<String>();
    	for(String req :params.getReqPathList()) {
    		list.add(camelName + CommonUtil.camelName(req,false) + "VO.java");
    	}
    	
        return list;
    }
    

    private String getPath(String path, String basepackage) {
        return path + File.separator + CommonUtil.javaBasePath(basepackage) + File.separator + "web";
    }

    private String getFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getPath(), params.getBasePackage()) + File.separator
                + params.getPackageName() + File.separator 
                + "controller" + File.separator
                + getName(ti.getCamelNameU());
    }
    
    private String getFormBeanFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getPath(), params.getBasePackage()) + File.separator
                + params.getPackageName() + File.separator 
                + "formbean" + File.separator 
                + getFormBeanName(ti.getCamelNameU(),params);
    }
    
    
    private String getVOFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getPath(), params.getBasePackage()) + File.separator
                + params.getPackageName() + File.separator 
                + "vo" + File.separator 
                + getVOName(ti.getCamelNameU(),params);
    }

	@Override
	public String getName() {
		return NAME;
	}

}
