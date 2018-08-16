package com.pizza.action;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.stereotype.Controller;

import com.pizza.domain.Customer;
import com.pizza.domain.Order;
import com.pizza.domain.Payment;
import com.pizza.domain.PaymentDetails;
import com.pizza.service.CustomerNotFoundException;

@Controller
public class PizzaFlowActions {
	
	/**
	 * 查询顾客
	 * @param phoneNumber
	 * @return
	 */
	public Customer lookupCustomer(String phoneNumber){
		
		Customer customer = new Customer();
		
		if(phoneNumber.equals("1234567890")){
			customer.setPhoneNumber(phoneNumber);
			customer.setAddress("xxxx地址");
			customer.setCity("天津");
			customer.setName("张三");
			customer.setState(0);
			customer.setZipCode(300000);
		}else{
			throw new CustomerNotFoundException();
		}
		return customer;
	}
	
	/**
	 * 检查配送地址是否在配送范围
	 * 300000为天津邮编
	 * @param zipCode
	 * @return
	 */
	public Boolean checkDeliveryArea(int zipCode){
		if(zipCode==300000)
			return true;
		else 
			return false;
	}
	
	/**
	 * 添加客户
	 * @param customer
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void addCustomer(Customer customer) throws IllegalArgumentException, IllegalAccessException{
		Field[] fields = customer.getClass().getDeclaredFields();
		for(Field field : fields){
			if(!Modifier.isFinal(field.getModifiers()))
				System.out.println(field.getName()+":"+field.get(customer));
		}
	}
	
	/**
	 * 处理支付细节
	 * @param details
	 * @return
	 */
	public Payment verifyPayment(PaymentDetails details){
		Payment payment = new Payment();
		payment.setPaymentDetails(details);
		return payment;
	}
	
	public void save(Order order) throws IllegalArgumentException, IllegalAccessException{
		System.out.println("------保存订单--------");
		Field[] fields = order.getClass().getDeclaredFields();
		for(Field field : fields){
			if(!Modifier.isFinal(field.getModifiers()))
				System.out.println(field.getName()+":"+field.get(order));
		}
	}
}
