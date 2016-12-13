${r"<#import"} "/lib/html.html" as main> 
${r"<#assign"} loadcss=[] > 
${r"<#assign"} loadscript=["/js/util/utils.js","/js/${params.packageName}/${table.camelNameL}.js"] > 
${r"<@main.html "} csslist=loadcss scriptlist=loadscript menu="${params.packageName}" submenu="${table.tableName}">

<!-- Content Header -->
<section class="content-header">
    <h1>Demos<small>Jqgrid</small></h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
        <li class="active">Demos</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
     <div class="row">
        <div class="col-md-${params.gridWidth!"12"}" id="list_id">
            <table id="list"></table>
            <div id="pager"></div>
        </div>
    </div>
</section>
${r"</@main.html> "}
