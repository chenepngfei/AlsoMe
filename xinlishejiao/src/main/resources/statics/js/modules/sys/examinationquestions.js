$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/examinationquestions/list',
        datatype: "json",
        colModel: [			
			{ label: 'examinationQuestionsId', name: 'examinationQuestionsId', index: 'examination_questions_id', width: 50, key: true },
			{ label: '', name: 'questionsName', index: 'questions_name', width: 80 }, 			
			{ label: '', name: 'questionsDescribe', index: 'questions_describe', width: 80 }, 			
			{ label: '', name: 'answer', index: 'answer', width: 80 }, 			
			{ label: '', name: 'examinationPaperId', index: 'examination_paper_id', width: 80 }, 			
			{ label: '1:单选题 2:多选题 3:简单题', name: 'type', index: 'type', width: 80 }, 			
			{ label: '', name: 'chapterId', index: 'chapter_id', width: 80 }			
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
		examinationQuestions: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.examinationQuestions = {};
		},
		update: function (event) {
			var examinationQuestionsId = getSelectedRow();
			if(examinationQuestionsId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(examinationQuestionsId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.examinationQuestions.examinationQuestionsId == null ? "sys/examinationquestions/save" : "sys/examinationquestions/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.examinationQuestions),
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
			var examinationQuestionsIds = getSelectedRows();
			if(examinationQuestionsIds == null){
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
                        url: baseURL + "sys/examinationquestions/delete",
                        contentType: "application/json",
                        data: JSON.stringify(examinationQuestionsIds),
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
		getInfo: function(examinationQuestionsId){
			$.get(baseURL + "sys/examinationquestions/info/"+examinationQuestionsId, function(r){
                vm.examinationQuestions = r.examinationQuestions;
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