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

        list.add(new TableParams("p_plugin_basic_info","plugin","p_",true,"/plugin","",6));
        list.add(new TableParams("p_dict_comment_tag","comment","p_",true,"/plugin","",6));
        list.add(new TableParams("p_plugin_comment_tag","comment","p_",true,"/plugin","",6));
        list.add(new TableParams("p_plugin_comment_text","comment","p_",true,"/plugin","",6));


        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("cn.hecom.plugin.store");
        info.setPath("/Users/renhao/git/hq-mgmt/");
        info.setDaoPath(info.getPath()+"plugin-store");
        info.setServicePath(info.getPath()+"plugin-store");
        info.setWebPath(info.getPath()+"plugin-store");
        
         info.getQueueSet().add("dao");
//         info.getQueueSet().add("service");
//         info.getQueueSet().add("controller");

         
        // api请求路径，生成api的时候有用
        List<String> reqPathList = new ArrayList<String>();
        reqPathList.add("");
        info.setReqPathList(reqPathList);

        List<TableInfo> tableList = new ArrayList<TableInfo>();
        for (TableParams tname : list) {
            TableInfo tinfo = new TableInfo(tname);
            tableList.add(tinfo);
        }
        

        for (TableInfo ti : tableList) {

            try {
                // 通过applicationContext找到所有的处理类
                String[] beanNames = ctx.getBeanNamesForType(IGeneratorHandler.class);
                for (String beanName : beanNames) {
                    IGeneratorHandler handler = (IGeneratorHandler) ctx.getBean(beanName);

                    // 如果在列表里则生成
                    if (info.getQueueSet().contains(handler.getName())) {
                        handler.generator(info, ti);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
