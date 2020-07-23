package com.family.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.family.domain.AdImage;
import com.family.domain.Advisory;
import com.family.domain.Result;
import com.family.domain.User;
import com.family.service.AdvisoryService;

@RestController
@RequestMapping("advisory")
public class AdvisoryController {
	
	@Autowired
	AdvisoryService advisoryService;
	@RequestMapping("addAdvisory")
	public AdImage addAdvisory(@RequestBody Advisory advisory,HttpSession session) throws IllegalStateException, IOException{
		User user2 = (User) session.getAttribute("user");
		advisory.setUid(user2.getUid());
		//执行service
		try {
			Integer id = this.advisoryService.insertAdvisory(advisory);
			return new AdImage(null, true, id);
		} catch (Exception e) {
			return new AdImage(null, false, null);
		}
	}
	@RequestMapping("upload")
	public AdImage upload(MultipartFile file,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
		User user2 = (User) session.getAttribute("user");
		boolean empty = file.isEmpty();
		if(!empty){
			// 图片上传
			// 设置图片名称，不能重复，可以使用uuid
			String picName = UUID.randomUUID().toString().replaceAll("-", "");;
			// 获取文件名
			String oriName = file.getOriginalFilename();
			// 获取图片后缀
			String extName = oriName.substring(oriName.lastIndexOf("."));
			//保存的服务器地址
			String path = request.getSession().getServletContext().getRealPath("/");
			file.transferTo(new File(path+"advisory//"+picName+extName));
			return new AdImage(picName+extName,true,null);
			
		}else{
			return new AdImage(null, false, null);
		}
		//执行service
		/*try {
			this.advisoryService.insertAdvisory(advisory);
			return new Result(true, "picName+extName");
		} catch (Exception e) {
			return new Result(false, "添加失败");
		}*/
	}
	@RequestMapping("selectAll")
	public List<Advisory> selectAll(HttpSession session){
		User user2 = (User) session.getAttribute("user");
		return advisoryService.selectAll(user2.getUid());
		
	}
	

	@RequestMapping("selectAdById")
	public Advisory selectAdById(HttpSession session){
		Integer cid = (Integer) session.getAttribute("cid");
		
		Advisory advisory = advisoryService.selectAdById(cid);
		return advisory;
		
	}
	
	@RequestMapping("myCid")
	public void myCid(Integer cid,HttpSession session){
		session.setAttribute("cid", cid);
	}
	@RequestMapping("deleteAd")
	public Result deleteAd(Integer cid){
		advisoryService.deleteAd(cid);
		return new Result(true, "删除成功");
		
	}
	@RequestMapping("search")
	public List<Advisory> search(String keywords){
		List<Advisory> advisorys = advisoryService.search(keywords);
		return 	advisorys;
		
	}
}

