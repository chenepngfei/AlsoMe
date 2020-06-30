$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/copywritingmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'copywritingId', name: 'copywritingId', index: 'copywriting_id', width: 50, key: true },
			{ label: '1：用户注册；2：关于我们；3：帮助；4：任务说明 5:会员权益说明   6:充值说明 7.提现微信规则 8.提现银行卡规则 9.金币说明 10.金币兑换说明', name: 'copywritingType', index: 'copywriting_type', width: 80 }, 			
			{ label: '', name: 'logoUrl', index: 'logo_url', width: 80 }, 			
			{ label: '', name: 'copywritingName', index: 'copywriting_name', width: 80 }, 			
			{ label: '', name: 'copywritingContent', index: 'copywriting_content', width: 80 }, 			
			{ label: '', name: 'contact', index: 'contact', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '类型名', name: 'typeName', index: 'type_name', width: 80 }			
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
		copywritingManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.copywritingManage = {};
		},
		update: function (event) {
			var copywritingId = getSelectedRow();
			if(copywritingId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(copywritingId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.copywritingManage.copywritingId == null ? "sys/copywritingmanage/save" : "sys/copywritingmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.copywritingManage),
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
			var copywritingIds = getSelectedRows();
			if(copywritingIds == null){
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
                        url: baseURL + "sys/copywritingmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(copywritingIds),
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
		getInfo: function(copywritingId){
			$.get(baseURL + "sys/copywritingmanage/info/"+copywritingId, function(r){
                vm.copywritingManage = r.copywritingManage;
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