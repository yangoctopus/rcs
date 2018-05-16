package com.yzy.rcs.mapper;


import com.yzy.rcs.domain.Emodel;

import java.util.List;

public interface EmodelMapper {
	
	/**
	 * 统计出租单表中的年份
	 * **/
	public List<Emodel> loadRentsYear();
	
	/**
	 * 年对应月销售数据统计
	 * **/
	public List<Emodel> loadYearSellData(String year);

	public List<Emodel> loadAddrCount();

}
