/**
 * ${table.camelNameU}ServiceImpl.java
 */
package ${params.basePackage}.biz.${table.params.packageName}.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${params.basePackage}.biz.${table.params.packageName}.I${table.camelNameU}Service;
import ${params.basePackage}.db.${table.params.packageName}.dao.I${table.camelNameU}Dao;
import ${params.basePackage}.db.${table.params.packageName}.dto.${table.camelNameU};
import ${params.packageMap["SecurityUser"]};
import ${params.packageMap["Page"]};
import ${params.packageMap["ResultBean"]};
import ${params.packageMap["SqlBean"]};

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
    public ResultBean del(Long id, SecurityUser currentUser) {
        return ${table.camelNameL}Dao.deleteByPrimaryKey(id);
    }

    @Override
    public ResultBean add(${table.camelNameU} ${table.camelNameL}, SecurityUser currentUser) {
        Date nowtime = new Date();
        ${table.camelNameL}.setCreateAt(nowtime);
        ${table.camelNameL}.setCreateBy(currentUser.getId());
        ${table.camelNameL}.setUpdateAt(nowtime);
        ${table.camelNameL}.setUpdateBy(currentUser.getId());
        ${table.camelNameL}.setUseYn(true);
        return ${table.camelNameL}Dao.insertSelective(${table.camelNameL});
    }

    @Override
    public ResultBean edit(${table.camelNameU} ${table.camelNameL}, SecurityUser currentUser) {
        Date nowtime = new Date();
        ${table.camelNameL}.setCreateAt(nowtime);
        ${table.camelNameL}.setUpdateBy(currentUser.getId());
        ${table.camelNameL}.setUseYn(true);
        return ${table.camelNameL}Dao.updateByPrimaryKeySelective(${table.camelNameL});
    }

    

}
