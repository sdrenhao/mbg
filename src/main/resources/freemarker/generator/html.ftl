${r"<#import"} "/lib/html.html" as uxiaoxi> 
${r"<#assign"} loadcss=[] > 
${r"<#assign"} loadscript=["/js/utils.js","/js/${params.packageName}/${table.camelNameL}.js"] > 
${r"<@uxiaoxi.html "} csslist=loadcss scriptlist=loadscript menu="${params.packageName}" submenu="${table.tableName}">

<div id="page-heading">
    <h1>${params.pageName!""}</h1>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-${params.gridWidth!"12"}" id="list_id">
            <table id="list"></table>
            <div id="pager"></div>
        </div>
    </div>
</div>

${r"</@uxiaoxi.html> "}
