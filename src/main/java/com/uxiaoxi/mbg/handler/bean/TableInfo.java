/**
 * TableInfo.java
 */
package com.uxiaoxi.mbg.handler.bean;

import com.uxiaoxi.mbg.utils.CommonUtil;

/**
 * @author renhao
 *
 *         2015年5月18日
 */
public class TableInfo {

    private String tableName;

    private String camelNameU;

    private String camelNameL;
    
    private TableParams params;
    
    private String nopreTableName;

    public TableInfo() {

    }

    public TableInfo(TableParams params) {
        this.params = params;
        this.tableName = params.getTableName();
        this.camelNameU = CommonUtil.camelNameOmitPrefix(tableName, false, params.getOmitPrefix(),params.isRemoveEndS());
        this.camelNameL = CommonUtil.camelNameOmitPrefix(tableName, true, params.getOmitPrefix(),params.isRemoveEndS());
        this.nopreTableName = CommonUtil.removePre(tableName,params.getOmitPrefix());
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName
     *            the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the camelNameU
     */
    public String getCamelNameU() {
        return camelNameU;
    }

    /**
     * @param camelNameU
     *            the camelNameU to set
     */
    public void setCamelNameU(String camelNameU) {
        this.camelNameU = camelNameU;
    }

    /**
     * @return the camelNameL
     */
    public String getCamelNameL() {
        return camelNameL;
    }

    /**
     * @param camelNameL
     *            the camelNameL to set
     */
    public void setCamelNameL(String camelNameL) {
        this.camelNameL = camelNameL;
    }

    /**
     * @return the params
     */
    public TableParams getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(TableParams params) {
        this.params = params;
    }

    public String getNopreTableName() {
        return nopreTableName;
    }

    public void setNopreTableName(String nopreTableName) {
        this.nopreTableName = nopreTableName;
    }
}
