/**
 * CommonUtil.java
 */
package com.uxiaoxi.mbg.utils;

import java.io.File;
import java.util.regex.Matcher;


/**
 * @author renh
 * 
 *         2013-4-10
 */
public class CommonUtil {

    private static final String PASSWORD_KEY = "cts.uxiaoxi.com";
    
    public static final String SEPARATE = ",";

    public static final String INIT_PASSWORD = "123456";

    /**
     * 上传表格时接受的文件类型
     */
    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";

    /**
     * 自定义密码算法
     * 
     */
    public static String password(String password) {

        return StringUtil.md5(password + PASSWORD_KEY);
    }
    
    public static String camelName(String name,boolean fistLower) {
        StringBuilder result = new StringBuilder();
        if (name == null || name.isEmpty()) {
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            if(fistLower) {
                return name.substring(0, 1).toLowerCase() + name.substring(1);
            } else {
                return name.substring(0, 1).toUpperCase() + name.substring(1);
            }
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (fistLower && result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
    
    public static String javaBasePath(String basepackage){
        String path = "src" + File.separator + "main" + File.separator + "java";
        path = path + File.separator + basepackage.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        return path;
    }
    
    public static String jsBasePath(){
        String path = "src"+ File.separator+ "main"+ File.separator+ "webapp"+ File.separator+ "js";
        return path;
    }
    
    public static String htmlBasePath(){
        
        String path = "src"+ File.separator+ "main"+ File.separator+ "resources"+ File.separator+ "freemarker";
        return path;
    }
    
    public static String xmlBasePath(){

        String path = "src"+ File.separator+ "main"+ File.separator+ "resources"+ File.separator + "mybatis" + File.separator + "mappers";
        return path;
    }
    
    
    public static void main(String []args){
        // d82732f59d857877837edb1bae606a    123456
//        System.out.println(CommonUtil.password("123456"));
        System.out.println(javaBasePath("com.uxiaoxi.ym"));
    }

}
