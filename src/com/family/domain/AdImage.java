package com.family.domain;

public class AdImage {
	private String url;
	private boolean success;
	private Integer cid;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public AdImage(String url, boolean success, Integer cid) {
		super();
		this.url = url;
		this.success = success;
		this.cid = cid;
	}
	
}
