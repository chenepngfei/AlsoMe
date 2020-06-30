package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("mb_user")
public class MbUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userId;
	/**
	 * 
	 */
	private String userNickName;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String userPicture;
	/**
	 * 
	 */
	private String mailbox;
	/**
	 * 
	 */
	private Date birthday;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private String city;
	/**
	 * 1:
	 */
	private Integer sex;
	/**
	 * 
	 */
	private String hobby;
	/**
	 * 
	 */
	private String userGrade;
	/**
	 * 0:非会员 1粉金会员,2青金会员,3铂金会员
	 */
	private String memberGrade;
	/**
	 * 1:普通用户  2:seeker  3:help   4:专家
	 */
	private Integer userType;
	/**
	 * 
	 */
	private Date memberEndTime;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date editeTime;
	/**
	 * 0:未冻结  大于0为冻结的剩余天数
	 */
	private Integer isFroen;
	/**
	 * 0:正常 1:删除
	 */
	private Integer isDel;
	/**
	 * 金币金额
	 */
	private Integer gold;
	/**
	 * 人民币金额
	 */
	private BigDecimal money;
	/**
	 * 是否匹配 0;不允许  1:允许
	 */
	private Integer isMate;
	/**
	 * 匹配剩余次数
	 */
	private Integer mateNumber;
	/**
	 * 好评率
	 */
	private Double favoravleRate;
	/**
	 * 帮助次数
	 */
	private Integer helpNumber;
	/**
	 * 
	 */
	private Date usercurrentlogintime;
	/**
	 * 
	 */
	private String usercurrentloginip;
	/**
	 * 邀请码
	 */
	private String invitationCode;
	/**
	 * 
	 */
	private String introduction;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private Integer haseditnick;
	/**
	 * 1:马甲1 2:马甲23:马甲3 4:马甲4
	 */
	private String cover;
	/**
	 * 
	 */
	private Integer hasaccept;
	/**
	 * 
	 */
	private Integer appointmentAmount;
	/**
	 * 
	 */
	private String withdrawPass;
	/**
	 * 
	 */
	private BigDecimal earnings;
	/**
	 * 
	 */
	private String idCarJust;
	/**
	 * 
	 */
	private String idCarBack;
	/**
	 * 领域
	 */
	private String field;
	/**
	 * 擅长
	 */
	private String beGoodAt;
	/**
	 * 注册测试结果
	 */
	private String registerTestResult;
	/**
	 * 学习天数
	 */
	private Integer learningDays;
	/**
	 * 卡片每日剩余抽取次数
	 */
	private Integer cardTestNumber;
	/**
	 * 环信ID
	 */
	private String easemobuuid;
	/**
	 * 环信密码
	 */
	private String huanxinPassword;
	/**
	 * 是否在线 0:否 1:是
	 */
	private Integer isOnline;
	/**
	 * 账号注销原因
	 */
	private String delReason;
	/**
	 * 微信用户ID
	 */
	private String wechatOpenId;
	/**
	 * 0：账号密码登录 1：账号验证码登录 2:qq登录 3:微信登录 4:微博登录 5:ios登录
	 */
	private Integer loginType;
	/**
	 * QQID
	 */
	private String qqId;
	/**
	 * 微博ID
	 */
	private String weiboId;
	/**
	 * 苹果ID
	 */
	private String iosId;
	/**
	 * 帮助时长
	 */
	private Integer helpTime;
	/**
	 * 
	 */
	private Integer freeService;
	/**
	 * 用户注册设备号
	 */
	private String equipmentNo;
	/**
	 * 经度
	 */
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
	private BigDecimal latitude;

}
