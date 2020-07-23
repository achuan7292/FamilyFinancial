package com.family.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.dao.BankCardMapper;
import com.family.dao.BillMapper;
import com.family.dao.InvestMapper;
import com.family.domain.BankCard;
import com.family.domain.BankCardExample;
import com.family.domain.BankCardExample.Criteria;
import com.family.domain.Bill;
import com.family.domain.BillExample;
import com.family.domain.Bing;
import com.family.domain.CountBill;
import com.family.domain.DateEntity;
import com.family.domain.Invest;
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	InvestMapper investMapper;
	@Autowired
	BillMapper billMapper;
	@Autowired
	BankCardMapper bankCardMapper;
	@Override
	public void addBill(Bill bill) {
		if(bill.getbDate()==null){
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			String format = d.format(new Date());
			bill.setbDate(format);
		}
		billMapper.insertSelective(bill);
	}
	@Override
	public void addCard(BankCard card) {
		bankCardMapper.insertSelective(card);
	}
	@Override
	public List<BankCard> selectAllCard(String uid) {
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		return bankCardMapper.selectByExample(example);
	}
	@Override
	public List<Bill> selectAllBill(String uid) {
		BillExample example = new BillExample();
		com.family.domain.BillExample.Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		return billMapper.selectByExample(example);
	}
	@Override
	public List<Bill> searchDate(DateEntity date, String uid) {
		BillExample example = new BillExample();
		com.family.domain.BillExample.Criteria criteria = example.createCriteria();
		criteria.andBDateBetween(date.getStart(), date.getEnd());
		criteria.andUidEqualTo(uid);
		return billMapper.selectByExample(example);
	}
	@Override
	public CountBill selectCount(String uid) {
		BillExample example = new BillExample();
		com.family.domain.BillExample.Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andBKindsEqualTo(0);
		Double double1 = billMapper.countByExample(example);
		BillExample example2 = new BillExample();
		com.family.domain.BillExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andUidEqualTo(uid);
		criteria2.andBKindsEqualTo(1);
		Double double2 = billMapper.countByExample(example2);
		CountBill count = new CountBill();
		count.setTotal(double1);
		count.setTotal2(double2);
		return count;
	}
	@Override
	public void deleteCard(Integer cid) {
		bankCardMapper.deleteByPrimaryKey(cid);
	}
	@Override
	public List<Bing> selectAllBing(String uid,int id) {
		BillExample example = new BillExample();
		com.family.domain.BillExample.Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andBKindsEqualTo(id);
		List<Bill> list = billMapper.selectByExample(example);
		List<Bing> list2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Bing bing = new Bing();
			bing.setName(list.get(i).getbDesc());
			bing.setValue(list.get(i).getbMoney());
			list2.add(bing);
		}
		return list2;
	}
	@Override
	public List<Invest> findAllInvest() {
		return investMapper.selectByExample(null);
	}
	@Override
	public Invest findMyInvest(Integer id) {
		return investMapper.selectByPrimaryKey(id);
	}
	@Override
	public void deleteBill(Integer bid) {
		billMapper.deleteByPrimaryKey(bid);
	}
	//理财功能自动收益的核心代码
	@Override
	public void updateDataBase() {
		BillExample example = new BillExample();
		com.family.domain.BillExample.Criteria criteria = example.createCriteria();
		//表示的是财产的支出
		criteria.andBKindsEqualTo(0);
		//模糊查询是投资的产品
		criteria.andBDescLike("%"+"投资产品"+"%");
		//mybatis查询数据库
		List<Bill> list = billMapper.selectByExample(example);
		//新建实体
		Bill bill2 = new Bill();
		//设置财产收入
		bill2.setbKinds(1);
		//设置类型为投资收益
		bill2.setbDesc("投资收益");
		//创建日期格式
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		String format = d.format(new Date());
		bill2.setbDate(format);

		//遍历的到的list集合
		for (Bill bill : list) {
			bill2.setUid(bill.getUid());
			double money = bill.getbMoney()*0.02;
			bill2.setbMoney(money);
			//插入到表中
			billMapper.insertSelective(bill2);
		}
		
	}

}
