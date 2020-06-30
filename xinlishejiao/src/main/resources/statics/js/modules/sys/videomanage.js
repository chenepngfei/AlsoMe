$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/videomanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'videoId', name: 'videoId', index: 'video_id', width: 50, key: true },
			{ label: '', name: 'videoName', index: 'video_name', width: 80 }, 			
			{ label: '', name: 'videoUrl', index: 'video_url', width: 80 }, 			
			{ label: '', name: 'videoTime', index: 'video_time', width: 80 }, 			
			{ label: '0:常规 1:求助', name: 'videoType', index: 'video_type', width: 80 }, 			
			{ label: '', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'likeNumber', index: 'like_number', width: 80 }, 			
			{ label: '', name: 'shareNumber', index: 'share_number', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '0:非精华 1:精华', name: 'isImportant', index: 'is_important', width: 80 }, 			
			{ label: '封面图', name: 'videoPic', index: 'video_pic', width: 80 }, 			
			{ label: '视频描述', name: 'videoDescribe', index: 'video_describe', width: 80 }, 			
			{ label: '是否草稿 0:否 1:是', name: 'isDraft', index: 'is_draft', width: 80 }, 			
			{ label: '视频高度', name: 'height', index: 'height', width: 80 }, 			
			{ label: '视频宽度', name: 'width', index: 'width', width: 80 }, 			
			{ label: '0:未帮助 1:已帮助 2:进行中', name: 'videoState', index: 'video_state', width: 80 }, 			
			{ label: '帮助者ID', name: 'helperUserId', index: 'helper_user_id', width: 80 }, 			
			{ label: '0:未帮助 1:已帮助', name: 'helpState', index: 'help_state', width: 80 }			
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
		videoManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.videoManage = {};
		},
		update: function (event) {
			var videoId = getSelectedRow();
			if(videoId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(videoId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.videoManage.videoId == null ? "sys/videomanage/save" : "sys/videomanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.videoManage),
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
			var videoIds = getSelectedRows();
			if(videoIds == null){
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
                        url: baseURL + "sys/videomanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(videoIds),
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
		getInfo: function(videoId){
			$.get(baseURL + "sys/videomanage/info/"+videoId, function(r){
                vm.videoManage = r.videoManage;
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