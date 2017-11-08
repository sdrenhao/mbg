/**
 * ${table.camelNameU}ServiceImpl.java
 */
package ${params.basePackage}.${table.params.packageName}.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ${params.basePackage}.authority.service.AuthorityManager;

import ${params.basePackage}.${table.params.packageName}.entity.${table.camelNameU};
import ${params.basePackage}.${table.params.packageName}.repository.${table.camelNameU}Repository;
import ${params.basePackage}.${table.params.packageName}.service.${table.camelNameU}Service;

import ${params.basePackage}.commons.constant.DataStatuConst;
import ${params.basePackage}.commons.constant.ErrorMsg;
import ${params.basePackage}.commons.enums.ApiCodeEnum;
import ${params.basePackage}.commons.model.CommonHeaders;
import ${params.basePackage}.commons.model.ResponseResult;


@Service
public class ${table.camelNameU}ServiceImpl implements ${table.camelNameU}Service {

    @Autowired
    private ${table.camelNameU}Repository ${table.camelNameL}Repository;

    

}
