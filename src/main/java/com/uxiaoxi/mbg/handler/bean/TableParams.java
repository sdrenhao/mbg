/**
 * 
 */
package com.uxiaoxi.mbg.handler.bean;

/**
 * @author renhao
 *
 */
public class TableParams {

    private String tableName;// 表名

    private String omitPrefix;// 省略
    
    private boolean removeEndS;// 去掉末尾的S
    
    private String prePath; // url前缀
    
    private String pageName; // 页面名称
    
    private Integer gridWidth; // 表格宽度
    
    public TableParams(String tableName) {
        super();
        this.tableName = tableName;
        this.omitPrefix = "";
        this.prePath = "";
        this.pageName= "";
        this.gridWidth = 12;
    }

    public TableParams(String tableName, String omitPrefix) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
        this.removeEndS = false;
        this.prePath = "";
        this.pageName= "";
        this.gridWidth = 12;
    }
    
    public TableParams(String tableName, String omitPrefix,boolean removeEndS) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
        this.removeEndS = removeEndS;
        this.prePath = "";
        this.pageName= "";
        this.gridWidth = 12;
    }
    
    
    public TableParams(String tableName, String omitPrefix,boolean removeEndS,String prePath, String pageName, Integer gridWidth) {
        super();
        this.tableName = tableName;
        this.omitPrefix = omitPrefix;
        this.removeEndS = removeEndS;
        this.prePath = prePath;
        this.pageName= pageName;
        this.gridWidth = gridWidth;
    }


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

    /**
     * @return the prePath
     */
    public String getPrePath() {
        return prePath;
    }

    /**
     * @param prePath the prePath to set
     */
    public void setPrePath(String prePath) {
        this.prePath = prePath;
    }

    /**
     * @return the pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName the pageName to set
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return the gridWidth
     */
    public Integer getGridWidth() {
        return gridWidth;
    }

    /**
     * @param gridWidth the gridWidth to set
     */
    public void setGridWidth(Integer gridWidth) {
        this.gridWidth = gridWidth;
    }


}
