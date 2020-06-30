$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/usersubsidy/list',
        datatype: "json",
        colModel: [			
			{ label: 'userSubsidyId', name: 'userSubsidyId', index: 'user_subsidy_id', width: 50, key: true },
			{ label: '等级', name: 'level', index: 'level', width: 80 }, 			
			{ label: '津贴金额', name: 'subsidyNumber', index: 'subsidy_number', width: 80 }, 			
			{ label: '帮助时长', name: 'helpTime', index: 'help_time', width: 80 }, 			
			{ label: '扣除金币', name: 'deductGold', index: 'deduct_gold', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'editTime', index: 'edit_time', width: 80 }			
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
		userSubsidy: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userSubsidy = {};
		},
		update: function (event) {
			var userSubsidyId = getSelectedRow();
			if(userSubsidyId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userSubsidyId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.userSubsidy.userSubsidyId == null ? "sys/usersubsidy/save" : "sys/usersubsidy/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.userSubsidy),
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
			var userSubsidyIds = getSelectedRows();
			if(userSubsidyIds == null){
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
                        url: baseURL + "sys/usersubsidy/delete",
                        contentType: "application/json",
                        data: JSON.stringify(userSubsidyIds),
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
		getInfo: function(userSubsidyId){
			$.get(baseURL + "sys/usersubsidy/info/"+userSubsidyId, function(r){
                vm.userSubsidy = r.userSubsidy;
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