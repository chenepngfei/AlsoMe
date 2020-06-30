$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dialogue/list',
        datatype: "json",
        colModel: [			
			{ label: 'dialogueId', name: 'dialogueId', index: 'dialogue_id', width: 50, key: true },
			{ label: '', name: 'askContent', index: 'ask_content', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'communityId', index: 'community_id', width: 80 }, 			
			{ label: '0:', name: 'awardGold', index: 'award_gold', width: 80 }, 			
			{ label: '', name: 'answerNumber', index: 'answer_number', width: 80 }, 			
			{ label: '', name: 'likeNumber', index: 'like_number', width: 80 }, 			
			{ label: '0:未结束   1:已结束', name: 'state', index: 'state', width: 80 }, 			
			{ label: '0:', name: 'isDel', index: 'is_del', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '0:', name: 'isRecommend', index: 'is_recommend', width: 80 }, 			
			{ label: '0：已发布 1：草稿箱', name: 'releaseStatus', index: 'release_status', width: 80 }, 			
			{ label: '', name: 'dialogueType', index: 'dialogue_type', width: 80 }, 			
			{ label: '标题', name: 'askTitle', index: 'ask_title', width: 80 }, 			
			{ label: '弃用', name: 'isDraft', index: 'is_draft', width: 80 }, 			
			{ label: '', name: 'collectNumber', index: 'collect_number', width: 80 }			
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
		dialogue: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dialogue = {};
		},
		update: function (event) {
			var dialogueId = getSelectedRow();
			if(dialogueId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(dialogueId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.dialogue.dialogueId == null ? "sys/dialogue/save" : "sys/dialogue/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.dialogue),
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
			var dialogueIds = getSelectedRows();
			if(dialogueIds == null){
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
                        url: baseURL + "sys/dialogue/delete",
                        contentType: "application/json",
                        data: JSON.stringify(dialogueIds),
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
		getInfo: function(dialogueId){
			$.get(baseURL + "sys/dialogue/info/"+dialogueId, function(r){
                vm.dialogue = r.dialogue;
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