$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/userpossession/list',
        datatype: "json",
        colModel: [			
			{ label: 'recordid', name: 'recordid', index: 'recordid', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '', name: 'recordtime', index: 'recordtime', width: 80 }, 			
			{ label: '0：金币 1：余额  2:收益', name: 'recordtype', index: 'recordtype', width: 80 }, 			
			{ label: '', name: 'disbursetype', index: 'disbursetype', width: 80 }, 			
			{ label: '', name: 'recordsource', index: 'recordsource', width: 80 }, 			
			{ label: '交易金额', name: 'transactionAmount', index: 'transaction_amount', width: 80 }, 			
			{ label: '来源ID', name: 'sourceId', index: 'source_id', width: 80 }, 			
			{ label: '0:收入 1:支出 2:充值', name: 'operationType', index: 'operation_type', width: 80 }			
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
		userPossession: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userPossession = {};
		},
		update: function (event) {
			var recordid = getSelectedRow();
			if(recordid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(recordid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.userPossession.recordid == null ? "sys/userpossession/save" : "sys/userpossession/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.userPossession),
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
			var recordids = getSelectedRows();
			if(recordids == null){
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
                        url: baseURL + "sys/userpossession/delete",
                        contentType: "application/json",
                        data: JSON.stringify(recordids),
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
		getInfo: function(recordid){
			$.get(baseURL + "sys/userpossession/info/"+recordid, function(r){
                vm.userPossession = r.userPossession;
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