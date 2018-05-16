package com.yzy.rcs.controller;

import com.yzy.rcs.service.EmodelService;
import com.yzy.rcs.vo.EmodelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class EmodelController {

	@Autowired
	private EmodelService emodelService;
	
	/***
	 * 处理加载年份选项卡的请求
	 * **/
	@RequestMapping("/loadRentYear")
	public String loadRentYear(Model model){
		List<EmodelVo> evoList=emodelService.loadRentsYearService();
		model.addAttribute("evoList", evoList);
		return "WEB-INF/jsp/emodel/sellCount.jsp";
	}



    @RequestMapping("/loadCustAddr")
    public String loadCustAddr(){
        return "WEB-INF/jsp/emodel/custAddr.jsp";
    }

	/**
	 * 处理年对应月销售数据统计的请求
	 * **/
	@RequestMapping("/loadSellData")
	@ResponseBody
	public EmodelVo loadSellData(String year){
		
		return emodelService.loadYearSellDataService(year);
	}

    @RequestMapping("/loadAddrCount")
    @ResponseBody
    public List<Map> loadAddrCount(){
        return emodelService.loadAddrCount();
    }
}
