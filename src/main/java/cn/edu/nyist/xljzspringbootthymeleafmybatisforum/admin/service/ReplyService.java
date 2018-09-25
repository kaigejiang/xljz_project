
package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import java.util.Date;
import java.util.List;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Reply;

public interface ReplyService {
	List<Reply> findAllByComid(int id);

	int insert(int uid, String content, int comid, Date date);

	int delByComid(int comid);

}