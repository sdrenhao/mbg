<#macro findType str="">
<#assign result="" >
<#if str?contains("bigint")>
    <#assign result="Long" >
<#else>
    <#if str?contains("int")>
        <#assign result="Integer" >
    <#else>
        <#if str?contains("varchar")>
            <#assign result="String" >
        <#else>
            <#if str?contains("timestamp")>
                <#assign result="Date" >
            <#else>
                <#if str?contains("text")>
                    <#assign result="String" >
                <#else>
                    
                </#if>
            </#if>
        </#if>
    </#if>
</#if>${result}</#macro>