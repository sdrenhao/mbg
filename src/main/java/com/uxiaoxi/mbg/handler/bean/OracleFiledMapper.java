/**
 * 
 */
package com.uxiaoxi.mbg.handler.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author renh
 * 创建时间：2018年1月4日
 */
public class OracleFiledMapper implements RowMapper<TableField>{

    @Override
    public TableField mapRow(ResultSet rs, int i) throws SQLException {
        TableField vo = new TableField();
        vo.setField(rs.getString("COLUMN_NAME").toLowerCase());
        String dbtype = rs.getString("DATA_TYPE").toUpperCase();
        String type = "String";
        switch(dbtype) {
        case "NVARCHAR2":
        case "VARCHAR2":
        case "CLOB":
            type = "String";
            break;
        case "NUMBER":
            String dataprecision = rs.getString("DATA_PRECISION");
            String datascale = rs.getString("DATA_SCALE");
            if("20".equals(dataprecision) && "0".endsWith(datascale)) {
                type = "Long";
            }else if("22".equals(dataprecision) && "4".endsWith(datascale)) {
                type = "BigDecimal";
            } else {
                type = "Integer";
            }
            
            break;
        default :
            type = "String";
        }
        vo.setType(type);
        String resComment = rs.getString("COMMENTS");
        if(StringUtils.isNotBlank(resComment)) {
            String[] split = resComment.split("#");
            if (split.length > 1) {
                if (split[1].equals("0")) {
                    vo.setHiddenState(true);
                }
                vo.setComment(split[0]);
            } else {
                vo.setHiddenState(false);
                vo.setComment(resComment);
            }
        }
        return vo;
    }

    
}
