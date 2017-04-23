package com.song.hospital.common.util;

public class ResultObj<T> extends ResultInfo {

	public static final int RECODE_OK = 200;

	public static final int RECODE_FAIL = 404;

	public static final int NO_LOGIN = -2;

	public static final String SUCCESS = "success";

	public static final String ERROR = "error";

	public static final String LOGIN = "您还没有登录，请登录！";

	private T result;// output

	public ResultObj() {
		super();
	}

	public ResultObj(int code, String msg) {
		super(code, msg);
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public ResultObj<T> successMsg() {
		this.code = RECODE_OK;
		this.msg = SUCCESS;
		return this;
	}

	public ResultObj<T> successMsg(String successMsg) {
		this.code = RECODE_OK;
		this.msg = successMsg;
		return this;
	}

	public ResultObj<T> errorMsg() {
		this.code = RECODE_FAIL;
		this.msg = ERROR;
		return this;
	}

	public ResultObj<T> errorMsg(String errorMsg) {
		this.code = RECODE_FAIL;
		this.msg = errorMsg;
		return this;
	}

	public ResultObj<T> loginMsg() {
		this.code = NO_LOGIN;
		this.msg = LOGIN;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtil.getJsonData(this);
	}

}
