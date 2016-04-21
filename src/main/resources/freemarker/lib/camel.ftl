<#macro camel str="">
<#assign result="" >
<#if !str?contains("_")>
    <#assign result=str?uncap_first >
<#else>
    <#list str?split("_") as s>  
        <#if s_index = 0 > 
           <#assign result=result + s?uncap_first >
        <#else>
            <#assign result=result + s?cap_first >
        </#if>
    </#list>
</#if>${result}</#macro>