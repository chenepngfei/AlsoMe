$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/meditationmanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'meditationId', name: 'meditationId', index: 'meditation_id', width: 50, key: true },
			{ label: '', name: 'meditationName', index: 'meditation_name', width: 80 }, 			
			{ label: '', name: 'meditationPic', index: 'meditation_pic', width: 80 }, 			
			{ label: '', name: 'musicName', index: 'music_name', width: 80 }, 			
			{ label: '', name: 'musicUrl', index: 'music_url', width: 80 }, 			
			{ label: '', name: 'meditationDescrible', index: 'meditation_describle', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '文件时长', name: 'duration', index: 'duration', width: 80 }			
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
		meditationManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.meditationManage = {};
		},
		update: function (event) {
			var meditationId = getSelectedRow();
			if(meditationId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(meditationId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.meditationManage.meditationId == null ? "sys/meditationmanage/save" : "sys/meditationmanage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.meditationManage),
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
			var meditationIds = getSelectedRows();
			if(meditationIds == null){
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
                        url: baseURL + "sys/meditationmanage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(meditationIds),
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
		getInfo: function(meditationId){
			$.get(baseURL + "sys/meditationmanage/info/"+meditationId, function(r){
                vm.meditationManage = r.meditationManage;
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