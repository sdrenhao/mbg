/**
 * GeneratorParams.java
 */
package com.uxiaoxi.mbg.handler.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author renhao
 *
 * 2015年5月14日
 */
public class GeneratorParams {
    
    /**
     * parent项目路径
     */
    private String path;
    
    /**
     * dao项目路径
     */
    private String daoPath;
    
    /**
     * service项目路径
     */
    private String servicePath;
    
    /**
     * web项目路径
     */
    private String webPath;
    
    /**
     * 基础包名
     */
    private String basePackage;
    
    /**
     * 包名
     */
    private String packageName;
    
    /**
     * 忽略列表
     */
//    private List<String> ignoreList;
    
    private Set<String> queueSet;
    
    /**
     * api的请求地址
     */
    private List<String> reqPathList;
    
    
    private Map<String,String> packageMap;
    

    public GeneratorParams (){
    	
//    	ignoreList = new ArrayList<String>();
    	queueSet = new HashSet<String>();
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

//	public List<String> getIgnoreList() {
//		return ignoreList;
//	}
//
//
//	public void setIgnoreList(List<String> ignoreList) {
//		this.ignoreList = ignoreList;
//	}


	public List<String> getReqPathList() {
		return reqPathList;
	}


	public void setReqPathList(List<String> reqPathList) {
		this.reqPathList = reqPathList;
	}


    public Map<String, String> getPackageMap() {
        return packageMap;
    }


    public void setPackageMap(Map<String, String> packageMap) {
        this.packageMap = packageMap;
    }


    /**
     * @return the daoPath
     */
    public String getDaoPath() {
        return daoPath;
    }


    /**
     * @param daoPath the daoPath to set
     */
    public void setDaoPath(String daoPath) {
        this.daoPath = daoPath;
    }


    /**
     * @return the servicePath
     */
    public String getServicePath() {
        return servicePath;
    }


    /**
     * @param servicePath the servicePath to set
     */
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }


    /**
     * @return the webPath
     */
    public String getWebPath() {
        return webPath;
    }


    /**
     * @param webPath the webPath to set
     */
    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }


    /**
     * @return the queueSet
     */
    public Set<String> getQueueSet() {
        return queueSet;
    }


    /**
     * @param queueSet the queueSet to set
     */
    public void setQueueSet(Set<String> queueSet) {
        this.queueSet = queueSet;
    }


    
}
