/**
 * ${table.camelNameU}Repository.java
 */
package ${params.basePackage}.${table.params.packageName}.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hecom.collie.jpa.repository.BaseRepository;
import ${params.basePackage}.${table.params.packageName}.entity.${table.camelNameU};



public interface ${table.camelNameU}Repository extends BaseRepository<${table.camelNameU}, Long> {

}
