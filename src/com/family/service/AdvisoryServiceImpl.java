package com.family.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.dao.AdvisoryMapper;
import com.family.domain.Advisory;
import com.family.domain.AdvisoryExample;
import com.family.domain.AdvisoryExample.Criteria;

@Service
public class AdvisoryServiceImpl implements AdvisoryService {

	@Autowired
	AdvisoryMapper AdvisoryMapper;
	@Override
	public Integer insertAdvisory(Advisory advisory) {
		advisory.setCdate(new Date());
		return AdvisoryMapper.insertSelective(advisory);
	}
	@Override
	public List<Advisory> selectAll(String uid) {
		return AdvisoryMapper.selectByExample(null);
	}
	@Override
	public Advisory selectAdById(Integer cid) {
		return AdvisoryMapper.selectByPrimaryKey(cid);
	}
	@Override
	public void deleteAd(Integer cid) {
		AdvisoryMapper.deleteByPrimaryKey(cid);
	}
	@Override
	public List<Advisory> search(String keywords) {
		AdvisoryExample example = new AdvisoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andHeadlineLike("%"+keywords+"%");
		return AdvisoryMapper.selectByExample(example );
	}

}
