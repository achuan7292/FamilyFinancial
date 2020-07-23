package com.family.domain;

import java.io.Serializable;

/**
 * 返回成功
 * @author 宇宙无敌川大�?
 *
 */
public class Result implements Serializable{
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
}
