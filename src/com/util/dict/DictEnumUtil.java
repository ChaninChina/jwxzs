package com.util.dict;

/**
 * 字典枚举工具
 *
 * @author QingLong
 */
public interface DictEnumUtil {

	// ----------------------------------------------------------------------
	// 已固定字典枚举
	// ----------------------------------------------------------------------
	/* ----------------用户信息----------------- */
	String SESSION_USER_INFO = "SESSION_USER_INFO";
	/* ----------------访问链接----------------- */
	String SESSION_LINK_INFO = "SESSION_LINK_INFO";
	/* ----------------图形验证----------------- */
	String SESSION_VERY_CODE = "SESSION_VERY_CODE";
	/* ----------------行政区域----------------- */
	String CACHE_AREA_INFO = "CACHE_AREA_INFO_";
	/* ----------------权限信息----------------- */
	String CACHE_AUTH_INFO = "CACHE_AUTH_INFO_";
	/* ----------------字典信息----------------- */
	String CACHE_DICT_INFO = "CACHE_DICT_INFO_";
	/* ----------------机构信息----------------- */
	String CACHE_ORGN_INFO = "CACHE_ORGN_INFO";
	/* ----------------角色信息----------------- */
	String CACHE_ROLE_INFO = "CACHE_ROLE_INFO_";
	/* ----------------账号信息----------------- */
	String COOKIE_USER_DLZH = "COOKIE_USER_DLZH";

	/* ----------------分页信息----------------- */
	String DEFAULT_EVERYPAGE = "10";
	String DEFAULT_CURRENTNO = "1";
	String DEFAULT_MINI_EVERYPAGE = "6";
	String DEFAULT_MINI_CURRENTNO = "1";

	/* ----------------类型识别----------------- */
	/** 逻辑类型 */
	String TYPE_SPOT_LJLX = "9999-0001";
	/** 业务类型 */
	String TYPE_SPOT_YWLX = "9999-0003";

	/* ----------------通用字典----------------- */
	/** 是 */
	String S = "8888-0001";
	/** 否 */
	String F = "8888-0003";

	/* ---------启用状态--------- */
	/** 启用状态 */
	String ENABLE_STATUS = "1001";
	/** 启用状态(未启用) */
	String ENABLE_STATUS_WQY = "1001-0001";
	/** 启用状态(已启用 ) */
	String ENABLE_STATUS_YQY = "1001-0003";

	/* ---------删除状态--------- */
	/** 删除状态 */
	String DELETE_STATUS = "1003";
	/** 删除状态(未删除) */
	String DELETE_STATUS_WSC = "1003-0001";
	/** 删除状态(已删除 ) */
	String DELETE_STATUS_YSC = "1003-0003";

	/* ---------审核状态--------- */
	/** 审核状态 */
	String REVIEW_STATUS = "1005";
	/** 审核状态(未审核) */
	String REVIEW_STATUS_WSH = "1005-0001";
	/** 审核状态(已审核 ) */
	String REVIEW_STATUS_YSH = "1005-0003";

	/* ---------审核结果--------- */
	/** 审核结果 */
	String REVIEW_RESULT = "1007";
	/** 审核结果(未通过) */
	String REVIEW_RESULT_WTG = "1007-0001";
	/** 审核结果(已通过 ) */
	String REVIEW_RESULT_YTG = "1007-0003";

	/* ---------审核标志--------- */
	/** 审核标志 */
	String REVIEW_SYMBOL = "1009";
	/** 审核标志(不需要审核) */
	String REVIEW_SYMBOL_FALSE = "1009-0001";
	/** 审核标志(需要审核) */
	String REVIEW_SYMBOL_TRUE = "1009-0003";

	/* ---------记录状态--------- */
	/** 记录状态 */
	String RECORD_STATUS = "1011";
	/** 记录状态(历史记录) */
	String RECORD_STATUS_LSJL = "1011-0001";
	/** 记录状态(最新记录) */
	String RECORD_STATUS_ZXJL = "1011-0003";

	/* ---------编辑标志--------- */
	/** 编辑标志 */
	String REDACT_SYMBOL = "1401";
	/** 编辑标志(禁止) */
	String REDACT_SYMBOL_JZ = "1401-0001";
	/** 编辑标志(允许 ) */
	String REDACT_SYMBOL_YX = "1401-0003";

	/* ---------子集标志--------- */
	/** 子集标志 */
	String SUBSET_SYMBOL = "1403";
	/** 子集标志(没有子集) */
	String SUBSET_SYMBOL_MYZJ = "1403-0001";
	/** 子集标志(拥有子集 ) */
	String SUBSET_SYMBOL_YYZJ = "1403-0003";

	/* ---------管理标志--------- */
	/** 管理标志 */
	String MANAGE_SYMBOL = "1405";
	/** 管理标志(纳入管理) */
	String MANAGE_SYMBOL_NRGL = "1405-0001";
	/** 管理标志(越过管理 ) */
	String MANAGE_SYMBOL_YGGL = "1405-0003";

	/* ---------共享标志--------- */
	/** 共享标志 */
	String SHARED_SYMBOL = "1407";
	/** 共享标志(私有) */
	String SHARED_SYMBOL_SY = "1407-0001";
	/** 共享标志(共享) */
	String SHARED_SYMBOL_GX = "1407-0003";

	/* ---------范围标志--------- */
	/** 范围标志 */
	String EXTENT_SYMBOL = "1409";
	/** 范围标志(禁止自定义范围) */
	String EXTENT_SYMBOL_JZZDYFW = "1409-0001";
	/** 范围标志(允许自定义范围 ) */
	String EXTENT_SYMBOL_YXZDYFW = "1409-0003";

	/* ---------范围选择--------- */
	/** 范围选择 */
	String EXTENT_CHOOSE = "1413";
	/** 范围选择(默认) */
	String EXTENT_CHOOSE_MR = "1413-0001";
	/** 范围选择(指定) */
	String EXTENT_CHOOSE_ZD = "1413-0003";

	/* ---------用户类型--------- */
	/** 用户类型 */
	String USER_TYPE = "1503";
	/** 用户类型(民警) */
	String USER_TYPE_MJ = "1503-0001";
	/** 用户类型(事业 ) */
	String USER_TYPE_SY = "1503-0003";
	/** 用户类型(外聘) */
	String USER_TYPE_WP = "1503-0005";
	/** 用户类型(辅警 ) */
	String USER_TYPE_FJ = "1503-0007";
	/** 用户类型(其他 ) */
	String USER_TYPE_QT = "1503-0009";

	/* ---------区域类型--------- */
	/** 区域类型 */
	String AREA_TYPE = "1505";
	/** 区域类型(省) */
	String AREA_TYPE_SN = "1505-0001";
	/** 区域类型(市) */
	String AREA_TYPE_SI = "1505-0003";
	/** 区域类型(区县) */
	String AREA_TYPE_QX = "1505-0005";
	/** 区域类型(乡镇 ) */
	String AREA_TYPE_XZ = "1505-0007";
	/** 区域类型(村社 ) */
	String AREA_TYPE_CS = "1505-0009";

	/* ---------机构类型--------- */
	/** 机构类型 */
	String ORGN_TYPE = "1507";
	/** 机构类型(省厅) */
	String ORGN_TYPE_ST = "1507-0001";
	/** 机构类型(市局) */
	String ORGN_TYPE_SJ = "1507-0003";
	/** 机构类型(市分局) */
	String ORGN_TYPE_SFJ = "1507-0005";
	/** 机构类型(县局) */
	String ORGN_TYPE_XJ = "1507-0007";
	/** 机构类型(县分局) */
	String ORGN_TYPE_XFJ = "1507-0009";
	/** 机构类型(派出所) */
	String ORGN_TYPE_PCS = "1507-0011";

	/* ---------机构级别--------- */
	/** 机构级别 */
	String ORGN_STEP = "1509";
	/** 机构级别(一级处) */
	String ORGN_STEP_YJC = "1509-0005";
	/** 机构级别(二级处) */
	String ORGN_STEP_EJC = "1509-0007";
	/** 机构级别(科级) */
	String ORGN_STEP_KJ = "1509-0009";

	/* ---------权限类型--------- */
	/** 权限类型 */
	String AUTH_TYPE = "1511";
	/** 权限类型(菜单) */
	String AUTH_TYPE_CD = "1511-0001";
	/** 权限类型(操作) */
	String AUTH_TYPE_CZ = "1511-0003";
	/** 权限类型(群成员) */
	String AUTH_TYPE_QCY = "1511-0005";

	/* ---------附件标志--------- */
	/** 附件标志 */
	String ATTACH_SYMBOL = "1604";
	/** 附件标志(无) */
	String ATTACH_SYMBOL_W = "1605-0001";
	/** 附件标志(有) */
	String ATTACH_SYMBOL_Y = "1605-0003";

	/* ---------附件属性--------- */
	/** 附件属性 */
	String ATTACH_ATTR = "1605";
	/** 附件属性(图片) */
	String ATTACH_ATTR_TP = "1605-0001";
	/** 附件属性(视频) */
	String ATTACH_ATTR_SP = "1605-0003";
	/** 附件属性(音频) */
	String ATTACH_ATTR_YP = "1605-0005";
	/** 附件属性(文档) */
	String ATTACH_ATTR_WD = "1605-0007";

	/* ---------登录结果--------- */
	/** 登录结果 */
	String DLJG = "1713";
	/** 登录结果(失败) */
	String DLJG_SB = "1713-0001";
	/** 登录结果(成功) */
	String DLJG_CG = "1713-0003";

	/* ---------机构范围--------- */
	/** 机构范围 */
	String JGFW = "1717";
	/** 机构范围(本级) */
	String JGFW_BJ = "1717-0001";
	/** 机构范围(子集) */
	String JGFW_ZJ = "1717-0003";
	/** 机构范围(全部) */
	String JGFW_QB = "1717-0005";

	/* ---------数据操作日志操作类型--------- */
	/** 数据操作日志操作类型 */
	String SJCZRZCZLX = "1981";
	/** 数据操作日志操作类型(新增) */
	String SJCZRZCZLX_XZ = "1981-0001";
	/** 数据操作日志操作类型(查看) */
	String SJCZRZCZLX_CK = "1981-0003";
	/** 数据操作日志操作类型(编辑) */
	String SJCZRZCZLX_XG = "1981-0005";
	/** 数据操作日志操作类型(物理删除) */
	String SJCZRZCZLX_SC_WL = "1981-0007";
	/** 数据操作日志操作类型(逻辑删除) */
	String SJCZRZCZLX_SC_LJ = "1981-0009";
	// ----------------------------------------------------------------------
	// 非固定字典枚举
	// ----------------------------------------------------------------------

	/** 职务 */
	String ZW = "2007";
	/** 职务(厅长) */
	String ZW_TZ = "2007-0001";
	/** 职务(副厅长) */
	String ZW_FTZ = "2007-0003";
	/** 职务(政委) */
	String ZW_ZW = "2007-0005";
	/** 职务(巡视员) */
	String ZW_XSY = "2007-0007";
	/** 职务(副巡视员) */
	String ZW_FXSY = "2007-0009";
	/** 职务(主任) */
	String ZW_ZR = "2007-0011";
	/** 职务(副主任) */
	String ZW_FZR = "2007-0013";

	/** 性别 */
	String XB = "2001";
	/** 性别-男 */
	String XB_MAN = "2001-0001";
	/** 性别-女 */
	String XB_WOMAN = "2001-0003";
	/** 性别-未知 */
	String XB_WZ = "2001-0005";

	/* ---------记录周期类型--------- */
	/** 记录周期类型 */
	String JLZQ = "2004";
	/** 记录周期类型(每小时) */
	String JLZQ_HOUR = "2004-0001";
	/** 记录周期类型(每日) */
	String JLZQ_DAY = "2004-0002";
	/** 记录周期类型 (每周) */
	String JLZQ_WEEK = "2004-0003";
	/** 记录周期类型 (每月) */
	String JLZQ_MONTH = "2004-0004";
	/** 记录周期类型(每季) */
	String JLZQ_QUARTER = "2004-0005";
	/** 记录周期类型(每年) */
	String JLZQ_YEAR = "2004-0006";
	/** 记录周期类型(无期限) */
	String JLZQ_NONE = "2004-0007";

	/* ---------管理员标志--------- */
	/** 管理员标志 */
	String GLYBZ = "2010";
	/** 是管理员 */
	String GLYBZ_TRUE = "2010-0001";
	/** 不是管理员 */
	String GLYBZ_FALSE = "2010-0003";

	/* ---------提醒类型--------- */
	/** 提醒类型 */
	String TXLX = "2011";
	/** 提醒类型(不提醒) */
	String TXLX_NONE = "2011-0001";
	/** 提醒类型(短信提醒) */
	String TXLX_NOTE = "2011-0003";
	/** 提醒类型(推送提醒) */
	String TXLX_PUSH = "2011-0005";
	/** 提醒类型(自动提醒) */
	String TXLX_AUTO = "2011-0007";

	/* ---------共享类型--------- */
	/** 共享类型 */
	String GXLX = "2012";
	/** 共享类型(不共享) */
	String GXLX_NONE = "2012-0001";
	/** 共享类型(全部共享) */
	String GXLX_QBGX = "2012-0003";
	/** 共享类型(部分共享) */
	String GXLX_BFGX = "2012-0005";

	/*----------  平台 ---------*/
	/** 平台 */
	String PT = "2014";
	/** 平台(WEB) */
	String PT_WEB = "2014-0001";
	/** 平台(APP) */
	String PT_APP = "2014-0003";

	/*----------  帐号类型 ---------*/
	/** 帐号类型 */
	String ZHLX = "2015";
	/** 帐号类型(身份证) */
	String ZHLX_SFZ = "2015-0001";
	/** 帐号类型(手机号) */
	String ZHLX_SJH = "2015-0003";
	/** 帐号类型(邮箱) */
	String ZHLX_YX = "2015-0005";
	/** 帐号类型(自定义) */
	String ZHLX_ZDY = "2015-0007";

	/*----------  消息类型 ----1-----*/
	/** 消息类型 */
	String XXLX = "2016";
	/** 消息类型(系统消息) */
	String XXLX_XTXX = "2016-0001";
	/** 消息类型(任务消息) */
	String XXLX_RWXX = "2016-0003";
	/** 消息类型(群组消息) */
	String XXLX_QZXX = "2016-0005";

	/* ---------系统配置------1--- */
	/** 系统配置 */
	String XTPZ = "2017";
	/** 系统配置(名称) */
	String XTPZ_XTMC = "2017-0001";
	/** 系统配置(作者) */
	String XTPZ_XTZZ = "2017-0003";
	/** 系统配置(版权) */
	String XTPZ_XTBQ = "2017-0005";

	/* -------标识码类型-------- */
	/** 标识码类型 */
	String BSMLX = "2018";
	/** 标识码类型(二维码) */
	String XTPZ_RWM = "2018-0001";
	/** 标识码类型(邀请码) */
	String XTPZ_YQM = "2018-0003";

	/* ---------任务类型--------- */
	/** 任务类型 */
	String RWLX = "2019";
	/** 任务类型(共享任务) */
	String RWLX_GXRW = "2019-0001";
	/** 任务类型(个人任务) */
	String RWLX_GRRW = "2019-0003";
	/** 任务类型(协同任务) */
	String RWLX_XTRW = "2019-0005";

	/* ---------选项标志--------- */
	/** 选项标志 */
	String XXBZ = "2020";
	/** 选项标志(无) */
	String XXBZ_W = "2020-0001";
	/** 选项标志(有) */
	String XXBZ_Y = "2020-0003";

	/* -----选项扩展标志----- */
	/** 选项扩展标志 */
	String XXKZBZ = "2021";
	/** 选项扩展标志(无) */
	String XXKZBZ_W = "2021-0001";
	/** 选项扩展标志(有) */
	String XXKZBZ_Y = "2021-0003";

	/* -----选项扩展类型----- */
	/** 选项扩展类型 */
	String XXKZLX = "2022";
	/** 选项扩展类型(文本) */
	String XXKZLX_WB = "2022-0001";

	/* -------控制项类型------- */
	/** 控制项类型 */
	String KZXLX = "2023";
	/** 控制项类型(条目) */
	String KZXLX_TM = "2023-0001";
	/** 控制项类型(选项) */
	String KZXLX_XX = "2023-0003";
	/** 控制项类型(选项扩展) */
	String KZXLX_XXKZ = "2023-0005";

	/* ---------默认状态--------- */
	/** 默认状态 */
	String MRZT = "2024";
	/** 默认状态(隐藏) */
	String MRZT_YC = "2024-0001";
	/** 默认状态(显示) */
	String MRZT_XS = "2024-0003";

	/* ---------控制条件--------- */
	/** 控制条件 */
	String KZTJ = "2025";
	/** 控制条件(选择) */
	String KZTJ_XZ = "2025-0001";
	/** 控制条件(填写) */
	String KZTJ_TX = "2025-0003";

	/* ---------控制结果--------- */
	/** 控制结果 */
	String KZJG = "2026";
	/** 控制结果(已填、已选 并且 显示) */
	String KZJG_Y_XS = "2026-0001";
	/** 控制结果(已填、已选 并且 隐藏) */
	String KZJG_Y_YC = "2026-0003";
	/** 控制结果(未填、未选 并且 显示) */
	String KZJG_W_XS = "2026-0005";
	/** 控制结果(未填、未选 并且 隐藏) */
	String KZJG_W_YC = "2026-0007";

	/* --实体简介类型-- */
	/** 实体简介类型 */
	String STJJLX = "2027";
	/** 实体简介类型(文本) */
	String STJJLX_WB = "2027-0001";
	/** 实体简介类型(富文本) */
	String STJJLX_FWB = "2027-0003";

	/* ---------实体类型--------- */
	/** 实体类型 */
	String STLX = "2028";
	/** 实体类别-会议签到 */
	String STLX_HYQD = "2028-0001";
	/** 实体类别-上班打卡 */
	String STLX_SBDK = "2028-0003";
	/** 实体类别-巡逻盘查 */
	String STLX_XLPC = "2028-0005";
	/** 实体类别-自定义 */
    String STLX_ZDY = "2028-9999";

	/* ---------控制项属性--------- */
	/** 控制项属性 */
	String KZX_SX = "2029";
	/** 控制项属性（文本） */
	String KZX_SX_WB = "2029-0001";
	/** 控制项属性（选项） */
	String KZX_SX_XX = "2029-0003";

	/* ---------记录条目类型--------- */
	/** 文本 */
	String TMLX_WB = "2050";
	/** 文本-单行文本 */
	String TMLX_WB_DHWB = "2050-0001";
	/** 文本-多行文本 */
	String TMLX_WB_DHWBS = "2050-0003";
//	/** 文本-富文本 */ 未录入
//	String TMLX_WB_FWB = "2050-0004";
	/** 文本-身份证 */
	String TMLX_WB_SFZH = "2050-0005";
	/** 文本-手机号 */
	String TMLX_WB_SJH = "2050-0006";
	/** 文本- 位置 */
	String TMLX_WB_WZ = "2050-0007";
	/** 时间 */
	String TMLX_WB_SJ = "2050-0008";
	/** 日期 */
	String TMLX_WB_RQ = "2050-0009";
	/** 日期和时间 */
	String TMLX_WB_RQSJ = "2050-0010";

	/** 隐藏 */
	String TMLX_YC = "2052";
	/** 隐藏位置 */
	String TMLX_YC_WZ = "2052-0001";

	/** 单选 */
	String TMLX_DX = "2054";
	/** 单选-普通单选 */
	String TMLX_DX_PTDX = "2054-0001";
	/** 单选-性别 */
	String TMLX_DX_XB = "2054-0002";
	/** 单选-简单单选(是否) */
	String TMLX_DX_JDDX = "2054-0003";
//	/** 单选-区域 */ 未录入
//	String TMLX_DX_QY = "2054-0004";

	/** 多选 */
	String TMLX_MDX = "2056";
	/** 多选-普通 */
	String TMLX_MDX_PT = "2056-0001";

	/** 联动 */
	String TMLX_LD = "2057";
	/** 联动-普通 */
	String TMLX_LD_PT = "2057-0001";
	/** 联动-区域 */
	String TMLX_LD_QY = "2057-0003";

	/** 附件 */
	String TMLX_FJ = "2058";
	/** 录音 */
	String TMLX_FJ_LY = "2058-0001";
	/** 图片 */
	String TMLX_FJ_TP = "2058-0002";
	/** 视频 */
	String TMLX_FJ_SP = "2058-0003";
	/** 文件 */
	String TMLX_FJ_WJ = "2058-0004";
	
	/** 层级联动 */
	String CJLD = "2060";
	/** 层级联动-普通联动 */
	String TMLX_CJLD_PTLD = "2060-0001";
	/** 层级联动-位置联动 */
	String TMLX_CJLD_WZLD = "2060-0003";
	


	/* ---------群成员角色--------- */
	/** 群成员角色 */
	String QCYJS = "2060";
	/** 群成员角色-群主 */
	String QCYJS_QZ = "2060-0001";
	/** 群成员角色-一级管理员 */
	String QCYJS_ONE = "2060-0003";
	/** 群成员角色-二级管理员 */
	String QCYJS_TWO = "2060-0005";
	/** 群成员角色-三级管理员*/
	String QCYJS_THREE = "2060-0007";
	/** 群成员角色-普通成员*/
	String QCYJS_CY = "2060-0009";
	
	
	// TODO
	/*----------  模板类型 ---------*/
	/** 模板类型 */
	String MBLX = "2062";
	/** 模板类型-普通模板*/
	String MBLX_QZ = "2062-0001";


	// TODO
	/*----------  完成状态     ---------*/
	/** 完成状态*/
	String WCZT = "2064";
	/** 完成状态  -未完成*/
	String WCZT_WWC = "2064-0001";
	/** 完成状态  -已完成*/
	String WCZT_YWC = "2064-0003";
	
	// TODO
	/*----------  完成状态     ---------*/
	/** 消息阅读状态*/
	String YDZT = "2066";
	/** 消息阅读状态  -未阅读*/
	String YDZT_WWD = "2066-0001";
	/** 消息阅读状态  -已阅读*/
	String YDZT_YYD = "2066-0003";



	//审核标志修改
	
	// TODO
	/* ---------条目分组类型--------- */
	/** 条目分组类型 */
	String TMFZLX = "3010";
	/** 条目分组类型-普通 */
	String TMFZLX_PT = "3010-0001";
	/** 条目分组类型-列表 */
	String TMFZLX_LB = "3010-0003";

	//审核标志修改

	/* ---------服务标签--------- */

	/* ---------群组级别--------- */

	/* ---------群组类型--------- */

}