package com.family.dao;

import com.family.domain.Advisory;
import com.family.domain.AdvisoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvisoryMapper {
    int countByExample(AdvisoryExample example);

    int deleteByExample(AdvisoryExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Advisory record);

    int insertSelective(Advisory record);

    List<Advisory> selectByExample(AdvisoryExample example);

    Advisory selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Advisory record, @Param("example") AdvisoryExample example);

    int updateByExample(@Param("record") Advisory record, @Param("example") AdvisoryExample example);

    int updateByPrimaryKeySelective(Advisory record);

    int updateByPrimaryKey(Advisory record);
}