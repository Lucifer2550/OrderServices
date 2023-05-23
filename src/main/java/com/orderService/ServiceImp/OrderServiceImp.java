package com.orderService.ServiceImp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderService.Dto.OrderDto;
import com.orderService.Entity.OrderEntity;
import com.orderService.Repository.OrderRepository;

@Service
public class OrderServiceImp {

	@Autowired
	private OrderRepository repository ;
	
	public void processOrder(OrderEntity oe) {
		repository.processOrder(oe);
	}
	
	public List<OrderEntity> getAllOrders(){
		return repository.getAllOrders();
	}
	
	public List<OrderEntity> getOrderById(int id){
		return repository.getOrderById(id);
	}
	
	public List<OrderEntity> getOrderByName(String name){
		return repository.getOrderByName(name);
	}
	
	public List<OrderEntity> getProductsInRange(int lp,int hp){
		return repository.getProductsInRange(lp, hp);
	}
	
	public void deleteOrderById(int id) {
		repository.deleteOrderById(id);
	}
	public void updatePriceByName(int price,String name) {
		repository.updatePriceByName(price, name);
	}
	
	public List<OrderEntity> getOrdersSortedByName(OrderEntity oe){
		
		List<OrderEntity> list = repository.getOrdersSortedByName(oe);
		
		return list.stream().sorted((e1,e2)->{
			return e1.getProductName().compareToIgnoreCase(e2.getProductName());}).collect(Collectors.toList());
		}
		
	//----------------------xxxxxxxxxxxxxxxxxxx-------------
	
//	@Autowired
//	private RestTemplate rt;
//	
//	public String processOrder(OrderDto dto) {
//		
//		OrderEntity oe=new OrderEntity();
//		oe.setProductId(oe.getProductId());
//		oe.setQuantity(oe.getQuantity());
//		oe.setTotalPrice(0);
//		oe.setPaymentMode(oe.getPaymentMode());
//		oe.setSoldDate(new Date());
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("http://localhost:8080/productService/findProductPriceByProductId/");
//		sb.append(dto.getProductId());
//		
//		
//		Integer productPrice = rt.getForObject(sb.toString(), Integer.class);
//		System.out.println("ProductPrice :" +productPrice);
//		oe.setTotalPrice((productPrice * dto.getQuantity()));
//		
//		return "Order Placed Successfully";
//	
//	}
	
}

