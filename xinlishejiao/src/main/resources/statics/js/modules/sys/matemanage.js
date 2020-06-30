$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/matemanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'mateId', name: 'mateId', index: 'mate_id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'mateNumber', index: 'mate_number', width: 80 }, 			
			{ label: '', name: 'payNumber', index: 'pay_number', width: 80 }, 			
			{ label: '', name: 'matePeopleNumber', index: 'mate_people_number', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '0:全部 1:男 2:女', name: 'mateSex', index: 'mate_sex', width: 80 }, 			
			{ label: '国家', name: 'mateCountry', index: 'mate_country', width: 80 }, 			
			{ label: '城市', name: 'mateCity', index: 'mate_city', width: 80 }, 			
			{ label: '用户类型', name: 'userType', index: 'user_type', width: 80 }, 			
			{ label: '爱好', name: 'hobby', index: 'hobby', width: 80 }, 			
			{ label: '是否允许匹配 0:否 1:是', name: 'isMate', index: 'is_mate', width: 80 }			
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
		mateManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.mateManage = {};
		},
		update: function (event) {
			var mateId = getSelectedRow();
			if(mateId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(mateId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.mateManage.mateId == null ? "sys/matemanage/save" : "sys/matemanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.mateManage),
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
			var mateIds = getSelectedRows();
			if(mateIds == null){
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
                        url: baseURL + "sys/matemanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(mateIds),
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
		getInfo: function(mateId){
			$.get(baseURL + "sys/matemanage/info/"+mateId, function(r){
                vm.mateManage = r.mateManage;
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