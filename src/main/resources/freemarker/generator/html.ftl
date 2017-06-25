${r"<#import"} "/lib/main.html" as main> 
${r"<#assign"} loadcss=[] > 
${r"<#assign"} loadscript=["/js/util/utils.js","/js/${params.packageName}/${table.camelNameL}.js"] > 
${r"<@main.html "} csslist=loadcss scriptlist=loadscript menu="${params.packageName}" submenu="${table.tableName}">

      <div class="app-content-body fade-in-up">
          <div class="app-content-title">
              <h1 class="font-thin">${table.pageName!""}</h1>
          </div>
          <div class="wrapper-md">
              <div class="row">
                  <div class="col-md-${table.gridWidth!"12"}" id="list_id">
                      <div class="jqbox">
                          <table id="list"></table>
                          <div id="pager"></div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    
    
    
${r"</@main.html> "}
