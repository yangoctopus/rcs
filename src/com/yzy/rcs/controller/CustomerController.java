package com.yzy.rcs.controller;

import com.yzy.rcs.service.CustomerService;
import com.yzy.rcs.vo.CustomerVo;
import com.yzy.rcs.vo.DataGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/loadCustomerManager.action")
    public String loadCustomerManager(){
        return "WEB-INF/jsp/customer/customerManager.jsp";
    }

    @RequestMapping("/findCustomerKey")
    @ResponseBody
    public DataGridModel<CustomerVo> findCustomerKey(CustomerVo customerVo){
        return customerService.findCustomerKey(customerVo);
    }

    @RequestMapping("/saveCustomer")
    @ResponseBody
    public Map<String,String> saveCustomer(CustomerVo customerVo){
        Map<String,String> map=new HashMap<>();
        try{
            customerService.saveCustomer(customerVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/updateCustomer")
    @ResponseBody
    public Map<String,String> updateCustomer(CustomerVo customerVo){
        Map<String,String> map=new HashMap<>();
        try{
            customerService.updateCustomer(customerVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/delCustomer")
    @ResponseBody
    public Map<String,String> delCustomer(CustomerVo customerVo){
        Map<String,String> map=new HashMap<>();
        try{
            customerService.delCustomer(customerVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }

    /***
     * 处理验证客户是否存在的请求
     * **/
    @RequestMapping("/checkConsumer")
    @ResponseBody
    public String checkConsumer(String identity){
        CustomerVo cvo =customerService.findById(identity);
        if(cvo!=null){
            return "success";
        }
        return "error";
    }

}
