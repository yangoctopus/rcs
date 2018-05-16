package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Cars;

import java.util.List;

public interface CarsMapper {
      List<Cars> findCarsKey(Cars cars);
      void saveCars(Cars cars);
      void updateCars(Cars cars);
      void delCars(Cars cars);

    List<Cars> loadCarsListStatus(String yes);

    void updateCarsStatus(Cars cars);

    Cars findByCarid(String carid);
}
