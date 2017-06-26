${r"<#import"} "/lib/main.html" as main> 
${r"<#assign"} loadcss=[] > 
${r"<#assign"} loadscript=["/js/util/utils.js","/js/${table.params.packageName}/${table.camelNameL}.js"] > 
${r"<@main.html "} csslist=loadcss scriptlist=loadscript menu="${table.params.packageName}" submenu="${table.tableName}">

      <div class="app-content-body fade-in-up">
          <div class="wrapper-md">
              <div class="row">
                  <div class="col-md-${table.params.gridWidth!"12"}" id="list_id">
                      <div class="jqbox">
                          <table id="list"></table>
                          <div id="pager"></div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    
${r"</@main.html> "}
