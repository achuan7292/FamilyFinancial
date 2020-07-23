package com.family.service;

import java.util.List;

import com.family.domain.Advisory;

public interface AdvisoryService {

	Integer insertAdvisory(Advisory advisory);

	List<Advisory> selectAll(String string);

	Advisory selectAdById(Integer cid);

	void deleteAd(Integer cid);

	List<Advisory> search(String keywords);

}
