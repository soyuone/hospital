package com.song.hospital.common.util;

public class ResultInfo {

	protected int code;// <成功/失败/错误等状态码>

	protected String msg;// <成功/失败/错误时的额外信息>

	public ResultInfo() {

	}

	public ResultInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	// 创建一个空消息对象
	public static ResultInfo newResultInfo() {
		return new ResultInfo();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return JsonUtil.getJsonData(this);
	}

}
