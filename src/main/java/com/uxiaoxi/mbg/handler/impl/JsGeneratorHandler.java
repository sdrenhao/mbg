/**
 * DaoGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
public class JsGeneratorHandler implements IGeneratorHandler {

    private Logger LOG = LoggerFactory.getLogger(JsGeneratorHandler.class);
    
    private final static String NAME = "js";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ITemplateService templateService;

    private static final String TEMPLATE_NAME = "generator/js.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti)
            throws IOException {

        LOG.debug("controller generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成接口
        LOG.debug("开始生成js");
        create(params, ti, map);

        LOG.debug("js generator end.");
    }

    private void create(GeneratorParams params, TableInfo ti,
            Map<String, Object> map) throws IOException {
        String sql = "SHOW FULL FIELDS FROM " + ti.getTableName();
        List<TableField> list = jdbcTemplate.query(sql, new FiledsMapper());
        map.put("tableFieldList", list);
        
        for(TableField tf : list) {
        	String comment = tf.getComment();
        	if(StringUtils.contains(tf.getComment(), "hidden")) {
        		tf.setHiddenState(true);
        	}
        	
        	// 将注释里的“{” 删除掉
        	if(comment.indexOf("{") > -1) {
        		tf.setComment(comment.substring(0, comment.indexOf("{")));
        	}
        }

        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());

    }

    private String getName(String camelName) {
        return camelName + ".js";
    }

    private String getPath(String path) {
        return path + File.separator + CommonUtil.jsBasePath();
    }

    private String getFileName(GeneratorParams params, TableInfo ti) {
        return getPath(params.getPath())  + File.separator
                + params.getPackageName() + File.separator
                + getName(ti.getCamelNameL());
    }
    

	@Override
	public String getName() {
		return NAME;
	}
	
}
