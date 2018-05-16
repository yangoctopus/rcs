package com.yzy.rcs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.Cars;
import com.yzy.rcs.domain.Rents;
import com.yzy.rcs.mapper.CarsMapper;
import com.yzy.rcs.mapper.RentsMapper;
import com.yzy.rcs.service.RentsService;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RentsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RentsServiceImpl implements RentsService{
    @Autowired
    private RentsMapper rentsMapper;
    @Autowired
    private CarsMapper carsMapper;
    @Override
    public DataGridModel<RentsVo> findAllRents(RentsVo rentsVo) {
        Page page= PageHelper.startPage(rentsVo.getPage(),rentsVo.getRows());
        List<RentsVo> rvolist=new ArrayList<>();
        List<Rents> rlist=rentsMapper.findAllRents(rentsVo);
        for(Rents r:rlist){
            RentsVo rvo=new RentsVo();
            BeanUtils.copyProperties(r,rvo);
            rvolist.add(rvo);
        }
        DataGridModel<RentsVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(rvolist);
        return dgm;
    }

    @Override
    public void saveRents(RentsVo rentsVo) {
        Cars cars = new Cars();
        cars.setIsrenting("NO");
        cars.setCarnumber(rentsVo.getCarid());

        //修改车辆状态
        carsMapper.updateCarsStatus(cars);

        //保存出租单信息
        rentsVo.setRentflag("已出租");
        rentsMapper.saveRents(rentsVo);
    }

    @Override
    public void updateRents(RentsVo rentsVo) {
        if(!"未出租".equals(rentsVo.getRentflag())){
            Cars cars = new Cars();
            cars.setIsrenting("NO");
            cars.setCarnumber(rentsVo.getCarid());
            carsMapper.updateCarsStatus(cars);
        }

        rentsMapper.updateRents(rentsVo);
    }

    @Override
    public void delRents(RentsVo rentsVo) {
        rentsMapper.delRents(rentsVo);
    }

    @Override
    public RentsVo loadRentsByRentid(String rentid) {
        RentsVo rentsVo=new RentsVo();
        Rents rents=rentsMapper.loadRentsRentid(rentid);
        BeanUtils.copyProperties(rents,rentsVo);
        return rentsVo;
    }
}
