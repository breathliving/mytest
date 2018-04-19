package com.itheima.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.BaseDictService;
import com.itheima.ssm.service.CustomerService;
import com.itheima.ssm.utils.Page;

@Controller
public class CustomerController {
	@Value(value="${customer.source}")
	private String sourceCode;
	@Value(value="${customer.industory}")
	private String industoryCode;
	@Value(value="${customer.level}")
	private String levelCode;
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
@RequestMapping("/list")

public String getCustomerList(Model model,QueryVo queryVo,@RequestParam(defaultValue="1") Integer page) throws Exception{
	//下拉框显示查询的三个条件
	List<BaseDict>fromType=baseDictService.findBaseDictBySourceCode(sourceCode);
	List<BaseDict>industryType=baseDictService.findBaseDictByIndustoryCode(industoryCode);
	List<BaseDict>levelType=baseDictService.findBaseDictByLevelCode(levelCode);
	model.addAttribute("fromType", fromType);
	model.addAttribute("industryType", industryType);
	model.addAttribute("levelType", levelType);
	String custName = queryVo.getCustName();
//	String custIndustry = queryVo.getCustIndustry();
//	if(custName!=null&&!"".equals(custName)){
//		custName=new String(custName.getBytes("iso8859-1"), "utf-8");
//		queryVo.setCustName(custName);
//	}
	//根据条件查询用户,分页展示用户
	Page<Customer>p=customerService.getCustList(queryVo,page);
	model.addAttribute("page", p);
	//将查询条件回显到页面
	model.addAttribute("custName", queryVo.getCustName());
	model.addAttribute("custSource", queryVo.getCustSource());
	model.addAttribute("custIndustry", queryVo.getCustIndustry());
	model.addAttribute("custLevel", queryVo.getCustLevel());
	return "customer";
}
//修改客户信息，先回显要修改的客户的数据
@RequestMapping("/customer/edit")
@ResponseBody
public Customer getCustomerById(long id){
	Customer customer =customerService.getCustById(id);
	return customer;
}
@RequestMapping("/customer/update")
@ResponseBody
public String updateCustomer(Customer customer){
	customerService.updateCustomer(customer);
	
	return "success";
}
}
