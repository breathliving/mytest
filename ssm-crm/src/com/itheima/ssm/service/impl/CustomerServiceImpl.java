package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.mapper.CustomerMapper;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.CustomerService;
import com.itheima.ssm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public Page<Customer> getCustList(QueryVo queryVo,int pageNum) {
		int rows = queryVo.getRows();
		queryVo.setStart((pageNum-1)*rows);
		//查询总记录数
		int total= customerMapper.getTotalCount();
		//查询符合条件的用户
		List<Customer>list=customerMapper.getCustList(queryVo);
		Page<Customer>page=new Page<>();
		page.setRows(list);
		page.setTotal(total);
		page.setPage(pageNum);
		page.setSize(rows);
		return page;
	}
	@Override
	public Customer getCustById(long id) {
		
		return customerMapper.getCustById(id);
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCust(customer);
	}

}
