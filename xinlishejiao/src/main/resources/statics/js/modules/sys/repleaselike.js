$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/repleaselike/list',
        datatype: "json",
        colModel: [			
			{ label: 'likeid', name: 'likeid', index: 'likeid', width: 50, key: true },
			{ label: '0：提问 1：想法 2：树洞 3：课程 4:视频 5:广播6:测试7:卡片 8:help评论 9:视频评论 10:最新资讯', name: 'targetType', index: 'target_type', width: 80 }, 			
			{ label: '目标ID', name: 'targetId', index: 'target_id', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'operationTime', index: 'operation_time', width: 80 }, 			
			{ label: '0：点赞 1：收藏', name: 'operationType', index: 'operation_type', width: 80 }, 			
			{ label: '课程章节ID', name: 'chapterId', index: 'chapter_id', width: 80 }			
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
		repleaseLike: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.repleaseLike = {};
		},
		update: function (event) {
			var likeid = getSelectedRow();
			if(likeid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(likeid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.repleaseLike.likeid == null ? "sys/repleaselike/save" : "sys/repleaselike/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.repleaseLike),
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
			var likeids = getSelectedRows();
			if(likeids == null){
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
                        url: baseURL + "sys/repleaselike/delete",
                        contentType: "application/json",
                        data: JSON.stringify(likeids),
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
		getInfo: function(likeid){
			$.get(baseURL + "sys/repleaselike/info/"+likeid, function(r){
                vm.repleaseLike = r.repleaseLike;
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