$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/quizzesmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'quizzesId', name: 'quizzesId', index: 'quizzes_id', width: 50, key: true },
			{ label: '', name: 'quizzesUrl', index: 'quizzes_url', width: 80 }, 			
			{ label: '', name: 'quizzesTitle', index: 'quizzes_title', width: 80 }, 			
			{ label: '', name: 'quizzesContent', index: 'quizzes_content', width: 80 }, 			
			{ label: '', name: 'quizzesTypeId', index: 'quizzes_type_id', width: 80 }, 			
			{ label: '', name: 'quizzesPrice', index: 'quizzes_price', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '0:启用 1:停用', name: 'useStatus', index: 'use_status', width: 80 }, 			
			{ label: '0：未删除 1：已删除', name: 'useDel', index: 'use_del', width: 80 }, 			
			{ label: '', name: 'hasTestNun', index: 'has_test_nun', width: 80 }, 			
			{ label: '', name: 'quizzesQuestions', index: 'quizzes_questions', width: 80 }, 			
			{ label: '', name: 'quizzesResult', index: 'quizzes_result', width: 80 }			
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
		quizzesManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.quizzesManage = {};
		},
		update: function (event) {
			var quizzesId = getSelectedRow();
			if(quizzesId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(quizzesId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.quizzesManage.quizzesId == null ? "sys/quizzesmanage/save" : "sys/quizzesmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.quizzesManage),
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
			var quizzesIds = getSelectedRows();
			if(quizzesIds == null){
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
                        url: baseURL + "sys/quizzesmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(quizzesIds),
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
		getInfo: function(quizzesId){
			$.get(baseURL + "sys/quizzesmanage/info/"+quizzesId, function(r){
                vm.quizzesManage = r.quizzesManage;
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