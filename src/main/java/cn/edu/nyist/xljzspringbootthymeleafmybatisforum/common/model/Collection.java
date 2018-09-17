package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;


/**
 * @author binxu
 *  收藏实体类
 */
public class Collection implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cid;//外键 -->帖子
	private int uid;//外键 --->user
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Collection [cid=" + cid + ", uid=" + uid + "]";
	}
	
}
