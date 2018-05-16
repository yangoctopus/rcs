package com.yzy.rcs.service;

import com.yzy.rcs.domain.Cars;
import com.yzy.rcs.vo.CarsVo;
import com.yzy.rcs.vo.DataGridModel;

import java.util.List;

public interface CarsService {
    public DataGridModel<CarsVo> findCarsKey(CarsVo carsVo);
    public void saveCars(CarsVo carsVo);
    public void updateCars(CarsVo carsVo);
    public void delCars(CarsVo carsVo);

    DataGridModel<CarsVo> loadCarsListStatus(CarsVo cvo);
}
