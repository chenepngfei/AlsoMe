$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/mbuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '', name: 'userNickName', index: 'user_nick_name', width: 80 }, 			
			{ label: '', name: 'password', index: 'password', width: 80 }, 			
			{ label: '', name: 'userPicture', index: 'user_picture', width: 80 }, 			
			{ label: '', name: 'mailbox', index: 'mailbox', width: 80 }, 			
			{ label: '', name: 'birthday', index: 'birthday', width: 80 }, 			
			{ label: '', name: 'phone', index: 'phone', width: 80 }, 			
			{ label: '', name: 'country', index: 'country', width: 80 }, 			
			{ label: '', name: 'city', index: 'city', width: 80 }, 			
			{ label: '1:', name: 'sex', index: 'sex', width: 80 }, 			
			{ label: '', name: 'hobby', index: 'hobby', width: 80 }, 			
			{ label: '', name: 'userGrade', index: 'user_grade', width: 80 }, 			
			{ label: '0:非会员 1粉金会员,2青金会员,3铂金会员', name: 'memberGrade', index: 'member_grade', width: 80 }, 			
			{ label: '1:普通用户  2:seeker  3:help   4:专家', name: 'userType', index: 'user_type', width: 80 }, 			
			{ label: '', name: 'memberEndTime', index: 'member_end_time', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'editeTime', index: 'edite_time', width: 80 }, 			
			{ label: '0:未冻结  大于0为冻结的剩余天数', name: 'isFroen', index: 'is_froen', width: 80 }, 			
			{ label: '0:正常 1:删除', name: 'isDel', index: 'is_del', width: 80 }, 			
			{ label: '金币金额', name: 'gold', index: 'gold', width: 80 }, 			
			{ label: '人民币金额', name: 'money', index: 'money', width: 80 }, 			
			{ label: '是否匹配 0;不允许  1:允许', name: 'isMate', index: 'is_mate', width: 80 }, 			
			{ label: '匹配剩余次数', name: 'mateNumber', index: 'mate_number', width: 80 }, 			
			{ label: '好评率', name: 'favoravleRate', index: 'favoravle_rate', width: 80 }, 			
			{ label: '帮助次数', name: 'helpNumber', index: 'help_number', width: 80 }, 			
			{ label: '', name: 'usercurrentlogintime', index: 'UserCurrentLoginTime', width: 80 }, 			
			{ label: '', name: 'usercurrentloginip', index: 'UserCurrentLoginIP', width: 80 }, 			
			{ label: '邀请码', name: 'invitationCode', index: 'invitation_code', width: 80 }, 			
			{ label: '', name: 'introduction', index: 'introduction', width: 80 }, 			
			{ label: '', name: 'age', index: 'age', width: 80 }, 			
			{ label: '', name: 'haseditnick', index: 'haseditnick', width: 80 }, 			
			{ label: '1:马甲1 2:马甲23:马甲3 4:马甲4', name: 'cover', index: 'cover', width: 80 }, 			
			{ label: '', name: 'hasaccept', index: 'hasaccept', width: 80 }, 			
			{ label: '', name: 'appointmentAmount', index: 'appointment_amount', width: 80 }, 			
			{ label: '', name: 'withdrawPass', index: 'withdraw_pass', width: 80 }, 			
			{ label: '', name: 'earnings', index: 'earnings', width: 80 }, 			
			{ label: '', name: 'idCarJust', index: 'id_car_just', width: 80 }, 			
			{ label: '', name: 'idCarBack', index: 'id_car_back', width: 80 }, 			
			{ label: '领域', name: 'field', index: 'field', width: 80 }, 			
			{ label: '擅长', name: 'beGoodAt', index: 'be_good_at', width: 80 }, 			
			{ label: '注册测试结果', name: 'registerTestResult', index: 'register_test_result', width: 80 }, 			
			{ label: '学习天数', name: 'learningDays', index: 'learning_days', width: 80 }, 			
			{ label: '卡片每日剩余抽取次数', name: 'cardTestNumber', index: 'card_test_number', width: 80 }, 			
			{ label: '环信ID', name: 'easemobuuid', index: 'easemobuuid', width: 80 }, 			
			{ label: '环信密码', name: 'huanxinPassword', index: 'huanxin_password', width: 80 }, 			
			{ label: '是否在线 0:否 1:是', name: 'isOnline', index: 'is_online', width: 80 }, 			
			{ label: '账号注销原因', name: 'delReason', index: 'del_reason', width: 80 }, 			
			{ label: '微信用户ID', name: 'wechatOpenId', index: 'wechat_open_id', width: 80 }, 			
			{ label: '0：账号密码登录 1：账号验证码登录 2:qq登录 3:微信登录 4:微博登录 5:ios登录', name: 'loginType', index: 'login_type', width: 80 }, 			
			{ label: 'QQID', name: 'qqId', index: 'qq_id', width: 80 }, 			
			{ label: '微博ID', name: 'weiboId', index: 'weibo_id', width: 80 }, 			
			{ label: '苹果ID', name: 'iosId', index: 'ios_id', width: 80 }, 			
			{ label: '帮助时长', name: 'helpTime', index: 'help_time', width: 80 }, 			
			{ label: '', name: 'freeService', index: 'free_service', width: 80 }, 			
			{ label: '用户注册设备号', name: 'equipmentNo', index: 'equipment_no', width: 80 }, 			
			{ label: '经度', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '纬度', name: 'latitude', index: 'latitude', width: 80 }			
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
		mbUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.mbUser = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.mbUser.userId == null ? "sys/mbuser/save" : "sys/mbuser/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.mbUser),
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
			var userIds = getSelectedRows();
			if(userIds == null){
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
                        url: baseURL + "sys/mbuser/delete",
                        contentType: "application/json",
                        data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			$.get(baseURL + "sys/mbuser/info/"+userId, function(r){
                vm.mbUser = r.mbUser;
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