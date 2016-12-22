/**
 * 
 */
package com.uxiaoxi.mbg.handler.bean;

/**
 * @author renhao
 *
 */
public class TableParams {

    public TableParams(String tableName) {
        super();
        this.tableName = tableName;
        this.omitPrefix = "";
    }

    public TableParams(String tableName, String omitPrefix,boolean removeEndS) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
        this.removeEndS = removeEndS;
    }
    
    public TableParams(String tableName, String omitPrefix) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
        this.removeEndS = false;
    }

    private String tableName;// 表名

    private String omitPrefix;// 省略
    
    private boolean removeEndS;// 去掉末尾的S

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

    public boolean isRemoveEndS() {
        return removeEndS;
    }

    public void setRemoveEndS(boolean removeEndS) {
        this.removeEndS = removeEndS;
    }

}
