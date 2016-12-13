/**
 * I${table.camelNameU}Dao.java
 */
package ${params.basePackage}.db.${params.packageName}.dao;

import ${params.basePackage}.db.${params.packageName}.dto.${table.camelNameU};
import ${params.packageMap["IBaseSupport"]};
import ${params.packageMap["Page"]};
import ${params.packageMap["SqlBean"]};

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
