<#import "/lib/camel.ftl" as uxiaoxi> 
$(function() {

    $.jgrid.defaults.width = $("#list_id").width();
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
    
    $('#list').jqGrid({
        url : '${params.prePath!""}/${params.packageName}/${table.tableName}/data',
        datatype : 'json',
        mtype : 'POST',
        autowidth : true,
        colNames : [ <#list tableFieldList as tfield>'${tfield.comment}'<#if tfield_index lt (tableFieldList?size - 1)  >,</#if> </#list>],
        colModel : [ 
    <#list tableFieldList as tfield>
        {
            name :  '<@uxiaoxi.camel str=tfield.field />',
            index : 't.${tfield.field}',<#if tfield.type == "timestamp" || tfield.type == "datetime" >
            editable : false,
            formatter : dateFormater ,<#else>
            editable : true,</#if>
            hidden : <#if tfield.field == "id" || tfield.hiddenState>true<#else>false</#if>
        }<#if tfield_index lt (tableFieldList?size - 1)  >,</#if>
    </#list>
        ],
        ondblClickRow : function(id) {
                    jQuery(this).editGridRow(id, {
                        url : '${params.prePath!""}/${params.packageName}/${table.tableName}/edit',
                        closeAfterEdit : true,
                        closeOnEscape : true
                    });
                },
        rowNum : 25,
        rowList : [ 25, 50, 100 ],
        jsonReader : {
            root : 'data',
            page : 'pageNO',
            total : 'totalPageCount',
            records : 'totalCount'
        },
        prmNames : {
            page : 'page_no',
            rows : 'page_size',
            search : 'search'
        },
        pager : '#pager',
        sortname : '${tableFieldList?first.field}',
        viewrecords : true,
        sortorder : 'desc',
        editurl : '${params.prePath!""}/${params.packageName}/${table.tableName}/edit',
        caption : '${params.pageName!""}'
    });
    $('#list').jqGrid(
            'navGrid',
            '#pager',
            {
                edit : true,
                add : true,
                del : true
            },
            {
                url : '${params.prePath!""}/${params.packageName}/${table.tableName}/edit',
                closeAfterEdit : true,
                closeOnEscape : true
            },
            {
                url : '${params.prePath!""}/${params.packageName}/${table.tableName}/add',
                closeAfterAdd : true,
                clearAfterAdd : true,
                closeOnEscape : true
            },
            {
                url : '${params.prePath!""}/${params.packageName}/${table.tableName}/del',
                closeOnEscape : true
            },
            {
                sopt : [ 'cn', 'nc', 'nu', 'nn', 'eq', 'ne', 'lt', 'le', 'gt',
                        'ge', 'bw', 'bn', 'in', 'ni', 'ew', 'en' ],
                multipleSearch : true,
                multipleGroup : false,
                closeAfterSearch : true,
                showQuery : false,
                searchOnEnter : true,
                closeOnEscape : true
            }, {});

    $(window).bind('resize', function() {
        resizeTable();
    });
    
    $(".nav a").bind('click', function() {
        setTimeout(function(){  resizeTable(); }, 0);
        
    });

    function resizeTable() {
        $("#list").setGridWidth($("#list_id").width());
    }

    $("#list").setGridHeight($(window).height() * 0.68);

});
