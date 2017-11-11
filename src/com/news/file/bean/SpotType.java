package com.news.file.bean;

public class SpotType {
	private String nTid;
	private String nTname;
	public SpotType(String nTid, String nTname) {
		super();
		this.nTid = nTid;
		this.nTname = nTname;
	}
	public SpotType() {
		super();
	}
	public String getnTid() {
		return nTid;
	}
	public String getnTname() {
		return nTname;
	}
	public void setnTid(String nTid) {
		this.nTid = nTid;
	}
	public void setnTname(String nTname) {
		this.nTname = nTname;
	}
	@Override
	public String toString() {
		return "SpotType [nTid=" + nTid + ", nTname=" + nTname + "]";
	}
	
}
