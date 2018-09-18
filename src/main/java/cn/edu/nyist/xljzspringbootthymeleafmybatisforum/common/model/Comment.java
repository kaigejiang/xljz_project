package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;
import java.util.List;


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
	private User user;//关联用户表
	private List<Reply> replys;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", cid=" + cid + ", uid=" + uid + ", user=" + user + "]";
	}
	

}
