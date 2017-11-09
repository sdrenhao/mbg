/**
 * ${table.camelNameU}.java
 */
package ${params.basePackage}.${table.params.packageName}.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

<#if table.tableName?contains("dict_")>
import cn.hecom.plugin.store.commons.entity.PluginDictEntity;
<#else>
import cn.hecom.plugin.store.commons.entity.PluginBaseEntity;
</#if>

@Entity
@Table(name = "${table.tableName}")
public class ${table.camelNameU} extends <#if table.tableName?contains("dict_")>PluginDictEntity<#else>PluginBaseEntity</#if> {
<#import "/lib/camel.ftl" as camel>
<#import "/lib/findType.ftl" as ft>
<#list tableFieldList as tfield>
<#if tfield.field=="id" || tfield.field=="created_on" || tfield.field=="last_updated_on" || tfield.field=="created_by" || tfield.field=="last_updated_by" || tfield.field=="status" >
<#else>
    @Column(name = "${tfield.field}")
    private  <@ft.findType str=tfield.type /> <@camel.camel str=tfield.field />;
    
</#if>
</#list>

<#list tableFieldList as tfield>
<#if tfield.field=="id" || tfield.field=="created_on" || tfield.field=="last_updated_on" || tfield.field=="created_by" || tfield.field=="last_updated_by" || tfield.field=="status" >
<#else>
    public <@ft.findType str=tfield.type /> get<@camel.camelU str=tfield.field />() {
        return <@camel.camel str=tfield.field />;
    }
    
    public void set<@camel.camelU str=tfield.field />(<@ft.findType str=tfield.type /> <@camel.camel str=tfield.field />) {
        this.<@camel.camel str=tfield.field /> = <@camel.camel str=tfield.field />;
    }
</#if>
</#list>




}
