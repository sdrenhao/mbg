/**
 * ${table.camelNameU}DaoImpl.java
 */
package ${params.basePackage}.${table.params.packageName}.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sosgps.dao.m60.dao.impl.M60BaseDaoImpl;

import ${params.basePackage}.${table.params.packageName}.dao.${table.camelNameU}Dao;
import ${params.basePackage}.${table.params.packageName}.entity.${table.camelNameU};


@Repository
public class ${table.camelNameU}DaoImpl extends M60BaseDaoImpl implements ${table.camelNameU}Dao {

    private static Logger logger = LoggerFactory.getLogger(${table.camelNameU}DaoImpl.class);
}
