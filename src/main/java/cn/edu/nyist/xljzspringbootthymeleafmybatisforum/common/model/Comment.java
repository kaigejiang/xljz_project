package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;


/**
 * @author binxu
 *  评论实体类
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String content;//评论的内容
	private int cid;//外键-->帖子card
	private int uid;//外键 -->用户表user

	public Comment() {
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
		return "Comment [id=" + id + ", content=" + content + ", cid=" + cid + ", uid=" + uid + "]";
	}
	

}
