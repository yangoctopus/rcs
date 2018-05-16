package com.yzy.rcs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.Cars;
import com.yzy.rcs.mapper.CarsMapper;
import com.yzy.rcs.service.CarsService;
import com.yzy.rcs.vo.CarsVo;
import com.yzy.rcs.vo.DataGridModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarsServiceImpl implements CarsService{
    @Autowired
    private CarsMapper carsMapper;
    @Override
    public DataGridModel<CarsVo> findCarsKey(CarsVo carsVo) {
        //执行分页
        Page page= PageHelper.startPage(carsVo.getPage(),carsVo.getRows());
        //查询数据库
        List<Cars> clist=carsMapper.findCarsKey(carsVo);
        List<CarsVo> cvolist=new ArrayList<>();
        for(Cars c:clist){
            CarsVo cvo=new CarsVo();
            BeanUtils.copyProperties(c,cvo);
            cvolist.add(cvo);
        }
        DataGridModel<CarsVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(cvolist);
        return dgm;
    }

    @Override
    public void saveCars(CarsVo carsVo) {
        this.carsMapper.saveCars(carsVo);
    }

    @Override
    public void updateCars(CarsVo carsVo) {
        this.carsMapper.updateCars(carsVo);
    }

    @Override
    public void delCars(CarsVo carsVo) {
        this.carsMapper.delCars(carsVo);
    }

    @Override
    public DataGridModel<CarsVo> loadCarsListStatus(CarsVo cvo) {
        List<CarsVo> cvoList=new ArrayList<CarsVo>();

        //执行分页查询
        Page page=PageHelper.startPage(cvo.getPage(),cvo.getRows());

        //查询数据库
        List<Cars> clist=carsMapper.loadCarsListStatus("YES");

        for(Cars c:clist){
            CarsVo vo = new CarsVo();
            BeanUtils.copyProperties(c, vo);

            cvoList.add(vo);
        }

        DataGridModel<CarsVo> dgm=new DataGridModel<CarsVo>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(cvoList);
        return dgm;
    }
}
