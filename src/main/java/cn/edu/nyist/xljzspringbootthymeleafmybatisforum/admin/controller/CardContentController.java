package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.DocumentException;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CollectionService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.ReplyService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.UserService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Collection;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

@Controller
public class CardContentController {
	@Autowired
	private  CardService cardService;
	@Autowired
	private  UserService useService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CollectionService collectionService;
	@RequestMapping("/toCardContent")
	//参数要通过主页面传参过来一个ID
	public String toCard(Model model,HttpSession session,@RequestParam(defaultValue="1") int cid) {
		//获得该帖子的全部
		Card card=cardService.findById(cid);
		User user=useService.findById(card.getUid());
		List<Comment> comments=commentService.findAllByCid(card.getId());
		//收藏
		User user1=(User) session.getAttribute("user");
		int uid=0;
		if(user1!=null) {
			uid=user1.getId();
		}
		System.out.println("uid////"+uid);
		Collection collection= collectionService.findBy(uid,cid);
		//解析帖子内容
		//String docName=card.getContent();
		String outPutName=card.getContent();
		
	
		model.addAttribute("outPut", outPutName);
		model.addAttribute("collection", collection);
		model.addAttribute("card", card);
		model.addAttribute("user", user);
		model.addAttribute("comments", comments);
		return "cardContent";
	}
	@RequestMapping("/commentAdd")
	@ResponseBody
	public Map<String, Object> commentAdd(@RequestParam("cuid") int uid,@RequestParam("ccontent") String content,@RequestParam("ccid") int cid) {
		Date date=new Date();
		int ret=commentService.insert(uid,content,cid,date);
		
		Map<String, Object> map=new HashMap<>();
		if(ret>0) {
			map.put("url", "/toCardContent?cid="+cid);
		}else {
			map.put("url", "/err");
		}
		return map;
	}
	
	@RequestMapping("/replyAdd")
	public String replyAdd(@RequestParam("ruid") int uid,@RequestParam("rcontent") String content,@RequestParam("rcomid") int comid, @RequestParam("rcid") int cid) {
		Date date=new Date();
		int ret=replyService.insert(uid,content,comid,date);
	
		
		if(ret>0) {
			return "redirect:/toCardContent?cid="+cid;
		}else {
		return "err";
		}
		
	}
	
	@RequestMapping("commentDel")
	public String commentDel(@RequestParam() int comid) {
		Comment comment=commentService.findAllByComid(comid);
		replyService.delByComid(comid);
		commentService.delById(comid);
		int cid=comment.getCid();
		return "redirect:/toCardContent?"+"cid="+cid;
		
	}
	
	@RequestMapping("/cardDown")
	public void pdfDown(@RequestParam() int carid,HttpServletRequest request,HttpServletResponse response) throws DocumentException, IOException {
		Card comment=cardService.findById(carid);
		//1、 下载文件名
		String f=new String(comment.getContent().getBytes("iso-8859-1"),"utf-8");
		System.out.println("-------------"+f);
		//2、 不要亲⾃输出， 只要你设置好即可
		response.setHeader("Content-Type", request.getServletContext().getMimeType(f));
		response.setHeader("Content-Disposition","attachment;filename=\""+f+"\";filename*=utf-8''"+URLEncoder.encode(f, "utf-8"));		
		//3、 完成消息体
		FileUtils.copyFile(new File(request.getServletContext().getRealPath("WEB-INF/upload/word/word/"+f)),response.getOutputStream());				
		//return "redirect:/toCardContent?"+"cid="+carid;
		
	}

}

