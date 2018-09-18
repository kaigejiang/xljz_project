package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


/**
 * @author binxu
 *  用户实体类
 */
public class User implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private int id;
	@Size(min=1,max=20,message="{required.book.name}")
	private String name;
	@Length(min=6,max=20,message="{length.user.pwd}")
	private String pwd;
	private String descri;
	private String photo;

	public User() {
		
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", descri=" + descri + ", photo=" + photo + "]";
	}
	

}
