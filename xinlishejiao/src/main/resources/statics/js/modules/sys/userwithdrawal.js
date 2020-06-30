$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/userwithdrawal/list',
        datatype: "json",
        colModel: [			
			{ label: 'rechargeId', name: 'rechargeId', index: 'recharge_id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'withdrawalAmount', index: 'withdrawal_amount', width: 80 }, 			
			{ label: '1: 微信  2:银行卡', name: 'withdrawalType', index: 'withdrawal_type', width: 80 }, 			
			{ label: '', name: 'applyTime', index: 'apply_time', width: 80 }, 			
			{ label: '', name: 'checkTime', index: 'check_time', width: 80 }, 			
			{ label: '0: 审核中  1:通过   2:拒绝', name: 'withdrawalState', index: 'withdrawal_state', width: 80 }, 			
			{ label: '余额', name: 'balance', index: 'balance', width: 80 }, 			
			{ label: '提现IP', name: 'withdrawalIp', index: 'withdrawal_ip', width: 80 }			
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
		userWithdrawal: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userWithdrawal = {};
		},
		update: function (event) {
			var rechargeId = getSelectedRow();
			if(rechargeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(rechargeId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.userWithdrawal.rechargeId == null ? "sys/userwithdrawal/save" : "sys/userwithdrawal/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.userWithdrawal),
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
			var rechargeIds = getSelectedRows();
			if(rechargeIds == null){
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
                        url: baseURL + "sys/userwithdrawal/delete",
                        contentType: "application/json",
                        data: JSON.stringify(rechargeIds),
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
		getInfo: function(rechargeId){
			$.get(baseURL + "sys/userwithdrawal/info/"+rechargeId, function(r){
                vm.userWithdrawal = r.userWithdrawal;
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