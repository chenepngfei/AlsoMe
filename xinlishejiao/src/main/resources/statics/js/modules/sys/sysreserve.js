$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysreserve/list',
        datatype: "json",
        colModel: [			
			{ label: 'reserveId', name: 'reserveId', index: 'reserve_id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'expertId', index: 'expert_id', width: 80 }, 			
			{ label: '', name: 'reserveLength', index: 'reserve_length', width: 80 }, 			
			{ label: '', name: 'reserveDate', index: 'reserve_date', width: 80 }, 			
			{ label: '', name: 'reserveMoney', index: 'reserve_money', width: 80 }, 			
			{ label: '-1:未支付 0:未完成  1:已完成 2:申诉  3:已退款', name: 'reserveState', index: 'reserve_state', width: 80 }, 			
			{ label: '', name: 'orderTime', index: 'order_time', width: 80 }, 			
			{ label: '', name: 'seekHelpId', index: 'seek_help_id', width: 80 }, 			
			{ label: '预约描述', name: 'reserveDescribe', index: 'reserve_describe', width: 80 }, 			
			{ label: '', name: 'reserveTime', index: 'reserve_time', width: 80 }, 			
			{ label: '60分钟整体数据', name: 'reserveTimeResult', index: 'reserve_time_result', width: 80 }			
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
		sysReserve: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysReserve = {};
		},
		update: function (event) {
			var reserveId = getSelectedRow();
			if(reserveId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(reserveId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.sysReserve.reserveId == null ? "sys/sysreserve/save" : "sys/sysreserve/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysReserve),
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
			var reserveIds = getSelectedRows();
			if(reserveIds == null){
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
                        url: baseURL + "sys/sysreserve/delete",
                        contentType: "application/json",
                        data: JSON.stringify(reserveIds),
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
		getInfo: function(reserveId){
			$.get(baseURL + "sys/sysreserve/info/"+reserveId, function(r){
                vm.sysReserve = r.sysReserve;
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