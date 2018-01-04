/**
 * ${table.camelNameU}Controller.java
 */
package ${params.basePackage}.${table.params.packageName}.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ${params.basePackage}.${table.params.packageName}.service.${table.camelNameU}Service;



@Controller
@RequestMapping("${table.params.prePath!""}/${table.params.packageName}")
public class ${table.camelNameU}Controller {

    private static final Logger logger = LoggerFactory.getLogger(${table.camelNameU}Controller.class);

    @Autowired
    private ${table.camelNameU}Service ${table.camelNameL}Service;



}
