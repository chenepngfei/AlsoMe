$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/repleasereply/list',
        datatype: "json",
        colModel: [			
			{ label: 'replyid', name: 'replyid', index: 'replyid', width: 50, key: true },
			{ label: '', name: 'commentid', index: 'commentid', width: 80 }, 			
			{ label: '0：提问 1：想法 2：树洞 3：课程 4:视频 5:广播6:测试7:卡片 8:help评论 9:视频评论 10:最新资讯', name: 'targetType', index: 'target_type', width: 80 }, 			
			{ label: '对应type类型', name: 'targetId', index: 'target_id', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'byUserId', index: 'by_user_id', width: 80 }, 			
			{ label: '', name: 'replyDesc', index: 'reply_desc', width: 80 }, 			
			{ label: '', name: 'replyTime', index: 'reply_time', width: 80 }			
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
		repleaseReply: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.repleaseReply = {};
		},
		update: function (event) {
			var replyid = getSelectedRow();
			if(replyid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(replyid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.repleaseReply.replyid == null ? "sys/repleasereply/save" : "sys/repleasereply/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.repleaseReply),
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
			var replyids = getSelectedRows();
			if(replyids == null){
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
                        url: baseURL + "sys/repleasereply/delete",
                        contentType: "application/json",
                        data: JSON.stringify(replyids),
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
		getInfo: function(replyid){
			$.get(baseURL + "sys/repleasereply/info/"+replyid, function(r){
                vm.repleaseReply = r.repleaseReply;
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