$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/appealmanager/list',
        datatype: "json",
        colModel: [			
			{ label: 'appealId', name: 'appealId', index: 'appeal_id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'appealReason', index: 'appeal_reason', width: 80 }, 			
			{ label: '', name: 'expertId', index: 'expert_id', width: 80 }, 			
			{ label: '', name: 'appealMoney', index: 'appeal_money', width: 80 }, 			
			{ label: '0:预约 1:求助', name: 'category', index: 'category', width: 80 }, 			
			{ label: '对话时间', name: 'talkTime', index: 'talk_time', width: 80 }, 			
			{ label: '申述时间', name: 'appealTime', index: 'appeal_time', width: 80 }, 			
			{ label: '0:未处理 1:已处理', name: 'handleState', index: 'handle_state', width: 80 }, 			
			{ label: '', name: 'handleWay', index: 'handle_way', width: 80 }, 			
			{ label: '预约ID', name: 'reserveId', index: 'reserve_id', width: 80 }			
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
		appealManager: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.appealManager = {};
		},
		update: function (event) {
			var appealId = getSelectedRow();
			if(appealId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(appealId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.appealManager.appealId == null ? "sys/appealmanager/save" : "sys/appealmanager/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.appealManager),
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
			var appealIds = getSelectedRows();
			if(appealIds == null){
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
                        url: baseURL + "sys/appealmanager/delete",
                        contentType: "application/json",
                        data: JSON.stringify(appealIds),
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
		getInfo: function(appealId){
			$.get(baseURL + "sys/appealmanager/info/"+appealId, function(r){
                vm.appealManager = r.appealManager;
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