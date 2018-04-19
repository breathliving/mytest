package com.itheima.ssm.service;

import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.utils.Page;

public interface CustomerService {

	Page<Customer> getCustList(QueryVo queryVo, int pageNum);

	Customer getCustById(long id);

	void updateCustomer(Customer customer);

}
