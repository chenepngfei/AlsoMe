$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/quizzesresult/list',
        datatype: "json",
        colModel: [			
			{ label: 'quizzesResultId', name: 'quizzesResultId', index: 'quizzes_result_id', width: 50, key: true },
			{ label: '测试题ID', name: 'quizzesId', index: 'quizzes_id', width: 80 }, 			
			{ label: '测试结果', name: 'quizzesResult', index: 'quizzes_result', width: 80 }, 			
			{ label: '测试用户', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '1:测试题 2:卡片测试', name: 'type', index: 'type', width: 80 }, 			
			{ label: '卡片类型', name: 'cardTypeId', index: 'card_type_id', width: 80 }, 			
			{ label: '', name: 'quizzesQuestions', index: 'quizzes_questions', width: 80 }			
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
		quizzesResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.quizzesResult = {};
		},
		update: function (event) {
			var quizzesResultId = getSelectedRow();
			if(quizzesResultId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(quizzesResultId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.quizzesResult.quizzesResultId == null ? "sys/quizzesresult/save" : "sys/quizzesresult/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.quizzesResult),
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
			var quizzesResultIds = getSelectedRows();
			if(quizzesResultIds == null){
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
                        url: baseURL + "sys/quizzesresult/delete",
                        contentType: "application/json",
                        data: JSON.stringify(quizzesResultIds),
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
		getInfo: function(quizzesResultId){
			$.get(baseURL + "sys/quizzesresult/info/"+quizzesResultId, function(r){
                vm.quizzesResult = r.quizzesResult;
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