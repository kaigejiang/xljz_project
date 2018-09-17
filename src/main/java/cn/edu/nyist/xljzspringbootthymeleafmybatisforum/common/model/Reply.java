package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;


/**
 * @author binxu
 *  回复实体类
 */
public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String content;
	private int uid;//外键-->用户表
	private int comid;//外键-->评论表

	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}

}
