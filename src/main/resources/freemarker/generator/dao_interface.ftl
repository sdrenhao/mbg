/**
 * I${table.camelNameU}Dao.java
 */
package ${params.basePackage}.db.${params.packageName}.dao;

import ${params.basePackage}.db.${params.packageName}.dto.${table.camelNameU};
import ${params.basePackage}.framework.db.IBaseSupport;
import ${params.basePackage}.framework.page.model.Page;
import ${params.basePackage}.web.common.vo.SqlBean;

/**
 * @author mbg
 *
 * ${.now?date}
 */
public interface I${table.camelNameU}Dao extends IBaseSupport<${table.camelNameU}> {

    /**
     * @param sqlBean
     * @param page_no
     * @param page_size
     * @return
     */
    public Page<${table.camelNameU}> getData(SqlBean sqlBean, Integer page_no, Integer page_size);

}
