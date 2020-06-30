$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysversion/list',
        datatype: "json",
        colModel: [			
			{ label: 'sysversionid', name: 'sysversionid', index: 'SysVersionId', width: 50, key: true },
			{ label: '', name: 'versionexplain', index: 'VersionExplain', width: 80 }, 			
			{ label: '', name: 'versiontime', index: 'VersionTime', width: 80 }, 			
			{ label: '', name: 'versionurl', index: 'VersionUrl', width: 80 }, 			
			{ label: '', name: 'versionlowest', index: 'VersionLowest', width: 80 }, 			
			{ label: '', name: 'version', index: 'Version', width: 80 }, 			
			{ label: '', name: 'versionname', index: 'VersionName', width: 80 }, 			
			{ label: '1:强制 0:非强制', name: 'versionupdate', index: 'Versionupdate', width: 80 }, 			
			{ label: '订单服务费', name: 'serviceCharge', index: 'service_charge', width: 80 }			
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
		sysVersion: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysVersion = {};
		},
		update: function (event) {
			var sysversionid = getSelectedRow();
			if(sysversionid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(sysversionid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.sysVersion.sysversionid == null ? "sys/sysversion/save" : "sys/sysversion/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysVersion),
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
			var sysversionids = getSelectedRows();
			if(sysversionids == null){
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
                        url: baseURL + "sys/sysversion/delete",
                        contentType: "application/json",
                        data: JSON.stringify(sysversionids),
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
		getInfo: function(sysversionid){
			$.get(baseURL + "sys/sysversion/info/"+sysversionid, function(r){
                vm.sysVersion = r.sysVersion;
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