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
        

//        list.add(new TableParams("t_h_psi_order_attachments","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_refund","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_receipt","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_account_info","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_receipt_attachs","order","t_h_psi_",true,"/psi","",6));
        list.add(new TableParams("t_h_psi_orders","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_models","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_customer_consignees","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_consignees","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_comment","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_customer_invoices","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_invoices","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_flow","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_ent_order_flow","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_wareh_out","order","t_h_psi_",true,"/psi","",6));
//        list.add(new TableParams("t_h_psi_order_delivery","order","t_h_psi_",true,"/psi","",6));
        
        
        // 设置参数
        GeneratorParams info = new GeneratorParams();
        info.setBasePackage("cn.hecom.hqt.psi");
        info.setPath("/Users/renhao/git_hecom/hq-mgmt/");
        info.setDaoPath(info.getPath()+"hqt-psi");
        info.setServicePath(info.getPath()+"hqt-psi");
        info.setWebPath(info.getPath()+"hqt-psi");
        
//         info.getQueueSet().add("entity");
         
//         info.getQueueSet().add("dao");
//         info.getQueueSet().add("service");
         info.getQueueSet().add("controller");

         
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
