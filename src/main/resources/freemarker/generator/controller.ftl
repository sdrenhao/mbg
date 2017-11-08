/**
 * ${table.camelNameU}Controller.java
 */
package ${params.basePackage}.${table.params.packageName}.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import ${params.basePackage}.${table.params.packageName}.service.${table.camelNameU}Service;
import cn.hecom.plugin.store.commons.model.CommonHeaders;
import cn.hecom.plugin.store.commons.model.ResponseResult;


@Controller
@RequestMapping("${table.params.prePath!""}/${table.params.packageName}")
public class ${table.camelNameU}Controller {

    private static final Logger LOGGER = Logger.getLogger(${table.camelNameU}Controller.class);

    @Autowired
    private ${table.camelNameU}Service ${table.camelNameL}Service;



}
