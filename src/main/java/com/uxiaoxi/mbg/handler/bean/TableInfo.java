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

    public TableInfo() {

    }

    public TableInfo(String tableName, String omitPrefix) {
        this.tableName = tableName;
        this.camelNameU = CommonUtil.camelNameOmitPrefix(tableName, false, omitPrefix);
        this.camelNameL = CommonUtil.camelNameOmitPrefix(tableName, true, omitPrefix);
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
}
