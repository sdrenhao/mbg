/**
 * Generator.java
 */
package com.uxiaoxi.mbg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.uxiaoxi.mbg.handler.IGeneratorHandler;
import com.uxiaoxi.mbg.handler.bean.GeneratorParams;
import com.uxiaoxi.mbg.handler.bean.TableInfo;
import com.uxiaoxi.mbg.handler.bean.TableParams;


/**
 * @author renhao01@hecom.cn
 * 创建时间：2017年11月9日
 */
public class Generator {

    private static ApplicationContext ctx;

    /** 
     * @param args
     */
    public static void main(String[] args) {

        ctx = new FileSystemXmlApplicationContext("src/main/resources/ApplicationContext.xml");

        List<TableParams> list = new ArrayList<TableParams>();
        
//        list.add(new TableParams("p_dict_category","dict","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_dict_comment_tag","dict","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_dict_plugin_entrance","dict","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_dict_plugin_permission","dict","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_dict_plugin_structure","dict","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_basic_info","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_comment_tag","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_comment_text","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_description","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_developer","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_display_info","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_service","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_setting_info","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_setup_info","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_structure_info","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_version","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_ref_plugin_category","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_ref_plugin_ent","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_ref_plugin_permission","plugin","p_",true,"/plugin","",6));
        
//        list.add(new TableParams("p_ref_plugin_default_entrance","plugin","p_",true,"/plugin","",6));
//        list.add(new TableParams("p_plugin_white_list","plugin","p_",true,"/plugin","",6));
        list.add(new TableParams("p_plugin_isv_permanent_code","plugin","p_",true,"/plugin","",6));
        
        
        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("cn.hecom.plugin.store");
        info.setPath("/Users/renhao/git/hq-mgmt/");
        info.setDaoPath(info.getPath()+"plugin-store");
        info.setServicePath(info.getPath()+"plugin-store");
        info.setWebPath(info.getPath()+"plugin-store");
        
         info.getQueueSet().add("entity");
         info.getQueueSet().add("repository");
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
