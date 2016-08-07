/**
 * Generator.java
 */
package com.uxiaoxi.mbg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.uxiaoxi.mbg.handler.IGeneratorHandler;
import com.uxiaoxi.mbg.handler.bean.GeneratorParams;
import com.uxiaoxi.mbg.handler.bean.TableInfo;
import com.uxiaoxi.mbg.handler.bean.TableParams;

/**
 * @author renhao
 *
 *         2015年5月14日
 */
public class Generator {

    private static ApplicationContext ctx;

    /**
     * @param args
     */
    public static void main(String[] args) {

        ctx = new FileSystemXmlApplicationContext("src/main/resources/ApplicationContext.xml");

        List<TableParams> list = new ArrayList<TableParams>();
        list.add(new TableParams("yyms_advertisement","yyms_"));
        list.add(new TableParams("yyms_banner","yyms_"));
        list.add(new TableParams("yyms_apply","yyms_"));
        list.add(new TableParams("yyms_apply_state","yyms_"));
        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("com.mincoo.yunyams");
        info.setPackageName("homepage");
        String project = "yunyams";
        info.setPath("E:\\git\\yunyams\\" + project);
        info.setPrePath("");
        info.setPageName("前台显示");
        info.setGridWidth(6);

        // info.getIgnoreList().add("controller");
        // info.getIgnoreList().add("dao");
        // info.getIgnoreList().add("html");
        // info.getIgnoreList().add("js");
        // info.getIgnoreList().add("service");
        info.getIgnoreList().add("api");

        // api请求路径，生成api的时候有用
        List<String> reqPathList = new ArrayList<String>();
        reqPathList.add("");
        info.setReqPathList(reqPathList);

        List<TableInfo> tableList = new ArrayList<TableInfo>();
        for (TableParams tname : list) {
            TableInfo tinfo = new TableInfo(tname.getTableName(), tname.getOmitPrefix());
            tableList.add(tinfo);
        }

        for (TableInfo ti : tableList) {

            try {
                // 通过applicationContext找到所有的处理类
                String[] beanNames = ctx.getBeanNamesForType(IGeneratorHandler.class);
                for (String beanName : beanNames) {
                    IGeneratorHandler handler = (IGeneratorHandler) ctx.getBean(beanName);

                    // 如果在忽略列表里则不生成
                    if (!info.getIgnoreList().contains(handler.getName())) {
                        handler.generator(info, ti);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
