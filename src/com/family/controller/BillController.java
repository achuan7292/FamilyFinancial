package com.family.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.domain.Advisory;
import com.family.domain.BankCard;
import com.family.domain.Bill;
import com.family.domain.Bing;
import com.family.domain.CountBill;
import com.family.domain.DateEntity;
import com.family.domain.Invest;
import com.family.domain.Result;
import com.family.domain.User;
import com.family.service.BillService;
import com.family.service.UserService;

@RestController
@RequestMapping("bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	//添加账单
	
	@RequestMapping("add")
	public Result addBill(@RequestBody Bill bill,HttpSession session){
		//判断金额
		if(bill.getbMoney()>1000000){
			return new Result(false, "添加失败,金额过大");
		}else{
			User user = (User) session.getAttribute("user");
			bill.setUid(user.getUid());
			if(bill.getbDesc()==null){
				Integer id  = (Integer) session.getAttribute("id");
				Invest invest = billService.findMyInvest(id);
				bill.setbDesc(invest.getIname());
				//判断底金
				if(bill.getbMoney()<=invest.getIbasic())
					return new Result(false, "底金不足");
			}
			try {
				billService.addBill(bill);
				return new Result(true, "添加成功");
			} catch (Exception e) {
				return new Result(false, "添加失败");
			}
		}
	}
	
	//添加银行卡
	@RequestMapping("addCard")
	public Result addCard(@RequestBody BankCard card,HttpSession session){
		User user = (User) session.getAttribute("user");
		card.setUid(user.getUid());
		try {
			String string = card.getCnumber().toString();
			if(string.length()>15&&string.length()<19){
				billService.addCard(card);
				return new Result(true, "添加成功");
			}else{
				return new Result(false, "添加失败");
			}
		} catch (Exception e) {
			return new Result(false, "添加失败");
		}
	}
	
	//查询所有银行卡
	@RequestMapping("selectAllCard")
	public List<BankCard> selectAllCard(HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("user");
		List<BankCard> allCard = billService.selectAllCard(user.getUid());
		return allCard;
					
	}
	
	//查询所有账单
	@RequestMapping("selectAllBill")
	public List<Bill> selectAllBill(HttpSession session){
		User user = (User) session.getAttribute("user");
		//根据用户id查询
		List<Bill> allCard = billService.selectAllBill(user.getUid());
		return allCard;
		
	}
	
	@RequestMapping("searchDate")
	public List<Bill> searchDate(@RequestBody DateEntity date, HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Bill> allCard = billService.searchDate(date,user.getUid());
		return allCard;
		
	}
	
	@RequestMapping("selectCount")
	public CountBill selectCount(HttpSession session){
		User user = (User) session.getAttribute("user");
		CountBill countBill = billService.selectCount(user.getUid());
		return countBill;
		
	}
	
	@RequestMapping("deleteCard")
	public Result deleteCard(Integer cid){
		try {
			billService.deleteCard(cid);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			return new Result(false, "添加失败");
		}
	}
	
	//删除的方法
	@RequestMapping("deleteBill")
	public Result deleteBill(Integer bid){
		try {
			billService.deleteBill(bid);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("selectBing")
	public List<Bing> selectBing(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Bing> bings = billService.selectAllBing(user.getUid(),1);
		return bings;
	}
	
	@RequestMapping("selectBing1")
	public List<Bing> selectBing1(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Bing> bings = billService.selectAllBing(user.getUid(),0);
		return bings;
	}
	
	
	@RequestMapping("findAllInvest")
	public List<Invest> findAllInvest(){
		List<Invest> invests = billService.findAllInvest();
		return invests;
	}
	
	//投资的请求
	@RequestMapping("invest")
	public void invest(Integer id,HttpSession session){
		session.setAttribute("id", id);
	}
	

	@RequestMapping("findMyInvest")
	public Invest findMyInvest(HttpSession session){
		Integer id  = (Integer) session.getAttribute("id");
		Invest invest = billService.findMyInvest(id);
		return invest;
	}
	
}
