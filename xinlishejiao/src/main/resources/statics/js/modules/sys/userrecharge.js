$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/userrecharge/list',
        datatype: "json",
        colModel: [			
			{ label: 'rechargeId', name: 'rechargeId', index: 'recharge_id', width: 50, key: true },
			{ label: '订单号', name: 'orderNumber', index: 'order_number', width: 80 }, 			
			{ label: '三方充值单号', name: 'outtradeno', index: 'OutTradeNo', width: 80 }, 			
			{ label: '充值人', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '0：充值金币  1：充值余额', name: 'rechargeType', index: 'recharge_type', width: 80 }, 			
			{ label: '', name: 'rechargeAmount', index: 'recharge_amount', width: 80 }, 			
			{ label: '', name: 'rechargeTime', index: 'recharge_time', width: 80 }, 			
			{ label: '0：余额支付 1：微信 2:支付宝', name: 'payType', index: 'pay_type', width: 80 }, 			
			{ label: '0：待支付 1：已支付', name: 'payStatus', index: 'pay_status', width: 80 }, 			
			{ label: '', name: 'payTime', index: 'pay_time', width: 80 }, 			
			{ label: '', name: 'payPrice', index: 'pay_price', width: 80 }, 			
			{ label: '充值方式', name: 'rechargeWay', index: 'recharge_way', width: 80 }			
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
		userRecharge: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userRecharge = {};
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
                var url = vm.userRecharge.rechargeId == null ? "sys/userrecharge/save" : "sys/userrecharge/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.userRecharge),
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
                        url: baseURL + "sys/userrecharge/delete",
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
			$.get(baseURL + "sys/userrecharge/info/"+rechargeId, function(r){
                vm.userRecharge = r.userRecharge;
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