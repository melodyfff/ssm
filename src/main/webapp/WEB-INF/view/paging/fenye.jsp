<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 加入标题图片 -->
<!-- <link rel="icon" href="./fa.ico" type="image/x-icon" /> -->
<link type="${pageContext.request.contextPath}/image/x-icon" rel="shortcut icon" href="../fa.ico" />
<!-- 加入bootstrap -->
  <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"> 
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>  

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/table/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/static/table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/static/table/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/static/table/tableExport.js"></script>
<!-- Latest compiled and minified Locales -->
<script src="${pageContext.request.contextPath}/static/table/bootstrap-table-zh-CN.min.js"></script>

<title>分页</title>


</head>
<body>
<div class="wrapper wrapper-content">

    <div class="row">
        <div class="col-sm-12">
            <div class="animated fadeInRightBig">
                <!--添加内容区域-->
                <div class="ibox-content">
                    <h4 class="example-title">题目列表</h4>
                    <div class="btn-group hidden-xs"  role="group" id="exampleToolbar">
                        <button type="button" class="btn btn-outline btn-default">
                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                        </button>
                    </div>
                    <!--添加题目表-->
                    <table  id="exampleTableToolbar3" data-toggle="table" >
  						
  						<!-- 如果不用 columns: [] 则可在此编辑  -->
  						<%-- <thead>
                        <tr>
                        <!--data-field和你从数据库取出来的pojo类名相对应-->
                            <th data-field="id" data-sortable="true">ID</th>
                            <th data-field="username">用户名</th>
                            <th data-field="password">密码</th>

                            这里是用来编辑的,可以添加编辑,删除等按钮
                            <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">Action</th>
                        </tr>
                        </thead> --%>
                    </table>
                    
                </div>
                <!--添加题目表结束-->

            </div>
        </div>
</div>
</div>

<div class="atest"><p id='test'>111</p></div>

<br>


<script>
var table3 = $("#exampleTableToolbar3");

$("p").css("border", "3px solid red");

table3.bootstrapTable({
	
    url: "${pageContext.request.contextPath}/paging/page",//具体请求地址
    method: 'post',//请求方式
    striped: true,                      //是否显示行间隔色
    
    pagination:true,                  //是否显示分页（*）
    
    cache: false,                      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    clickToSelect: true,                //是否启用点击选中行
    cardView: true,                    //是否显示详细视图
    
    showPaginationSwitch:true,			// 隐藏/显示分页
    showExport: true,                     //是否显示导出
    showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
    showRefresh: true,//是否显示刷新框
    showColumns: true,//是否显示columns按钮   
    showFooter:false,					//True to show the summary footer row.
    search: true,//是否开启搜索框
    sortable: true,                     //是否启用排序
    sidePagination: "server",          //分页方式：client客户端分页，server服务端分页（*）
    singleSelect :false,				//只允许选中一个
   
   
    checkboxHeader:true,				//头部选取所有数据开关 
    maintainSelected:false,				//True to maintain selected rows on change page and search.
   
    detailView: true,                   //是否显示父子表 True to show detail view table.
    sortOrder: "asc",                   //排序方式
   
   
    exportDataType: "basic",              //basic', 'all', 'selected'.
    cardView: false,                    //是否显示详细视图
    detailView: false,                   //是否显示父子表
   
    queryParams: queryParams,//传递参数（*）
    pageNumber: 1,                       //初始化加载第一页，默认第一页
    pageSize: 5,                      //每页的记录行数（*）
    pageList:[5,10,25],        //可供选择的每页的行数（*）
   
    toolbar: "#exampleToolbar",//对用的toolbar
    iconsPrefix:'glyphicon', //Defines icon set name ('glyphicon' or 'fa' for FontAwesome). By default 'glyphicon' is used.
    icons: {paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
    	  paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
    	  refresh: 'glyphicon-refresh icon-refresh',
    	  toggle: 'glyphicon-list-alt icon-list-alt',
    	  columns: 'glyphicon-th icon-th',
    	  detailOpen: 'glyphicon-plus icon-plus',
    	  detailClose: 'glyphicon-minus icon-minus',
    	  export: ' glyphicon-export icon-share'},//对应按钮对应的字体图标
    uniqueId: "ID",//主键id
    
    columns: [{
        field: 'cheick',
        title: '选择',
        checkbox: true
    },{
        field: 'id',
        title: 'ID',
        sortable: true
    },{
        field: 'username',
        title: '用户名',
        sortable: true
    },{
        field: 'password',
        title: '密码'
    },{
        field: '测试',
        formatter:'action'
    }]
    
});

//题目表参数传递
function queryParams(params) {
    return {
        limit:params.limit,//每页数据条数
        offset:params.offset,//当前页偏移
        order:params.order,//排序
        ordername:params.sort,//需要排序的字段
        search:params.search//搜索的字段
        
    };
}
    
</script>
</body>
</html>