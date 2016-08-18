/**
 * ${table.camelNameU}ServiceImpl.java
 */
package ${params.basePackage}.biz.${params.packageName}.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${params.basePackage}.biz.${params.packageName}.I${table.camelNameU}Service;
import ${params.basePackage}.db.${params.packageName}.dao.I${table.camelNameU}Dao;
import ${params.basePackage}.db.${params.packageName}.dto.${table.camelNameU};
import ${params.basePackage}.framework.page.model.Page;
import ${params.basePackage}.framework.common.vo.ResultBean;
import ${params.basePackage}.framework.common.vo.SqlBean;

/**
 * @author mbg
 *
 * ${.now?date}
 */
@Service
public class ${table.camelNameU}ServiceImpl implements I${table.camelNameU}Service {

    @Autowired
    private I${table.camelNameU}Dao ${table.camelNameL}Dao;

    @Override
    public Page<${table.camelNameU}> getData(SqlBean sqlBean, Integer page_no,
            Integer page_size) {
        return ${table.camelNameL}Dao.getData(sqlBean, page_no, page_size);
    }

    @Override
    public ResultBean del(Long id) {
        return ${table.camelNameL}Dao.deleteByPrimaryKey(id);
    }

    @Override
    public ResultBean add(${table.camelNameU} ${table.camelNameL}) {
        return ${table.camelNameL}Dao.insert(${table.camelNameL});
    }

    @Override
    public ResultBean edit(${table.camelNameU} ${table.camelNameL}) {
        return ${table.camelNameL}Dao.updateByPrimaryKeySelective(${table.camelNameL});
    }

    

}
