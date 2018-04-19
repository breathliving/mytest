package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;

public interface CustomerMapper {

	int getTotalCount();

	List<Customer> getCustList(QueryVo queryVo);

	Customer getCustById(long id);

	void updateCust(Customer customer);

}
