package com.family.service;

import java.util.List;

import com.family.domain.BankCard;
import com.family.domain.Bill;
import com.family.domain.Bing;
import com.family.domain.CountBill;
import com.family.domain.DateEntity;
import com.family.domain.Invest;

public interface BillService {

	void addBill(Bill bill);

	void addCard(BankCard card);

	List<BankCard> selectAllCard(String uid);

	List<Bill> selectAllBill(String uid);

	List<Bill> searchDate(DateEntity date, String uid);

	CountBill selectCount(String uid);

	void deleteCard(Integer cid);

	List<Bing> selectAllBing(String uid, int i);

	List<Invest> findAllInvest();

	Invest findMyInvest(Integer id);

	void deleteBill(Integer bid);

	void updateDataBase();

}
