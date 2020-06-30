$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/communitymanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'communityId', name: 'communityId', index: 'community_id', width: 50, key: true },
			{ label: '', name: 'communityName', index: 'community_name', width: 80 }, 			
			{ label: '', name: 'communityDescribe', index: 'community_describe', width: 80 }, 			
			{ label: '', name: 'peopleNumber', index: 'people_number', width: 80 }, 			
			{ label: '', name: 'createUser', index: 'create_user', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '社区类型 0:系统创建  1:用户创建', name: 'communityType', index: 'community_type', width: 80 }, 			
			{ label: '', name: 'checkStatus', index: 'Check_Status', width: 80 }, 			
			{ label: '0：待审核  1：审核通过 2：审核拒绝', name: 'checkOpinion', index: 'check_opinion', width: 80 }, 			
			{ label: '用户默认头像', name: 'communityUserPicture', index: 'community_user_picture', width: 80 }, 			
			{ label: '用户默认昵称', name: 'communityUserNickName', index: 'community_user_nick_name', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }			
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
		communityManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.communityManage = {};
		},
		update: function (event) {
			var communityId = getSelectedRow();
			if(communityId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(communityId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.communityManage.communityId == null ? "sys/communitymanage/save" : "sys/communitymanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.communityManage),
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
			var communityIds = getSelectedRows();
			if(communityIds == null){
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
                        url: baseURL + "sys/communitymanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(communityIds),
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
		getInfo: function(communityId){
			$.get(baseURL + "sys/communitymanage/info/"+communityId, function(r){
                vm.communityManage = r.communityManage;
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