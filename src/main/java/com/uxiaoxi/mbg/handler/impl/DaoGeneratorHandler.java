/**
 * DaoGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    private static final String TEMPLATE_NAME = "generator/dao_impl.ftl";

    private static final String INTERFACE_TEMPLATE_NAME = "generator/dao_interface.ftl";

    private static final String XMLPAGEMETHOD_TEMPLATE_NAME = "generator/xml_page_method.ftl";

    @Override
    public void generator(GeneratorParams params, TableInfo ti) throws IOException {

        LOG.debug("dao generator exec.");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("params", params);
        map.put("table", ti);

        // 生成接口
        LOG.debug("开始生成dao接口");
        createInterface(params, ti, map);
        // 生成实现类
        LOG.debug("开始生成dao实现类");
        createImpl(params, ti, map);

        // 生成分页方法
        LOG.debug("开始生成分页方法");
        xmlPageMethod(params, ti, map);

        LOG.debug("dao generator end.");
    }

    private void createInterface(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(INTERFACE_TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getInterfaceName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private void createImpl(GeneratorParams params, TableInfo ti, Map<String, Object> map) throws IOException {
        String fileString = templateService.getHtmlText(TEMPLATE_NAME, map);
        File file = new File(getFileName(params, ti, getImplName(ti.getCamelNameU())));
        FileUtils.writeStringToFile(file, fileString);
        LOG.debug("Filename = " + file.getAbsolutePath());
    }

    private String getInterfaceName(String camelName) {
        return "I" + camelName + "Dao.java";
    }

    private String getImplName(String camelName) {
        return "impl" + File.separator + camelName + "DaoImpl.java";
    }

    private String getPath(String path, String basepackage) {
        return path + File.separator + CommonUtil.javaBasePath(basepackage) + File.separator + "db";
    }

    private String getFileName(GeneratorParams params, TableInfo ti, String name) {
        return getPath(params.getPath(), params.getBasePackage()) + File.separator + params.getPackageName()
                + File.separator + "dao" + File.separator + name;
    }

    private void xmlPageMethod(GeneratorParams params, TableInfo ti, Map<String, Object> map) {
        String fileString = templateService.getHtmlText(XMLPAGEMETHOD_TEMPLATE_NAME, map);
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(getXmlFileName(params, ti), "rw");

            String lineStr="";
            Long currentLinePos = raf.getFilePointer();
            Long nextLinePos = currentLinePos;
            Long startLinePos = null;
            Long endLinePos = null;

            while (lineStr != null) {
                nextLinePos = raf.getFilePointer();

                if (lineStr.indexOf("@mcggenerated") > 0) {
                    startLinePos = currentLinePos - 8l;
                }

                if (lineStr.indexOf("</select>") > 0) {
                    endLinePos = nextLinePos;
                }

                currentLinePos = nextLinePos;
                
                lineStr = raf.readLine();
            }

            if (null == startLinePos || null == endLinePos) {
                startLinePos = raf.length() - 10l;
                endLinePos = startLinePos;
            }
            
            // 取得此光标后面的内容
            String afterContent = this.getAfterContent(raf, endLinePos);
            
            raf.seek(startLinePos);
            raf.write((fileString + afterContent).getBytes("utf-8"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getXmlFileName(GeneratorParams params, TableInfo ti) {

        return params.getPath() + File.separator + CommonUtil.javaBasePath(params.getBasePackage()) + File.separator
                + "db" + File.separator + params.getPackageName() + File.separator + "mapper" + File.separator
                + ti.getCamelNameU() + "Mapper.xml";

        // return params.getPath() + File.separator + CommonUtil.xmlBasePath()
        // + File.separator + params.getPackageName() + File.separator
        // + ti.getCamelNameU() + "Mapper.xml";
    }

    @Override
    public String getName() {
        return NAME;
    }

    private String getAfterContent(RandomAccessFile file, Long statPos ) {
        StringBuffer sb = new StringBuffer();
        
        try {
            file.seek(statPos);
            String lineStr = "" ;
            while((lineStr= file.readLine()) != null) {
                sb.append("\n");
                sb.append(lineStr);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return sb.toString();
        
    }

}
