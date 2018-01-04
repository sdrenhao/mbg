/**
 * ${table.camelNameU}ServiceImpl.java
 */
package ${params.basePackage}.${table.params.packageName}.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${params.basePackage}.${table.params.packageName}.entity.${table.camelNameU};
import ${params.basePackage}.${table.params.packageName}.dao.${table.camelNameU}Dao;
import ${params.basePackage}.${table.params.packageName}.service.${table.camelNameU}Service;



@Service
public class ${table.camelNameU}ServiceImpl implements ${table.camelNameU}Service {

    private static final Logger logger = LoggerFactory.getLogger(${table.camelNameU}ServiceImpl.class);

    @Autowired
    private ${table.camelNameU}Dao ${table.camelNameL}Dao;

    

}
