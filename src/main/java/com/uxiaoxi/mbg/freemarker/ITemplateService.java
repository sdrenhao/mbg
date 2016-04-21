/**
 * ITemplateService.java
 */
package com.uxiaoxi.mbg.freemarker;

import java.util.Map;

/**
 * @author zhaocm
 *
 * 2014-5-12
 */
public interface ITemplateService {
    
    /**
     * 取得html，text模版
     * @param templateName
     * @param map
     * @return
     */
    public String getHtmlText(String templateName, Map<String, Object> map);
}
