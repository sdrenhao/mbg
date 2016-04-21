package com.uxiaoxi.mbg.handler.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FiledsMapper implements RowMapper<TableField> {

    public TableField mapRow(ResultSet rs, int i) throws SQLException {
        TableField vo = new TableField();
        vo.setField(rs.getString("Field"));
        vo.setType(rs.getString("Type"));
        vo.setCollation(rs.getString("Collation"));
        vo.setNull(rs.getString("Null"));
        vo.setKey(rs.getString("Key"));
        vo.setDefault(rs.getString("Default"));
        vo.setExtra(rs.getString("Extra"));
        vo.setPrivileges(rs.getString("Privileges"));
        String resComment = rs.getString("Comment");
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
        return vo;
    }
}