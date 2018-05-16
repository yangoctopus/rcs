package com.yzy.rcs.service;


import com.yzy.rcs.vo.EmodelVo;

import java.util.List;
import java.util.Map;

public interface EmodelService {

	/**
	 * 统计出租单表中的年份
	 * **/
	public List<EmodelVo> loadRentsYearService();

	/**
	 * 年对应月销售数据统计
	 * **/
	public EmodelVo loadYearSellDataService(String year);

    List<Map> loadAddrCount();
}
