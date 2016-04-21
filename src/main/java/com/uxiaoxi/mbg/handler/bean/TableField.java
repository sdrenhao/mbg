/**
 * TableField.java
 */
package com.uxiaoxi.mbg.handler.bean;

/**
 * @author renhao
 *
 * 2015年5月19日
 */
public class TableField {

    private String Field;
    
    private String Type;
    
    private String Collation;
    
    private String Null;
    
    private String Key;
    
    private String Default;
    
    private String Extra;
    
    private String Privileges;
    
    private String Comment;
    
    private boolean HiddenState;
    
    /**
     * @return the field
     */
    public String getField() {
        return Field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        Field = field;
    }

    /**
     * @return the type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        Type = type;
    }

    /**
     * @return the collation
     */
    public String getCollation() {
        return Collation;
    }

    /**
     * @param collation the collation to set
     */
    public void setCollation(String collation) {
        Collation = collation;
    }

    /**
     * @return the null
     */
    public String getNull() {
        return Null;
    }

    /**
     * @param null1 the null to set
     */
    public void setNull(String null1) {
        Null = null1;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return Key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        Key = key;
    }

    /**
     * @return the default
     */
    public String getDefault() {
        return Default;
    }

    /**
     * @param default1 the default to set
     */
    public void setDefault(String default1) {
        Default = default1;
    }

    /**
     * @return the extra
     */
    public String getExtra() {
        return Extra;
    }

    /**
     * @param extra the extra to set
     */
    public void setExtra(String extra) {
        Extra = extra;
    }

    /**
     * @return the privileges
     */
    public String getPrivileges() {
        return Privileges;
    }

    /**
     * @param privileges the privileges to set
     */
    public void setPrivileges(String privileges) {
        Privileges = privileges;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return Comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        Comment = comment;
    }

	public boolean isHiddenState() {
		return HiddenState;
	}

	public void setHiddenState(boolean hiddenState) {
		HiddenState = hiddenState;
	}
    
    
    
}
