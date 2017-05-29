package com.song.hospital.common.util;

/**
 * 常量字典
 */
public class IConstant {

	public final static String SHORT_DATE_FORMAT = "yyyy-MM-dd";

	public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public final static String NULL_STR = "";

	public final static String BLANK_STR = " ";

	public final static String SLASH_STR = "/";

	public static final String ENCODING_ISO8859 = "ISO-8859-1";

	public static final String ENCODING_ASCII = "ascii";

	public static final String ENCODING_UTF8 = "utf-8";

	public static final int SECONDS_A_DAY = 24 * 60 * 60;

	public static final int MILLISECONDS_A_DAY = SECONDS_A_DAY * 1000;

	/**
	 * 状态码
	 */
	public static final int SUCCESS = 200; // 200 请求成功

	public static final int SUCCESS_REGISTER = 201; // 201 注册成功

	public static final int SUCCESS_LOGIN = 202; // 202 登陆成功

	public static final int SUCCESS_GETUSERINFO = 203; // 203 用户信息查询成功

	public static final int SUCCESS_MODIFYPASS = 204; // 204修改密码成功

	public static final int SUCCESS_INITPASS = 205; // 205初始化密码成功

	public static final int SUCCESS_SENDPASS = 206; // 206密码发送手机成功

	public static final int SUCCESS_SENDMAIL = 207; // 207邮件发送成功

	public static final int SUCCESS_RESETPASS = 208; // 208重置密码成功

	public static final int SUCCESS_SENDVALIDCODE = 209; // 209验证码发送成功

	public static final int SUCCESS_VALIDCODE = 210; // 210验证码验证成功

	public static final int SUCCESS_GET_SESSION_TOKEN = 221; // 221 查询session_token成功

	public static final int SUCCESS_MOBILE_NOTRIGISTER = 214; // 214手机可以使用

	public static final int SUCCESS_MAIL_NOTRIGISTER = 224; // 224邮箱可以使用

	public static final int SUCCESS_USENAME_NOTRIGISTER = 234; // 234用户名可以使用

	public static final int FAILED_TOKENVALID = 411; // 411 token验证失败

	public static final int FAILED_MOBILEUSED = 413; // 413 手机已经使用

	public static final int FAILED_MAILUSED = 423; // 423 邮箱已经使用

	public static final int FAILED_USENAMEUSED = 433; // 433 用户名已经使用

	public static final int FAILED_USE_ERROR = 450; // 450用户错误

	public static final int FAILED_RIGISTER_SOURCE = 451; // 451注册来源非法

	public static final int FAILED_RIGISTER_INSERTDATA = 452; // 452注册失败,数据插入错误

	public static final int FAILED_NAMEPASS = 453; // 453用户名密码错误

	public static final int FAILED_MODIFYPASS = 454; // 454修改密码失败

	public static final int FAILED_INITPASS = 455; // 455初始化密码失败

	public static final int FAILED_SENDPASS = 456; // 456密码发送手机失败

	public static final int FAILED_VALIDCODE = 457; // 457验证码验证失败

	public static final int FAILED_MOBILE_NOTRIGISTER = 458; // 458手机未注册

	public static final int FAILED_MAIL_NOTRIGISTER = 459; // 459邮箱未注册

	public static final int FAILED_RESETPASS = 460; // 460重置密码失败

	public static final int FAILED_SENDVALIDCODE = 461; // 461验证码发送失败

	public static final int FAILED_VALIDSESSIONTOKEN = 431; // 431session_token不存在

	public static final int FAILED_YLUSER_EXSIT = 462; // 462医联账号已注册

	public static final int FAILED_NETWORK = 463; // 463网络错误

	public static final int FAILED_UNKNOWN = 464; // 464未知错误

	public static final int FAILED_DATA_NOINPUT = 491; // 491数据未输入

	public static final int FAILED_FORMAT_ERROR = 492; // 492格式错误

	public static final int FAILED_USE_NOTEXIST = 493; // 493账号不存在

	public static final int FAILED_MAIL_SEND = 494; // 494邮件发送失败

	public static final int FAILURE = 500; // 500 请求失败

	/**
	 * cookie
	 */
	public static final String HOSPITAL_COOKIE_TOKEN = "HOSPITAL_COOKIE_TOKEN"; // cookie名称

	public static final String HOSPITAL_COOKIE_EMAIL = "HOSPITAL_COOKIE_EMAIL"; // cookie名称

	public static final String HOSPITAL_COOKIE_PASSWORD = "HOSPITAL_COOKIE_PASSWORD"; // cookie名称

	public static final int HOSPITAL_COOKIE_MAXAGE = 60 * 10;// cookie最大存活时长

	/**
	 * session
	 */
	public static final String HOSPITAL_SESSION = "_USER_"; // session名称

	public static final String SESSION_USERVO_KEY_PREFIX = "session:uservo:";
}
