/**
 * ${table.camelNameU}DaoImpl.java
 */
package ${params.basePackage}.db.${table.params.packageName}.dao.impl;

import org.springframework.stereotype.Repository;

import ${params.basePackage}.db.${table.params.packageName}.dao.I${table.camelNameU}Dao;
import ${params.basePackage}.db.${table.params.packageName}.dto.${table.camelNameU};
import ${params.basePackage}.db.${table.params.packageName}.dto.${table.camelNameU}Example;
import ${params.basePackage}.db.${table.params.packageName}.mapper.${table.camelNameU}Mapper;
import ${params.packageMap["BaseSupport"]};
import ${params.packageMap["Page"]};
import ${params.packageMap["SqlBean"]};

/**
 * @author mbg
 *
 * ${.now?date}
 */
@Repository
public class ${table.camelNameU}DaoImpl extends BaseSupport<${table.camelNameU}, ${table.camelNameU}Mapper> implements I${table.camelNameU}Dao {

    @SuppressWarnings("unchecked")
    @Override
    public Page<${table.camelNameU}> getData(SqlBean sqlBean, Integer page_no, Integer page_size) {
        Page<${table.camelNameU}> page = null;
        try {
            page = this.selectPage("${params.basePackage}.db.${table.params.packageName}.mapper.${table.camelNameU}Mapper.getData",sqlBean, page_no, page_size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
}
