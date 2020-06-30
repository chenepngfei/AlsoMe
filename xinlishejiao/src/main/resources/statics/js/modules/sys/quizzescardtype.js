$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/quizzescardtype/list',
        datatype: "json",
        colModel: [			
			{ label: 'quizzesTypeId', name: 'quizzesTypeId', index: 'quizzes_type_id', width: 50, key: true },
			{ label: '', name: 'quizzesTypeName', index: 'quizzes_type_name', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '1: 测试题分类(弃用)     2:卡片分类', name: 'type', index: 'type', width: 80 }, 			
			{ label: '', name: 'pictureUrl', index: 'picture_url', width: 80 }, 			
			{ label: '', name: 'price', index: 'price', width: 80 }, 			
			{ label: '', name: 'quizzesCardDescribe', index: 'quizzes_card_describe', width: 80 }, 			
			{ label: '完成测试数', name: 'hasCardNum', index: 'has_card_num', width: 80 }			
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
		quizzesCardType: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.quizzesCardType = {};
		},
		update: function (event) {
			var quizzesTypeId = getSelectedRow();
			if(quizzesTypeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(quizzesTypeId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.quizzesCardType.quizzesTypeId == null ? "sys/quizzescardtype/save" : "sys/quizzescardtype/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.quizzesCardType),
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
			var quizzesTypeIds = getSelectedRows();
			if(quizzesTypeIds == null){
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
                        url: baseURL + "sys/quizzescardtype/delete",
                        contentType: "application/json",
                        data: JSON.stringify(quizzesTypeIds),
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
		getInfo: function(quizzesTypeId){
			$.get(baseURL + "sys/quizzescardtype/info/"+quizzesTypeId, function(r){
                vm.quizzesCardType = r.quizzesCardType;
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