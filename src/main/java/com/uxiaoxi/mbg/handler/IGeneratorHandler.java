/**
 * IGeneratorHandler.java
 */
package com.uxiaoxi.mbg.handler;

import java.io.IOException;

import com.uxiaoxi.mbg.handler.bean.GeneratorParams;
import com.uxiaoxi.mbg.handler.bean.TableInfo;

/**
 * @author renhao
 *
 * 2015年5月14日
 */
public interface IGeneratorHandler {

    public void generator(GeneratorParams info, TableInfo ti) throws IOException;
    
    public String getName();
    
}
