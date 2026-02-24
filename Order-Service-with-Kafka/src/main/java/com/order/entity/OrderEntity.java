package com.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class OrderEntity {
	
	private String id;
	private String itemName;
	private String description;
	private String status;

}
