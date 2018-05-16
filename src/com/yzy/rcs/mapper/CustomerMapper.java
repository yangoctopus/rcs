package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Customer;

import java.util.List;

public interface CustomerMapper {
List<Customer> findCustomerKey(Customer Customer);

    void saveCustomer(Customer Customer);

    void updateCustomer(Customer Customer);

    void delCustomer(Customer Customer);

    Customer findById(String identity);
}
