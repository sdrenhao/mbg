/**
 * ${table.camelNameU}Controller.java
 */
package ${params.basePackage}.web.${table.params.packageName}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${params.basePackage}.biz.${table.params.packageName}.I${table.camelNameU}Service;
import ${params.basePackage}.db.${table.params.packageName}.dto.${table.camelNameU};
import ${params.packageMap["Page"]};
import ${params.packageMap["JqPrmNames"]};
import ${params.packageMap["ResultBean"]};
import ${params.packageMap["ResResult"]};

/**
 * @author mbg
 *
 * ${.now?date}
 */
@Controller
@RequestMapping("${table.params.prePath!""}/${table.params.packageName}")
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
