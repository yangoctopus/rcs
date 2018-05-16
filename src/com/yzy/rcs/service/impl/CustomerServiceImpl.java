package com.yzy.rcs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.Customer;
import com.yzy.rcs.mapper.CustomerMapper;
import com.yzy.rcs.service.CustomerService;
import com.yzy.rcs.vo.CustomerVo;
import com.yzy.rcs.vo.DataGridModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public DataGridModel<CustomerVo> findCustomerKey(CustomerVo customerVo) {
        //执行分页操作
        Page page= PageHelper.startPage(customerVo.getPage(),customerVo.getRows());
        //查询数据库
        List<Customer> clist = customerMapper.findCustomerKey(customerVo);
        List<CustomerVo> cvolist = new ArrayList<>();
        for(Customer c:clist){
            CustomerVo cvo=new CustomerVo();
            BeanUtils.copyProperties(c,cvo);
            cvolist.add(cvo);
        }
        DataGridModel<CustomerVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(cvolist);
        return dgm;
    }

    @Override
    public void saveCustomer(CustomerVo customerVo) {
        this.customerMapper.saveCustomer(customerVo);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        this.customerMapper.updateCustomer(customerVo);
    }

    @Override
    public void delCustomer(CustomerVo customerVo) {
        this.customerMapper.delCustomer(customerVo);
    }

    @Override
    public CustomerVo findById(String identity) {
        Customer customer=customerMapper.findById(identity);
        CustomerVo cvo=new CustomerVo();
        BeanUtils.copyProperties(customer,cvo);
        return cvo;
    }
}
