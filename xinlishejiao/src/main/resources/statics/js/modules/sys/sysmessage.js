$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysmessage/list',
        datatype: "json",
        colModel: [			
			{ label: 'messageId', name: 'messageId', index: 'message_id', width: 50, key: true },
			{ label: '', name: 'messagePic', index: 'message_pic', width: 80 }, 			
			{ label: '', name: 'messageIntroduction', index: 'message_introduction', width: 80 }, 			
			{ label: '', name: 'messageContent', index: 'message_content', width: 80 }, 			
			{ label: '', name: 'messageType', index: 'message_type', width: 80 }, 			
			{ label: '', name: 'messageName', index: 'message_name', width: 80 }, 			
			{ label: '', name: 'userType', index: 'user_type', width: 80 }, 			
			{ label: '', name: 'sendTime', index: 'send_time', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'editeTime', index: 'edite_time', width: 80 }, 			
			{ label: '0:待发送 1:已发送', name: 'sendState', index: 'send_state', width: 80 }, 			
			{ label: '0:不是全部 1：全部', name: 'isAll', index: 'is_all', width: 80 }			
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
		sysMessage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysMessage = {};
		},
		update: function (event) {
			var messageId = getSelectedRow();
			if(messageId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(messageId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.sysMessage.messageId == null ? "sys/sysmessage/save" : "sys/sysmessage/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysMessage),
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
			var messageIds = getSelectedRows();
			if(messageIds == null){
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
                        url: baseURL + "sys/sysmessage/delete",
                        contentType: "application/json",
                        data: JSON.stringify(messageIds),
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
		getInfo: function(messageId){
			$.get(baseURL + "sys/sysmessage/info/"+messageId, function(r){
                vm.sysMessage = r.sysMessage;
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