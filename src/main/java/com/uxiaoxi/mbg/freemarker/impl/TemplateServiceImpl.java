/**
 * TemplateServiceImpl.java
 */
package com.uxiaoxi.mbg.freemarker.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.uxiaoxi.mbg.freemarker.ITemplateService;

import freemarker.template.Template;

/**
 * @author zhaocm
 *
 * 2014-5-12
 */
@Service
public class TemplateServiceImpl implements ITemplateService{
    
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;// FreeMarker的技术类
    
    
    private static final Logger logger = LoggerFactory
            .getLogger(TemplateServiceImpl.class);
    
    @Override
    public  String getHtmlText(String templateName,Map<String, Object> map) {
        
        String htmlText = "";
        try {
            // 通过指定模板名获取FreeMarker模板实例
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);

            htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl,map);
        } catch (Exception e) {
            logger.error("获取模版失败!");
        }
        return htmlText;
    }

}
