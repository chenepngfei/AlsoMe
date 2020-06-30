$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/taskmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'taskId', name: 'taskId', index: 'task_id', width: 50, key: true },
			{ label: '', name: 'taskName', index: 'task_name', width: 80 }, 			
			{ label: '1:seeker任务 2：helper任务', name: 'taskRole', index: 'task_role', width: 80 }, 			
			{ label: '', name: 'taskType', index: 'task_type', width: 80 }, 			
			{ label: '', name: 'taskPic', index: 'task_pic', width: 80 }, 			
			{ label: '', name: 'taskDescrible', index: 'task_describle', width: 80 }, 			
			{ label: '', name: 'taskNumber', index: 'task_number', width: 80 }, 			
			{ label: '任务等级123456级', name: 'taskLevel', index: 'task_level', width: 80 }, 			
			{ label: '1: 发布求助 2:匹配 3:测试 4:读一本书 5:课程 6:发布视频 7:创建或加入社区 8:动画引导 9:无偿帮助', name: 'targetType', index: 'target_type', width: 80 }			
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
		taskManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.taskManage = {};
		},
		update: function (event) {
			var taskId = getSelectedRow();
			if(taskId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(taskId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.taskManage.taskId == null ? "sys/taskmanage/save" : "sys/taskmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.taskManage),
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
			var taskIds = getSelectedRows();
			if(taskIds == null){
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
                        url: baseURL + "sys/taskmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(taskIds),
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
		getInfo: function(taskId){
			$.get(baseURL + "sys/taskmanage/info/"+taskId, function(r){
                vm.taskManage = r.taskManage;
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