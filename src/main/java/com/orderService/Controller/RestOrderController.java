package com.orderService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.Entity.OrderEntity;
import com.orderService.ServiceImp.OrderServiceImp;

@RestController
public class RestOrderController {

	@Autowired
	private OrderServiceImp service;
	
	@PostMapping(value="/process")
	public void processOrder(@RequestBody OrderEntity oe) {
		service.processOrder(oe);
	}
	
	@GetMapping(value="/getOrders")
	public List<OrderEntity> getAllOrders(){
		return service.getAllOrders();
	}
	
	@GetMapping(value="/getOrderById/{altkey}")
	public List<OrderEntity> getOrderById(@PathVariable("altkey") int id){
		return service.getOrderById(id);
	}
	
	@GetMapping(value="/getOrderByName")
	public List<OrderEntity> getOrderByName(@RequestParam("productName") String name){
		return service.getOrderByName(name);
	}
	
	@GetMapping(value="/getRange")
	public List<OrderEntity> getProductsInRange(@RequestParam("lp") int lp,@RequestParam("hp") int hp){
		return service.getProductsInRange(lp,hp);
	}
	
	@DeleteMapping(value="/delete/{altkey}")
	public void deleteOrderById(@PathVariable("altkey") int id) {
		service.deleteOrderById(id);
	}
	
	@PutMapping(value="/update")
	public void updatePriceByName(@RequestParam("totalPrice") int price,@RequestParam("prodcutName") String name) {
		service.updatePriceByName(price,name);
	}
	
	@GetMapping(value="/sortByName")
	public List<OrderEntity> getOrdersSortedByName(@RequestBody OrderEntity oe){
		return service.getOrdersSortedByName(oe);
	}
	
}
