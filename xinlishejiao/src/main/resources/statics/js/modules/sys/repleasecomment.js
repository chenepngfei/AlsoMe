$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/repleasecomment/list',
        datatype: "json",
        colModel: [			
			{ label: 'commentid', name: 'commentid', index: 'commentid', width: 50, key: true },
			{ label: '0：提问 1：想法 2：树洞 10:最新资讯', name: 'targetType', index: 'target_type', width: 80 }, 			
			{ label: '对应type类型', name: 'targetId', index: 'target_id', width: 80 }, 			
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'commentDesc', index: 'comment_desc', width: 80 }, 			
			{ label: '', name: 'commentTime', index: 'comment_time', width: 80 }, 			
			{ label: '', name: 'bestcomment', index: 'bestcomment', width: 80 }, 			
			{ label: '0:否 1:是', name: 'isDraft', index: 'is_draft', width: 80 }			
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
		repleaseComment: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.repleaseComment = {};
		},
		update: function (event) {
			var commentid = getSelectedRow();
			if(commentid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(commentid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.repleaseComment.commentid == null ? "sys/repleasecomment/save" : "sys/repleasecomment/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.repleaseComment),
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
			var commentids = getSelectedRows();
			if(commentids == null){
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
                        url: baseURL + "sys/repleasecomment/delete",
                        contentType: "application/json",
                        data: JSON.stringify(commentids),
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
		getInfo: function(commentid){
			$.get(baseURL + "sys/repleasecomment/info/"+commentid, function(r){
                vm.repleaseComment = r.repleaseComment;
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