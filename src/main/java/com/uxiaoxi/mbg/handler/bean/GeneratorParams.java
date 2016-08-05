/**
 * GeneratorParams.java
 */
package com.uxiaoxi.mbg.handler.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author renhao
 *
 * 2015年5月14日
 */
public class GeneratorParams {
    
    private String path;
    
    /**
     * 基础包名
     */
    private String basePackage;
    
    /**
     * 包名
     */
    private String packageName;
    
    /**
     * url前缀
     */
    private String prePath;
    
    /**
     * 页面名称
     */
    private String pageName;
    
    /**
     * 生成的grid的宽度，采用bootstrap的栅格系统
     */
    private Integer gridWidth;
    
    /**
     * 忽略列表
     */
    private List<String> ignoreList;
    
    /**
     * api的请求地址
     */
    private List<String> reqPathList;
    

    public GeneratorParams (){
    	
    	gridWidth = 12;
    	ignoreList = new ArrayList<String>();
    }
    

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the basePackage
     */
    public String getBasePackage() {
        return basePackage;
    }

    /**
     * @param basePackage the basePackage to set
     */
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


	public String getPrePath() {
		return prePath;
	}


	public void setPrePath(String prePath) {
		this.prePath = prePath;
	}


	public String getPageName() {
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


	public Integer getGridWidth() {
		return gridWidth;
	}


	public void setGridWidth(Integer gridWidth) {
		this.gridWidth = gridWidth;
	}


	public List<String> getIgnoreList() {
		return ignoreList;
	}


	public void setIgnoreList(List<String> ignoreList) {
		this.ignoreList = ignoreList;
	}


	public List<String> getReqPathList() {
		return reqPathList;
	}


	public void setReqPathList(List<String> reqPathList) {
		this.reqPathList = reqPathList;
	}


    
}
