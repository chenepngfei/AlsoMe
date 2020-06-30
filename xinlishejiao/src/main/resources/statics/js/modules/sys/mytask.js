$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/mytask/list',
        datatype: "json",
        colModel: [			
			{ label: 'myTaskId', name: 'myTaskId', index: 'my_task_id', width: 50, key: true },
			{ label: '', name: 'taskId', index: 'task_id', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '完成进度', name: 'completionDegree', index: 'completion_degree', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'editTime', index: 'edit_time', width: 80 }, 			
			{ label: '0:未开始 1:进行中 2:已完成', name: 'state', index: 'state', width: 80 }, 			
			{ label: '任务等级', name: 'taskLevel', index: 'task_level', width: 80 }, 			
			{ label: '1: 发布求助 2:匹配 3:测试 4:读一本书 5:课程 6:发布视频 7:创建或加入社区 8:动画引导 9:无偿帮助', name: 'taskType', index: 'task_type', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		myTask: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.myTask = {};
		},
		update: function (event) {
			var myTaskId = getSelectedRow();
			if(myTaskId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(myTaskId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.myTask.myTaskId == null ? "sys/mytask/save" : "sys/mytask/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.myTask),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var myTaskIds = getSelectedRows();
			if(myTaskIds == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/mytask/delete",
                        contentType: "application/json",
                        data: JSON.stringify(myTaskIds),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(myTaskId){
			$.get(baseURL + "sys/mytask/info/"+myTaskId, function(r){
                vm.myTask = r.myTask;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});