package com.news.file.bean;

import java.io.Serializable;
import java.sql.Date;

public class Spot implements Serializable{
	private String nId;
	private String nTid;
	private String nAuthor;
	private Date nTime;
	private String nTitle;
	public Spot(String nId, String nTid, String nAuthor, Date nTime,
			String nTitle) {
		super();
		this.nId = nId;
		this.nTid = nTid;
		this.nAuthor = nAuthor;
		this.nTime = nTime;
		this.nTitle = nTitle;
	}
	public Spot() {
		super();
	}
	public String getnId() {
		return nId;
	}
	public String getnTid() {
		return nTid;
	}
	public String getnAuthor() {
		return nAuthor;
	}
	public Date getnTime() {
		return nTime;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public void setnTid(String nTid) {
		this.nTid = nTid;
	}
	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}
	public void setnTime(Date nTime) {
		this.nTime = nTime;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	@Override
	public String toString() {
		return "Spot [nId=" + nId + ", nTid=" + nTid + ", nAuthor=" + nAuthor
				+ ", nTime=" + nTime + ", nTitle=" + nTitle + "]";
	}
}
