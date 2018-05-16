package com.yzy.rcs.service;

import com.yzy.rcs.domain.Customer;
import com.yzy.rcs.vo.CustomerVo;
import com.yzy.rcs.vo.DataGridModel;

import java.util.List;

public interface CustomerService {
    public DataGridModel<CustomerVo> findCustomerKey(CustomerVo customerVo);
    public void saveCustomer(CustomerVo customerVo);
    public void updateCustomer(CustomerVo customerVo);
    public void delCustomer(CustomerVo customerVo);

    CustomerVo findById(String identity);
}
