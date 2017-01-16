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
        list.add(new TableParams("**","",true));

        
        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("com.mincoo.mpa");
        info.setPackageName("***");
        String project = "mpa-web";
        info.setPath("E:\\git\\mpa\\mpa-parent\\" + project);
        info.setPrePath("/admin");
        info.setPageName("系统用户管理");
//        info.setGridWidth(6);
//
//         info.getIgnoreList().add("controller");
//         info.getIgnoreList().add("dao");
//         info.getIgnoreList().add("html");
//         info.getIgnoreList().add("js");
//         info.getIgnoreList().add("service");
         info.getIgnoreList().add("api");

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
        
        packageMap.put("Page", "com.mincoo.core.page.model.Page");
        packageMap.put("JqPrmNames", "com.mincoo.core.common.vo.JqPrmNames");
        packageMap.put("ResultBean", "com.mincoo.core.common.vo.ResultBean");
        packageMap.put("SqlBean", "com.mincoo.core.common.vo.SqlBean");
        packageMap.put("BaseSupport", "com.mincoo.core.db.impl.BaseSupport");
        packageMap.put("IBaseSupport", "com.mincoo.core.db.IBaseSupport");
        
        info.setPackageMap(packageMap);

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
