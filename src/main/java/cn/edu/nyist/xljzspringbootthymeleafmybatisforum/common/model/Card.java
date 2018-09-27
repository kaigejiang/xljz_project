package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author binxu
 *  帖子实体类
 */
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String content;//帖子的内容
	private int uid;//外键 -->用户表user
	private int praise;//点赞数
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pubDate;// 发布时间
	private int tid;
	private User user;
	private Type type;
	
	public Card() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", content=" + content + ", uid=" + uid + ", praise=" + praise
				+ ", pubDate=" + pubDate + "]";
	}


	

	
}
