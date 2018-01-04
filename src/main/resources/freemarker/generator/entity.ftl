/**
 * ${table.camelNameU}.java
 */
package ${params.basePackage}.${table.params.packageName}.entity;

<#assign bigDecimal = false>
<#list tableFieldList as tfield>
<#if tfield.type=="BigDecimal">
	<#assign bigDecimal = true>
</#if>
</#list>
<#if bigDecimal>
import java.math.BigDecimal;
</#if>

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.hecom.hqt.psi.order.common.OrderBaseEntity;


@Entity
@javax.persistence.SequenceGenerator(name = "sequence", allocationSize = 1, sequenceName = "seq_${table.nopreTableName}")
@Table(name = "${table.tableName}")
public class ${table.camelNameU} extends OrderBaseEntity {

	private static final long serialVersionUID = 1L;
<#import "/lib/camel.ftl" as camel>
<#list tableFieldList as tfield>
<#if tfield.field=="id" || tfield.field=="created_on" || tfield.field=="last_updated_on" || tfield.field=="created_by" || tfield.field=="last_updated_by" || tfield.field=="status" || tfield.field=="ent_code" >
<#else>
<#if tfield.comment??>
     /**
      * ${tfield.comment!''}
      */</#if>
    @Column(name = "${tfield.field}")
    private  ${tfield.type} <@camel.camel str=tfield.field />;
    
</#if>
</#list>

<#list tableFieldList as tfield>
<#if tfield.field=="id" || tfield.field=="created_on" || tfield.field=="last_updated_on" || tfield.field=="created_by" || tfield.field=="last_updated_by" || tfield.field=="status" || tfield.field=="ent_code" >
<#else>
    public ${tfield.type} get<@camel.camelU str=tfield.field />() {
        return <@camel.camel str=tfield.field />;
    }
    
    public void set<@camel.camelU str=tfield.field />(${tfield.type} <@camel.camel str=tfield.field />) {
        this.<@camel.camel str=tfield.field /> = <@camel.camel str=tfield.field />;
    }
</#if>
</#list>




}
