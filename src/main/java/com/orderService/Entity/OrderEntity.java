package com.orderService.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_service")
public class OrderEntity implements Serializable{

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="alt_key")
	private int altkey;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private int totalPrice;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="sold_date")
	private String soldDate;

	public int getAltkey() {
		return altkey;
	}

	public void setAltkey(int altkey) {
		this.altkey = altkey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [altkey=" + altkey + ", productName=" + productName + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", paymentMode=" + paymentMode + ", soldDate=" + soldDate + "]";
	}

	
	
}
