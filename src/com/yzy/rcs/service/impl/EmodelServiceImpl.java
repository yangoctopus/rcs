package com.yzy.rcs.service.impl;


import com.yzy.rcs.domain.Emodel;
import com.yzy.rcs.mapper.EmodelMapper;
import com.yzy.rcs.service.EmodelService;
import com.yzy.rcs.vo.EmodelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmodelServiceImpl implements EmodelService {

	@Autowired
	private EmodelMapper emodelMapper;
	
	@Override
	public List<EmodelVo> loadRentsYearService() {
		// TODO Auto-generated method stub
		List<EmodelVo> evoList=new ArrayList<EmodelVo>();
		
		List<Emodel> elist = emodelMapper.loadRentsYear();
		
		for(Emodel e:elist){
			EmodelVo evo = new EmodelVo();
			BeanUtils.copyProperties(e, evo);
			
			evoList.add(evo);
		}
		return evoList;
	}

	@Override
	public EmodelVo loadYearSellDataService(String year) {
		// TODO Auto-generated method stub
		String[] month={"一月","二月","三月","四月","五月",
				"六月","七月","八月","九月","十月","十一月","十二月"};
		
		List<Emodel> elist=emodelMapper.loadYearSellData(year);
		
		
		EmodelVo evo=new EmodelVo();
		evo.setXaxis(month);
		//int index=0;
		for(Emodel e:elist){
			
			evo.getYayis()[Integer.parseInt(e.getMh())-1]=e.getTotal();
			//index++;
		}
		
		
		return evo;
	}

    @Override
    public List<Map> loadAddrCount() {
	    List<Map> mlist=new ArrayList<>();
        List<Emodel> elist = emodelMapper.loadAddrCount();
        System.out.println(elist.toString());
        Map<String,Object> emap;
        for(Emodel e:elist){
            emap=new HashMap<>();
            emap.put("name",e.getAddress());
            emap.put("value",e.getCount());
            mlist.add(emap);
        }

        System.out.println(mlist);
        return mlist;
    }

}
