/**
 * 
 */
package com.uxiaoxi.mbg.handler.bean;

/**
 * @author zhaocm 表格参数 2016年8月5日
 */
public class TableParams {

    public TableParams(String tableName) {
        super();
        this.tableName = tableName;
        this.omitPrefix = "";
    }

    public TableParams(String tableName, String omitPrefix) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
    }

    private String tableName;// 表名

    private String omitPrefix;// 省略

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOmitPrefix() {
        return omitPrefix;
    }

    public void setOmitPrefix(String omitPrefix) {
        this.omitPrefix = omitPrefix;
    }

}
