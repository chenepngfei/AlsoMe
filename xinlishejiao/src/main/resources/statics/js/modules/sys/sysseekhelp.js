$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysseekhelp/list',
        datatype: "json",
        colModel: [			
			{ label: 'seekHelpId', name: 'seekHelpId', index: 'seek_help_id', width: 50, key: true },
			{ label: '', name: 'seekHelNumber', index: 'seek_hel_number', width: 80 }, 			
			{ label: '求助人', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'seekHelpTypeId', index: 'seek_help_type_id', width: 80 }, 			
			{ label: '0:文字', name: 'showType', index: 'show_type', width: 80 }, 			
			{ label: '', name: 'seekHelpTitle', index: 'seek_help_title', width: 80 }, 			
			{ label: '', name: 'seekContent', index: 'seek_content', width: 80 }, 			
			{ label: '0:未帮助 1:已帮助 2:进行中', name: 'seekState', index: 'seek_state', width: 80 }, 			
			{ label: '0:不加急 1:加急', name: 'isUrgent', index: 'is_urgent', width: 80 }, 			
			{ label: '', name: 'urgentGrade', index: 'urgent_grade', width: 80 }, 			
			{ label: '', name: 'urgentGold', index: 'urgent_gold', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '0:未推荐  1:推荐', name: 'isRecommend', index: 'is_recommend', width: 80 }, 			
			{ label: '', name: 'helpUserId', index: 'help_user_id', width: 80 }, 			
			{ label: '打赏金币', name: 'rewardGold', index: 'reward_gold', width: 80 }, 			
			{ label: '视频封面图', name: 'videoPic', index: 'video_pic', width: 80 }, 			
			{ label: '视频描述', name: 'seekDescribe', index: 'seek_describe', width: 80 }			
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
		sysSeekHelp: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysSeekHelp = {};
		},
		update: function (event) {
			var seekHelpId = getSelectedRow();
			if(seekHelpId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(seekHelpId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.sysSeekHelp.seekHelpId == null ? "sys/sysseekhelp/save" : "sys/sysseekhelp/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysSeekHelp),
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
			var seekHelpIds = getSelectedRows();
			if(seekHelpIds == null){
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
                        url: baseURL + "sys/sysseekhelp/delete",
                        contentType: "application/json",
                        data: JSON.stringify(seekHelpIds),
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
		getInfo: function(seekHelpId){
			$.get(baseURL + "sys/sysseekhelp/info/"+seekHelpId, function(r){
                vm.sysSeekHelp = r.sysSeekHelp;
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