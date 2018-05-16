package com.yzy.rcs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.Cars;
import com.yzy.rcs.domain.Checks;
import com.yzy.rcs.domain.Customer;
import com.yzy.rcs.domain.Rents;
import com.yzy.rcs.mapper.CarsMapper;
import com.yzy.rcs.mapper.ChecksMapper;
import com.yzy.rcs.mapper.CustomerMapper;
import com.yzy.rcs.mapper.RentsMapper;
import com.yzy.rcs.service.ChecksService;
import com.yzy.rcs.utils.DateUtils;
import com.yzy.rcs.vo.ChecksVo;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RentsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecksServiceImpl implements ChecksService {

	@Autowired
	private CarsMapper carsMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private RentsMapper rentsMapper;
	@Autowired
	private ChecksMapper checksMapper;
	
	
	
	@Override
	public Map<String, Object> loadCheckData(String rentid,String username) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		
		//获得出租单信息
		Rents rents=rentsMapper.loadRentsRentid(rentid);
		//获得客户信息
		Customer customer=customerMapper.findById(rents.getCustid());
		//获得车辆信息
		Cars cars=carsMapper.findByCarid(rents.getCarid());
		
		//创建检查单对象
		Checks cks=new Checks();
		cks.setCheckid(DateUtils.randomId());
		cks.setCheckdate(DateUtils.getFormatDate());
		cks.setUsername(username);
		
		
		map.put("rents", rents);
		map.put("customer", customer);
		map.put("cars", cars);
		map.put("cks", cks);

		return map;
	}

    @Override
    public void saveChecks(ChecksVo cvo) {
        // TODO Auto-generated method stub

        //修改车辆状态
        Cars cars = new Cars();
        cars.setIsrenting("YES");
        cars.setCarnumber(cvo.getCarnumber());
        carsMapper.updateCarsStatus(cars);

        //修改出租单状态
        Rents rents = new Rents();
        System.out.println("========="+cvo.getRentid());
        rents.setRentid(cvo.getRentid());
        rents.setRentflag("已归还");
        rentsMapper.updateRentsStatus(rents);


        //保存出租单信息
        checksMapper.saveChecks(cvo);
    }

    @Override
    public DataGridModel<ChecksVo> findAllChecks(ChecksVo cvo) {
        // TODO Auto-generated method stub
        //进行分页查询
        Page page= PageHelper.startPage(cvo.getPage(), cvo.getRows());

        List<Checks> clist = checksMapper.findAllChecks();

        List<ChecksVo> cvoList = new ArrayList<>();

        for(Checks c:clist){
            ChecksVo vo = new ChecksVo();
            BeanUtils.copyProperties(c, vo);

            cvoList.add(vo);
        }

        DataGridModel<ChecksVo> dgm = new DataGridModel<ChecksVo>();

        dgm.setRows(cvoList);
        dgm.setTotal((int) page.getTotal());
        return dgm;
    }

    @Override
    public void updateChecks(ChecksVo cvo) {
        checksMapper.updateChecks(cvo);
    }


}
