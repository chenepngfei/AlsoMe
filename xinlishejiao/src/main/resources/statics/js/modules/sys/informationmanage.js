$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/informationmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'informationId', name: 'informationId', index: 'information_id', width: 50, key: true },
			{ label: '资讯类型', name: 'informationType', index: 'information_type', width: 80 }, 			
			{ label: '', name: 'type', index: 'type', width: 80 }, 			
			{ label: '', name: 'title', index: 'title', width: 80 }, 			
			{ label: '', name: 'informationPic', index: 'information_pic', width: 80 }, 			
			{ label: '', name: 'videoUrl', index: 'video_url', width: 80 }, 			
			{ label: '', name: 'content', index: 'content', width: 80 }, 			
			{ label: '阅读数', name: 'redNumber', index: 'red_number', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '评论数', name: 'commentNumber', index: 'comment_number', width: 80 }, 			
			{ label: '', name: 'publishTime', index: 'publish_time', width: 80 }, 			
			{ label: '', name: 'editTime', index: 'edit_time', width: 80 }, 			
			{ label: '视频点播ID', name: 'openVideoId', index: 'open_video_id', width: 80 }			
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
		informationManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.informationManage = {};
		},
		update: function (event) {
			var informationId = getSelectedRow();
			if(informationId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(informationId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.informationManage.informationId == null ? "sys/informationmanage/save" : "sys/informationmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.informationManage),
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
			var informationIds = getSelectedRows();
			if(informationIds == null){
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
                        url: baseURL + "sys/informationmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(informationIds),
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
		getInfo: function(informationId){
			$.get(baseURL + "sys/informationmanage/info/"+informationId, function(r){
                vm.informationManage = r.informationManage;
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