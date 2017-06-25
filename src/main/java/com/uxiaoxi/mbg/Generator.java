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
        list.add(new TableParams("unisedu_megagame_class","unisedu_",false,"/admin","班级管理",12));
        list.add(new TableParams("unisedu_megagame_class_type","unisedu_",false,"/admin","班级分类",12));
        list.add(new TableParams("unisedu_megagame_class_teacher","unisedu_",false,"/admin","班主任",12));
        list.add(new TableParams("unisedu_megagame_teacher_resources","unisedu_",true,"/admin","班主任管理",12));

        
        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("com.unisedu.megagame");
        info.setPackageName("megaclass");
        info.setPath("E:\\git\\unisedu\\codes\\unisedu-parent\\");
        info.setDaoPath(info.getPath()+"unisedu-megagame-dao");
        info.setServicePath(info.getPath()+"unisedu-megagame-service");
        info.setWebPath(info.getPath()+"unisedu-megagame-web");
        
         info.getQueueSet().add("controller");
         info.getQueueSet().add("dao");
         info.getQueueSet().add("html");
         info.getQueueSet().add("js");
         info.getQueueSet().add("service");
//         info.getQueueSet().add("api");

        // api请求路径，生成api的时候有用
        List<String> reqPathList = new ArrayList<String>();
        reqPathList.add("");
        info.setReqPathList(reqPathList);

        List<TableInfo> tableList = new ArrayList<TableInfo>();
        for (TableParams tname : list) {
            TableInfo tinfo = new TableInfo(tname.getTableName(), tname.getOmitPrefix(), tname.isRemoveEndS());
            tableList.add(tinfo);
        }
        
        Map<String,String> packageMap = new HashMap<String,String>();
        
        packageMap.put("Page", "com.mincoo.framework.page.model.Page");
        packageMap.put("JqPrmNames", "com.mincoo.framework.common.vo.JqPrmNames");
        packageMap.put("ResultBean", "com.mincoo.framework.common.vo.ResultBean");
        packageMap.put("SqlBean", "com.mincoo.framework.common.vo.SqlBean");
        packageMap.put("BaseSupport", "com.mincoo.framework.db.impl.BaseSupport");
        packageMap.put("IBaseSupport", "com.mincoo.framework.db.IBaseSupport");
        packageMap.put("SecurityUser", "com.unisedu.security.mdoel.SecurityUser");
        
        info.setPackageMap(packageMap);

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
