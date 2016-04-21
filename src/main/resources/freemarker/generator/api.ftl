/**
 * ${table.camelNameU}Controller.java
 */
package ${params.basePackage}.web.${params.packageName}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${params.basePackage}.biz.${params.packageName}.I${table.camelNameU}Service;
import ${params.basePackage}.db.${params.packageName}.dto.${table.camelNameU};
import ${params.basePackage}.framework.page.model.Page;
import ${params.basePackage}.web.common.vo.JqPrmNames;
import ${params.basePackage}.web.common.vo.ResultBean;
import ${params.basePackage}.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
@Controller
@RequestMapping("${params.prePath!""}/${params.packageName}")
public class ${table.camelNameU}ApiController {
    
    @Autowired
    private I${table.camelNameU}Service ${table.camelNameL}Service;
    
    <#if params.reqPathList??>
    <#list params.reqPathList as path>
    
    @ResponseBody
    @RequestMapping("/${path}")
    public ResResult ${path}() {
        return ${table.camelNameL}Service.${path}();
    }
    </#list>
    </#if>

}
