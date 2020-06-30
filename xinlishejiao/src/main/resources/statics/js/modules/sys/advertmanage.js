$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/advertmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'advertId', name: 'advertId', index: 'advert_id', width: 50, key: true },
			{ label: '', name: 'advertName', index: 'advert_name', width: 80 }, 			
			{ label: '', name: 'advertPic', index: 'advert_pic', width: 80 }, 			
			{ label: '', name: 'advertUrl', index: 'advert_url', width: 80 }, 			
			{ label: '0:在线   1:下线', name: 'state', index: 'state', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '0:广告页 4:最新资讯 5:发现首页顶部 6:社区广告 7:课程页面 8:发现首页底部', name: 'advertType', index: 'advert_type', width: 80 }, 			
			{ label: '跳转目标ID', name: 'targetId', index: 'target_id', width: 80 }, 			
			{ label: '0:自定义广告 1:图文资讯 2:课程 3:测试题 4:卡牌测试 5:视频资讯', name: 'targetType', index: 'target_type', width: 80 }			
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
		advertManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.advertManage = {};
		},
		update: function (event) {
			var advertId = getSelectedRow();
			if(advertId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(advertId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.advertManage.advertId == null ? "sys/advertmanage/save" : "sys/advertmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.advertManage),
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
			var advertIds = getSelectedRows();
			if(advertIds == null){
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
                        url: baseURL + "sys/advertmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(advertIds),
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
		getInfo: function(advertId){
			$.get(baseURL + "sys/advertmanage/info/"+advertId, function(r){
                vm.advertManage = r.advertManage;
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