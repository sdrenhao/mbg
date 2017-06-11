/**
 * I${table.camelNameU}Service.java
 */
package ${params.basePackage}.biz.${params.packageName};

import ${params.basePackage}.db.${params.packageName}.dto.${table.camelNameU};
import ${params.packageMap["SecurityUser"]};
import ${params.packageMap["Page"]};
import ${params.packageMap["ResultBean"]};
import ${params.packageMap["SqlBean"]};


/**
 * @author mbg
 *
 * ${.now?date}
 */
public interface I${table.camelNameU}Service {

    /**
     * @param sqlBean
     * @param page_no
     * @param page_size
     * @return  
     */
    public Page<${table.camelNameU}> getData(SqlBean sqlBean, Integer page_no,
            Integer page_size);

    /**
     * @param id
     * @return
     */
    public ResultBean del(Long id, SecurityUser currentUser);

    /**
     * @param local
     * @return
     */
    public ResultBean add(${table.camelNameU} ${table.camelNameL}, SecurityUser currentUser);

    /**
     * @param local
     * @return
     */
    public ResultBean edit(${table.camelNameU} ${table.camelNameL}, SecurityUser currentUser);


}
