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

/**
 * @author renhao
 *
 * 2015年2月28日
 */
@Controller
@RequestMapping("${params.prePath!""}/${params.packageName}")
public class ${table.camelNameU}Controller {
    
    @Autowired
    private I${table.camelNameU}Service ${table.camelNameL}Service;
    
    @RequestMapping("/${table.tableName}")
    public String display() {
        return "${params.packageName}/${table.camelNameL}";
    }
    
    @ResponseBody
    @RequestMapping("/${table.tableName}/data")
    public Page<${table.camelNameU}> getData(JqPrmNames parm) {
        return ${table.camelNameL}Service.getData(parm.getSqlBean(), parm.getPage_no(),
                parm.getPage_size());
    }

    @ResponseBody
    @RequestMapping("/${table.tableName}/add")
    public ResultBean add(${table.camelNameU} ${table.camelNameL}){
        ResultBean rs = ${table.camelNameL}Service.add(${table.camelNameL});
        return rs;
    }
    
    @ResponseBody
    @RequestMapping("/${table.tableName}/edit")
    public ResultBean edit(${table.camelNameU} ${table.camelNameL}){
        ResultBean rs = ${table.camelNameL}Service.edit(${table.camelNameL});
        return rs;
    }
    
    @ResponseBody
    @RequestMapping("/${table.tableName}/del")
    public ResultBean del(Long id){
        ResultBean rs = ${table.camelNameL}Service.del(id);
        return rs;
    }

}
