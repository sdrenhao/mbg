/**
 * ${table.camelNameU}.java
 */
package ${params.basePackage}.${table.params.packageName}.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.hecom.plugin.store.commons.entity.PluginBaseEntity;


@Entity
@Table(name = "${table.tableName}")
public class ${table.camelNameU} extends PluginBaseEntity {

<#import "/lib/camel.ftl" as uxiaoxi> 
<#list tableFieldList as tfield>




    @Column(name = "${tfield.field}")
    private  <@uxiaoxi.camel str=tfield.field />;
    



</#list>

}
